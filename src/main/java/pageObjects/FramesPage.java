package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import specs.Framexpath;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FramesPage implements Framexpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;

    public FramesPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void frameValidation() throws Exception {

        //There are 3 ways to switch to frame : By Index,By name , By Webelement//
        //single iframe validation //

        driver.findElement(singleFrameButton).click();

        WebElement singleFrame =
                driver.findElement(singleframe);

        driver.switchTo().frame(singleFrame);

        driver.findElement(Textbox1).sendKeys("Hello text");

        driver.switchTo().defaultContent();
        LOGGER.log(Level.INFO, "Single Frame details : ");
        reporter.test.pass("Single Frame details  : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
    }

    //Iframe with in an iframe//

    public void frameValidationMultiple() throws Exception {

        driver.findElement(iframeButton).click();

        WebElement wouterFrame = driver.findElement(OuterFrame);
        driver.switchTo().frame(wouterFrame);

        WebElement winnerFrame = driver.findElement(innerFrame);
        driver.switchTo().frame(winnerFrame);

        driver.findElement(Textbox1).sendKeys("Testdata pass");
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
        LOGGER.log(Level.INFO, "Multiple Frame details : ");
        reporter.test.pass("Multiple Frame details : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

    }


}









