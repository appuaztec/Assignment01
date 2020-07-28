package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
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

    public void enterRegistrationDetails() throws Exception{
        driver.findElement(firstName).sendKeys("Johnny");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Entered First Name");
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        driver.findElement(lastName).sendKeys("Test");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Entered Last Name");
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        driver.findElement(Email).sendKeys("appu_assign01@xyz.com");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Entered Email address");
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        driver.findElement(Phone).sendKeys("9900112233");
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Entered Phone number");
        MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        driver.findElement(Gender).click();
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Clicked on Female Gender Option");
        MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        //        driver.findElement(firstName).sendKeys("Sin");
      //  LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        baseSession.scrollToElement(Country);
        Select countries =  new Select(driver.findElement(Country));
        countries.selectByValue("India");
        driver.findElement(Selectcountry).click();
        driver.findElement(By.xpath(SelectCountry1.replace("@COUNTRY","United States of America"))).click();
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
        reporter.test.pass("Clicked India in Select country");
        MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build();
        Select year= new Select(driver.findElement(DOBYear));
        year.selectByValue("1994");
        Select month = new Select(driver.findElement(DOBmonth));
        month.selectByValue("August");
        Select day = new Select(driver.findElement(DOBday));
        day.selectByValue("10");




    }

    public void clickSubmit(){
        LOGGER.log(Level.INFO,"LOG FROM perfromRegistration");
    }

}
