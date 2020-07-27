package baseInit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.logging.Logger;

public class BaseSession {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public WebDriver driver = null;

    public BaseSession(Map<String, String> configurations) {
        openBrowser(configurations);
        waitForPageToLoad();
    }

    public void waitForPageToLoad() {
//        ExpectedCondition<Boolean> expectation = new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
//                    }
//                };
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        Object until = wait.until(expectation);
    }

    public WebDriver openBrowser(Map<String, String> configurations) {
        String browser = (String) configurations.get("browser");
        if ("chrome".equals(browser)) {

            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") +
                            "//src//main//resources//drivers//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximised");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get((String) configurations.get("url"));

        } else if ("firefox".equals(browser)) {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get((String) configurations.get("url"));

        }
        return driver;

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void scrollToElement(By prXpath) throws Exception {
        WebElement element = driver.findElement(prXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
