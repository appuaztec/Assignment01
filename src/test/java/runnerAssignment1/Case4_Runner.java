package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.FramesPage;
import pageObjects.WindowsPage;

import java.util.HashMap;
import java.util.Map;

public class Case4_Runner {

    TestNgHooks testNgHooks = null;
    FramesPage framesPage = null;
    BaseSession session = null;


    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Frames");
        params.put("reportTestName", "Frames");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Frames.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.framesPage = testNgHooks.framesPage;

    }

    @Test(enabled = false)

    public void caseTest3() throws Exception {

        framesPage.frameValidation();

    }

    @Test(enabled = true)

    public void caseTest4() throws Exception {

        framesPage.frameValidationMultiple();
    }


    @AfterMethod
    public void after(ITestResult result) {

       // testNgHooks.after(result);
    }

}


