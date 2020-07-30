package baseInit;

import common.ExtentReporterInit;
import org.testng.ITestResult;
import pageObjects.*;

import java.util.Map;

public class TestNgHooks {

    public static ExtentReporterInit extentReporterInit = null;
    public BaseSession session = null;
    public RegisterPage registerPage = null;
    public AlertsPage alertsPage = null;
    public WindowsPage windowsPage = null;
    public FramesPage framesPage = null;
    public DatePickerPage datePickerPage = null;
    public SelectablePage selectablePage = null;

    public void before(Map<String, String> params) throws Exception {
        extentReporterInit = new ExtentReporterInit(params.get("reportFileName"),
                params.get("reportTestName"), params.get("reportTestDesc"));
        this.session = new BaseSession(params);
        this.registerPage = new RegisterPage(session);
        this.alertsPage = new AlertsPage(session);
        this.windowsPage = new WindowsPage(session);
        this.framesPage = new FramesPage(session);
        this.datePickerPage = new DatePickerPage(session);
        this.selectablePage = new SelectablePage(session);
    }

    public void after(ITestResult result) {
        if(result.getStatus() == ITestResult.SUCCESS)
        {
           extentReporterInit.test.pass("Passed");
            System.out.println("passed **********");
        }
        else if(result.getStatus() == ITestResult.FAILURE)
        { extentReporterInit.test.fail("Failed");
            System.out.println("Failed ***********");
        }
        else if(result.getStatus() == ITestResult.SKIP ){
            extentReporterInit.test.skip("skip");
            System.out.println("Skiped***********");
        }
        session.closeBrowser();
        extentReporterInit.genReport();
    }
}
