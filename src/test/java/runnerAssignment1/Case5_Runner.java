package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DatePickerPage;

import java.util.HashMap;
import java.util.Map;

public class Case5_Runner {

    TestNgHooks testNgHooks = null;
    DatePickerPage DatePickerPage = null;
    BaseSession session = null;


    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "DatePicker");
        params.put("reportTestName", "DatePicker");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Datepicker.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.DatePickerPage = testNgHooks.datePickerPage;

    }

    @Test(enabled = true)
    public void caseTest1() throws Exception {
        //Enter Details
        String dateSelect = "24/10/2019";
        DatePickerPage.DatePickDisabled(dateSelect);
        //Click on Submit
    }

    @Test(enabled = true)
    public void caseTest2() throws Exception {
        //Enter Details
        String dateSelect = "24/10/2020";
        DatePickerPage.DatePickEnabled(dateSelect);
        //Click on Submit
    }

    @AfterMethod
    public void after(ITestResult result) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testNgHooks.after(result);
    }
}



