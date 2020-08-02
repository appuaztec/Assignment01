package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.PropertyReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class Case1_Runner {

    TestNgHooks testNgHooks = null;
    RegisterPage registerPage = null;
    BaseSession session = null;
    PropertyReader propertyReader =
            new PropertyReader(
                    System.getProperty("user.dir") +
                            "\\src\\main\\resources\\properties\\Assignment1.properties");



    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Registration");
        params.put("reportTestName", "Registration");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", propertyReader.readProperty("case1_url"));
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.registerPage = testNgHooks.registerPage;

    }

    @Test
    public void caseTest1() throws Exception {
        //Enter Details8
        registerPage.enterRegistrationDetails();
        //Click on Submit
        registerPage.clickSubmit();
        //Click on Refresh
        // registerPage.clickRefresh();

        Assert.assertTrue(session.verifyURL(10, "WebTable"),
                "Submission Failed, Didn't navigate in 10 seconds");


    }

    @AfterMethod
    public void after(ITestResult result) {

        testNgHooks.after(result);
    }
}
