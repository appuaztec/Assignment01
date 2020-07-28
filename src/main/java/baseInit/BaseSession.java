package baseInit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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


    public boolean verifyURL(int seconds, String value) throws Exception {
        boolean success = false;
        for (int i = 1; i <= seconds; i++) {
            if (driver.getCurrentUrl().contains(value)) {
                success = true;
                break;
            } else {
                Thread.sleep(1000);
            }
        }
        return success;

    }

    //public void dateOfBirth(By dob){
    // WebElement element = driver.findElement(dob);


//    public void addText(By add) throws Exception {
//        WebElement element=  driver.findElement(add);
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].setAttribute('value',arguments[1]);",element,"#123, 2 stage, Vienna street");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

    //      public void passEncryptDcrypt(By password) {
    //         String str = "abcd1234";
    //       byte[] encode = Base64.encodeBase64(str.getBytes());
    //     System.out.println("String before encoding: " + str);
    //   System.out.println("String after encoding : " + new String(encode));
    // byte[] decode = Base64.decodeBase64(encode);
    //System.out.println("String after decoding : " + new String(decode));


}



