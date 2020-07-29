package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.ExtentReporterInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import specs.Framexpath;

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

//        //There are 3 ways to switch to frame : By Index,By name , By Webelement//
//        //single iframe validation //
//
//        driver.switchTo().frame(0);
//        driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Testing Automation");

        //Wait for page load
        //Take screenshot
        driver.findElement(singleFrameButton).click();

        WebElement singleFrame =
                driver.findElement(singleframe);

        driver.switchTo().frame(singleFrame);

        driver.findElement(Textbox1).sendKeys("Hello text");

        driver.switchTo().defaultContent();

        //Iframe with in an iframe//


    }


    public void frameValidationMultiple() throws Exception {

//        //There are 3 ways to switch to frame : By Index,By name , By Webelement//
//        //single iframe validation //
        //Wait for page load
        //Take screenshot

        //Iframe with in an iframe//

        driver.findElement(iframeButton).click();

        WebElement wouterFrame = driver.findElement(OuterFrame);
        driver.switchTo().frame(wouterFrame);

        WebElement winnerFrame = driver.findElement(innerFrame);
        driver.switchTo().frame(winnerFrame);

        driver.findElement(Textbox1).sendKeys("Testdata pass");


        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();


    }


}









