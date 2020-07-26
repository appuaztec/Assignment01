package runnerAssignment1;

import baseInit.BaseSession;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;
import pageObjects.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class Case2_Runner {

    public BaseSession session = null;
    public AlertsPage alertsPage = null;

    @BeforeTest
    public void before() {
        Map<String,String> config = new HashMap<String, String>();
        config.put("browser","chrome");
        config.put("url","http://demo.automationtesting.in/Alerts.html");
        this.session = new BaseSession(config);
        this.alertsPage = new AlertsPage(session);
    }

    @Test
    public void caseTest1() {
        alertsPage.perfromAlerts();
    }

    @AfterTest
    public void after() {
        session.closeBrowser();
    }
}
