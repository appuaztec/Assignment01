package runnerAssignment1;

import baseInit.TestNgHooks;
import common.PropertyReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.GilletteLogin;

import java.util.HashMap;
import java.util.Map;

public class Case7_Runner {
    TestNgHooks testNgHooks = null;
    GilletteLogin gilletteLogin = null;
    PropertyReader propertyReader =
            new PropertyReader(
                    System.getProperty("user.dir") +
                            "\\src\\main\\resources\\properties\\Assignment1.properties");


    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Gillette Login");
        params.put("reportTestName", "Gillette Login");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", propertyReader.readProperty("case7_url"));
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.gilletteLogin = testNgHooks.GilletteLogin;
    }

    @Test
    public void caseTest1() throws Exception {
        gilletteLogin.GilletteIndia();
        //alertsPage.performAlertsOandC();
    }

    @AfterMethod
    public void after(ITestResult result) {

        testNgHooks.after(result);
    }
}


