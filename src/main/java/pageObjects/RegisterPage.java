package pageObjects;

import baseInit.BaseSession;
import org.openqa.selenium.WebDriver;
import specs.RegisterPageXpath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterPage implements RegisterPageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;

    public RegisterPage(BaseSession session){
        this.baseSession = session;
        this.driver = session.driver;
    }

    public void enterRegistrationDetails(){
        driver.findElement(firstName).sendKeys("Johnny");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        driver.findElement(firstName).sendKeys("Sin");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
    }

    public void clickSubmit(){
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
    }

}
