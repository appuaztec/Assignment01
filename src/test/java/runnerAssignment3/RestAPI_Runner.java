package runnerAssignment3;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RestAPI;

public class RestAPI_Runner {

    RestAPI restAPI = null;
    ExtentReporter extentReporter = null;
    ExtentReports extent = null;

    @BeforeMethod
    public void before() throws Exception {
        extentReporter = new ExtentHtmlReporter("RestAPI\\RestAPI.html");
        extent = new ExtentReports();
        extent.attachReporter(extentReporter);
        // creates a toggle for the given test, adds
        restAPI = new RestAPI(extent);
    }

    @Test
    public void caseTest1() throws Exception {
        //Enter Details8
        restAPI.basicAuth("postman","password");
        restAPI.getRest();
        restAPI.postRest();
        restAPI.putRest();
        restAPI.delRest();
    }

    @AfterMethod
    public void after(ITestResult result) {
       extent.flush();
    }
}
