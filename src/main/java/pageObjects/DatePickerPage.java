package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.DateUtils;
import common.ExtentReporterInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import specs.DatePickerXpath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DatePickerPage implements DatePickerXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;


    public DatePickerPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void DatePickDisabled(String dateSelect) throws Exception {

        String title = driver.getTitle();
        System.out.println("Title of the DatePicker disabled = " + title);

        driver.findElement(datePickerImg).click();


        String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        String currMonthYear = currMonth + " " + currYear;

        String userMonthYear = DateUtils.getTSinformat(dateSelect, "dd/MM/yyyy", "MMMM yyyy");
        String userDate = DateUtils.getTSinformat(dateSelect, "dd/MM/yyyy", "dd");

        int total = DateUtils.monthDiff(currMonthYear, "MMMM yyyy", userMonthYear, "MMMM yyyy");

        if (total < 0) {
            //Previous
            for (int i = 0; i < Math.abs(total); i++) {
                driver.findElement(prevButton).click();
            }
            Thread.sleep(1000);
            String dateXpath = dateSelector.replace("@DATE", userDate);
            driver.findElement(By.xpath(dateXpath)).click();
            reporter.test.pass("Disabled Date Picker date selected : ",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        } else if (total > 0) {
            //Next
            for (int i = 0; i < Math.abs(total); i++) {
                driver.findElement(nextButton).click();
            }
            Thread.sleep(1000);
            String dateXpath = dateSelector.replace("@DATE", userDate);
            driver.findElement(By.xpath(dateXpath)).click();
        } else if (total == 0) {
            //Current Month
            Thread.sleep(1000);
            String dateXpath = dateSelector.replace("@DATE", userDate);
            driver.findElement(By.xpath(dateXpath)).click();
            LOGGER.log(Level.INFO, "Disabled Date Picker date selected : ");


        }
    }


    public void DatePickEnabled(String dateSelect) throws Exception {

        String userMonthYear = DateUtils.getTSinformat(dateSelect, "dd/MM/yyyy", "MM/dd/yyyy");

        driver.findElement(By.xpath("//input[@id='datepicker2']")).sendKeys(userMonthYear);
        LOGGER.log(Level.INFO, "Enabled Date Picker date selected : ");
        reporter.test.pass("Enabled Date Picker date selected : ",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

    }

}


