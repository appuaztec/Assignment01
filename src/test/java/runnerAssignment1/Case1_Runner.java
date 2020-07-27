package runnerAssignment1;

import baseInit.TestNgHooks;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Case1_Runner {

    TestNgHooks testNgHooks = null;
    RegisterPage registerPage = null;


    @BeforeTest
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Registration");
        params.put("reportTestName", "Registration");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", "http://demo.automationtesting.in/Register.html");
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.registerPage = testNgHooks.registerPage;

    }

    @Test
    public void caseTest1() throws Exception {
        //Enter Details8
        registerPage.enterRegistrationDetails();
        //Click on Submit
        registerPage.clickSubmit();


    }

    @AfterTest
    public void after() {
        testNgHooks.after();
    }
}
