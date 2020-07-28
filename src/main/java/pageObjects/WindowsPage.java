package pageObjects;


import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.URI;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WindowsPage {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;


    public WindowsPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void windowTabbed() throws Exception {
        String title = driver.getTitle();
        System.out.println("Title of the First window = " + title);

        String buttonHREF = "";

        //div[@id='Tabbed' and contains(@class,'active')]/a/button

        WebElement newTabbedWindow = driver.findElement(By.xpath(" //div[@id='Tabbed' and contains(@class,'active')]/a"));
        buttonHREF = newTabbedWindow.getAttribute("href");
        driver.findElement(By.xpath(" //div[@id='Tabbed' and contains(@class,'active')]/a/button")).click();


        //ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        //driver.switchTo().window(tabs2.get(1));

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();

        String firstWindow = I1.next();
        String secondWindow = I1.next();

        driver.switchTo().window(secondWindow);
        reporter.test.pass("Open Window " ,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        title = driver.getTitle();
        String tabURL = driver.getCurrentUrl();

        System.out.println("Title of the second window = " + title);
        reporter.test.pass("Second Window : " + title,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        URI u = new URI(tabURL);
        URI u1 = new URI(buttonHREF);


        Assert.assertTrue(
                u1.getHost().equalsIgnoreCase(
                        "www."+u.getHost()),
                "WRONG HOST OPENED");
        reporter.test.pass("URL "+u1.getHost()+"Validated",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


    }

}
