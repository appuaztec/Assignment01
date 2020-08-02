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
    public GilletteLogin GilletteLogin = null;
    boolean browserOpened = true;


    public void before(Map<String, String> params) throws Exception {
        if(params.get("browser").equalsIgnoreCase("no")
         && params.get("report").equalsIgnoreCase("yes")){
            extentReporterInit = new ExtentReporterInit(params.get("reportFileName"),
                    params.get("reportTestName"), params.get("reportTestDesc"));
            browserOpened = false;
            return;
        }
        extentReporterInit = new ExtentReporterInit(params.get("reportFileName"),
                params.get("reportTestName"), params.get("reportTestDesc"));
        this.session = new BaseSession(params);
        this.registerPage = new RegisterPage(session);
        this.alertsPage = new AlertsPage(session);
        this.windowsPage = new WindowsPage(session);
        this.framesPage = new FramesPage(session);
        this.datePickerPage = new DatePickerPage(session);
        this.selectablePage = new SelectablePage(session);
        this.GilletteLogin = new GilletteLogin(session);
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
        if(!browserOpened){
            //session.closeBrowser();
        }
        extentReporterInit.genReport();
    }
}
