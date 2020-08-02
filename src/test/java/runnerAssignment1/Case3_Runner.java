package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.PropertyReader;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.WindowsPage;

import java.util.HashMap;
import java.util.Map;

public class Case3_Runner {

    TestNgHooks testNgHooks = null;
    WindowsPage WindowsPage = null;
    BaseSession session = null;
    PropertyReader propertyReader =
            new PropertyReader(
                    System.getProperty("user.dir") +
                            "\\src\\main\\resources\\properties\\Assignment1.properties");

    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Window Switch");
        params.put("reportTestName", "Window Switch");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", propertyReader.readProperty("case3_url"));
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.WindowsPage = testNgHooks.windowsPage;

    }

    @Test(enabled = true)

    public void caseTest3() throws Exception {

        WindowsPage.windowTabbed();
    }
    @Test(enabled = true)

    public void caseTest4() throws Exception {

        WindowsPage.separateWindow();
    }

    @Test

    public void caseTest41() throws Exception {

        WindowsPage.separateMultipleWindow();
    }


    @AfterMethod
    public void after(ITestResult result) {

        testNgHooks.after(result);
    }

}


