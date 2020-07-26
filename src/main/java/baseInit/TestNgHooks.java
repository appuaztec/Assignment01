package baseInit;

import common.ExtentReporterInit;
import pageObjects.AlertsPage;
import pageObjects.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class TestNgHooks {

    public BaseSession session = null;
    public RegisterPage registerPage = null;
    public AlertsPage alertsPage = null;
    public static ExtentReporterInit extentReporterInit = null;


    public void before(Map<String,String> params) throws Exception {
        extentReporterInit = new ExtentReporterInit(params.get("reportFileName"),
                params.get("reportTestName"),params.get("reportTestDesc"));
        this.session = new BaseSession(params);
        this.registerPage = new RegisterPage(session);
        this.alertsPage = new AlertsPage(session);
    }

    public void after(){
        session.closeBrowser();
        extentReporterInit.genReport();
    }
}
