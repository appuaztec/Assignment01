package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import specs.SelectableXpath;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectablePage implements SelectableXpath {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;

    public SelectablePage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void defaultList(String s) throws Exception {
        driver.findElement(defaultFuncTab).click();

        String val = defaultList.replace("@LISTDATA", s);

        Thread.sleep(1000);
        driver.findElement(By.xpath(val)).click();

        Thread.sleep(3000);
        String val1 = selectedList.replace("@LISTDATA", s);
        String valClass = driver.findElement(By.xpath(val1)).getAttribute("class");
        reporter.test.pass("Default Selactable List : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        Assert.assertTrue(valClass.contains("selected"), "Value is not selected");
        LOGGER.log(Level.INFO, "Default Selectable List : ");

    }


    public void serialList(List<String> listData) throws Exception {

        driver.findElement(serialFuncTab).click();
        Actions action = new Actions(driver);
        if (listData.size() > 1) {

        }

        for (String s : listData
        ) {

            String val = serialList.replace("@LISTDATA", s);
            Thread.sleep(500);
            WebElement ele = driver.findElement(By.xpath(val));
            action.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).perform();
        }


        Thread.sleep(3000);
        for (String s : listData
        ) {
            String val1 = serialselectedList.replace("@LISTDATA", s);
            String valClass = driver.findElement(By.xpath(val1)).getAttribute("class");

            Assert.assertTrue(valClass.contains("selected"), "Value " + s + " is not selected");
            LOGGER.log(Level.INFO, "Serialize Selectable List : ");
            reporter.test.pass("Serialize Selctable List : ",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        }

    }
}
