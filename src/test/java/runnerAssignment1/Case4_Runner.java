package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.PropertyReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.FramesPage;

import java.util.HashMap;
import java.util.Map;

public class Case4_Runner {

    TestNgHooks testNgHooks = null;
    FramesPage framesPage = null;
    BaseSession session = null;
    PropertyReader propertyReader =
            new PropertyReader(
                    System.getProperty("user.dir") +
                            "\\src\\main\\resources\\properties\\Assignment1.properties");



    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "framesPage");
        params.put("reportTestName", "framesPage");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", propertyReader.readProperty("case4_url"));
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.framesPage = testNgHooks.framesPage;

    }

    @Test()

    public void caseTest3() throws Exception {

        framesPage.frameValidation();
        framesPage.frameValidationMultiple();

    }

    @AfterMethod
    public void after(ITestResult result) {

         testNgHooks.after(result);
    }

}


