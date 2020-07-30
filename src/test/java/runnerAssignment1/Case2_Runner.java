package runnerAssignment1;

import baseInit.TestNgHooks;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;

import java.util.HashMap;
import java.util.Map;

public class Case2_Runner {

    TestNgHooks testNgHooks = null;
    AlertsPage alertsPage = null;

    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Alerts");
        params.put("reportTestName", "Alerts");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Alerts.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.alertsPage = testNgHooks.alertsPage;
    }

    @Test
    public void caseTest1() throws Exception {
        alertsPage.performAlerts();
        //alertsPage.performAlertsOandC();
    }

    @AfterMethod
    public void after(ITestResult result) {

        testNgHooks.after(result);
    }
}
