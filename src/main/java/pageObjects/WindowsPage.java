package pageObjects;


import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.ExtentReporterInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class WindowsPage {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public static WebDriver driver = null;
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
        reporter.test.pass("Open Window ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        driver.findElement(By.xpath(" //div[@id='Tabbed' and contains(@class,'active')]/a/button")).click();


        //ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        //driver.switchTo().window(tabs2.get(1));

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();

        String firstWindow = I1.next();
        String secondWindow = I1.next();

        driver.switchTo().window(secondWindow);
        baseSession.waitForPageToLoad(driver);

        title = driver.getTitle();
        System.out.println("Title of the second window = " + title);

        String tabURL = driver.getCurrentUrl();
        System.out.println("tabURL = " + tabURL);

        URI u = new URI(tabURL);
        URI u1 = new URI(buttonHREF);

        reporter.test.pass("Second Window : " + title,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        Assert.assertTrue(
                u1.getHost().equalsIgnoreCase(
                        u.getHost()),
                "WRONG HOST OPENED");
        driver.switchTo().window(firstWindow);
        System.out.println("First window title = " + driver.getTitle());
        reporter.test.pass("URL " + u1.getHost() + "Validated",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());




    }
public void separateWindow() throws Exception {

    String buttonCheck = "";

    //div[@id='Tabbed' and contains(@class,'active')]/a/button

    WebElement newSeperateWindow = driver.findElement(By.xpath(" //div[@id='Seperate' and contains(@class,'active')]"));
    buttonCheck = newSeperateWindow.getAttribute("href");
    //reporter.test.pass("Open Window ",
    //MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
    driver.findElement(By.xpath(" //div[@id='Seperate' and contains(@class,'active')]/a/button")).click();

    Set<String> newSeperate = driver.getWindowHandles();
    Iterator<String> I2 = newSeperate.iterator();

    String mainWindow = I2.next();
    String seperateWindow = I2.next();

    driver.switchTo().window(seperateWindow);
    baseSession.waitForPageToLoad(driver);

    String title1 = driver.getTitle();
    System.out.println("Title of the  seperate window = " + title1);

    String tabURL1 = driver.getCurrentUrl();
    System.out.println("tabURL = " + tabURL1);

    URI u2 = new URI(tabURL1);
    URI u3 = new URI(buttonCheck);

    reporter.test.pass("Seperate  Window : " + title1,
            MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
    Assert.assertTrue(
            u2.getHost().equalsIgnoreCase(
                    u3.getHost()),
            "WRONG HOST OPENED");
    driver.switchTo().window(mainWindow);
    System.out.println("Main window title = " + driver.getTitle());
    reporter.test.pass("URL " + u2.getHost() + "Validated",
            MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


}
    }

