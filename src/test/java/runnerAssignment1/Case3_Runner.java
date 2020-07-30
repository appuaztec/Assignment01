package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.WindowsPage;

import java.util.HashMap;
import java.util.Map;

public class Case3_Runner {

    TestNgHooks testNgHooks = null;
    WindowsPage WindowsPage = null;
    BaseSession session = null;


    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Window Switch");
        params.put("reportTestName", "Window Switch");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Windows.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.WindowsPage = testNgHooks.windowsPage;

    }

    @Test(enabled = false)

    public void caseTest3() throws Exception {

        WindowsPage.windowTabbed();
    }
    @Test(enabled = false)

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


