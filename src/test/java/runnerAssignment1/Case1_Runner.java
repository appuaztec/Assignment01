package runnerAssignment1;

import baseInit.BaseSession;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

import java.util.HashMap;
import java.util.Map;

public class Case1_Runner {

    public BaseSession session = null;
    public RegisterPage registerPage = null;

    @BeforeTest
    public void before() {
        Map<String,String> config = new HashMap<String, String>();
        config.put("browser","chrome");
        config.put("url","http://demo.automationtesting.in/Register.html");
        this.session = new BaseSession(config);
        this.registerPage = new RegisterPage(session);
    }

    @Test
    public void caseTest1() {
        registerPage.enterRegistrationDetails();
        registerPage.clickSubmit();
    }

    @AfterTest
    public void after() {
        session.closeBrowser();
    }
}
