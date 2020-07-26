package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.WebDriver;
import specs.RegisterPageXpath;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterPage implements RegisterPageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;

    public RegisterPage(BaseSession session){
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void enterRegistrationDetails() throws IOException {
        driver.findElement(firstName).sendKeys("Johnny");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Entered First Name",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        //        driver.findElement(firstName).sendKeys("Sin");
      //  LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
    }

    public void clickSubmit(){
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
    }

}
