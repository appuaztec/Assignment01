package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import com.aventstack.extentreports.MediaEntityBuilder;
import common.EncodeDecode;
import common.ExtentReporterInit;
import common.RandomDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import specs.RegisterPageXpath;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterPage implements RegisterPageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;
    public ExtentReporterInit reporter = null;

    public RegisterPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
        reporter = TestNgHooks.extentReporterInit;
    }

    public void enterRegistrationDetails() throws Exception {

        String strFirstName = RandomDataGenerator.getRandomWord(8);
        String strLastName = RandomDataGenerator.getRandomWord(4);

        driver.findElement(firstName).sendKeys(strFirstName);
        LOGGER.log(Level.INFO, "Entered First Name : " + strFirstName);
        reporter.test.pass("Entered First Name : " + strFirstName,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        driver.findElement(lastName).sendKeys(strLastName);
        LOGGER.log(Level.INFO, "Entered Last Name : " + strLastName);
        reporter.test.pass("Entered Last Name : " + strLastName,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        String strAddress = "1234 , 6 main , vienna street";
        driver.findElement(Address).sendKeys(strAddress);
        LOGGER.log(Level.INFO, "Entered Address " + strAddress);
        reporter.test.pass("Entered Address " + strAddress,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        String emailID = strFirstName+"_"+strLastName + RandomDataGenerator.getRandomNum(1, 99) + "@email.com";
        driver.findElement(Email).sendKeys(emailID);
        LOGGER.log(Level.INFO, "Entered Email address " + emailID);
        reporter.test.pass("Entered Email address " + emailID,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        String phNum = "98765" + RandomDataGenerator.getRandomNum(11111, 99999);
        driver.findElement(Phone).sendKeys(phNum);
        LOGGER.log(Level.INFO, "Entered Phone Number : " + phNum);
        reporter.test.pass("Entered Phone Number : " + phNum,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        String gender = "Male";
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(
                    By.xpath(Gender.replace("@GENDER", "Male"))).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(
                    By.xpath(Gender.replace("@GENDER", "FeMale"))).click();
        }

        LOGGER.log(Level.INFO, "Selected Gender : " + gender);
        reporter.test.pass("Selected Gender : " + gender,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());
        List<String> hobbiesList = new ArrayList<String>();
        hobbiesList.add("Cricket");
        hobbiesList.add("Hockey");
        for (String hobby : hobbiesList) {
            driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + hobby + "']")).click();
        }
        LOGGER.log(Level.INFO, "Selected Hobbies : " + hobbiesList);
        reporter.test.pass("Selected Hobbies : " + hobbiesList,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        List<String> languageslist = new ArrayList<String>();
        languageslist.add("English");
        languageslist.add("Arabic");
        driver.findElement(Languages).click();
        for (String lang : languageslist
        ) {
            driver.findElement(By.xpath(Languages1.replace("@LANGUAGE", lang))).click();
        }
        LOGGER.log(Level.INFO, "Selected Languages " + languageslist);
        reporter.test.pass("Selected Languages " + languageslist,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        String strSkill = "AutoCAD";
        Select skill = new Select(driver.findElement(Skills));
        skill.selectByValue(strSkill);
        LOGGER.log(Level.INFO, "Selected skill " + strSkill);
        reporter.test.pass("Selected skill " + strSkill,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        String strCountry = "India";

        baseSession.scrollToElement(Country);
        Select countries = new Select(driver.findElement(Country));
        countries.selectByValue(strCountry);

        driver.findElement(Selectcountry).click();
        driver.findElement(By.xpath(SelectCountry1.replace("@COUNTRY", strCountry))).click();
        LOGGER.log(Level.INFO, "Selected country " + strCountry);
        reporter.test.pass("Selected country " + strCountry,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        String strDay = "10";
        String strMonth = "August";
        String strYear = "1994";

        Select year = new Select(driver.findElement(DOBYear));
        year.selectByValue(strYear);
        Select month = new Select(driver.findElement(DOBmonth));
        month.selectByValue(strMonth);
        Select day = new Select(driver.findElement(DOBday));
        day.selectByValue(strDay);
        LOGGER.log(Level.INFO, "Selected Date: " + strDay + "/" + strMonth + "/" + strYear);
        reporter.test.pass("Selected Date: " + strDay + "/" + strMonth + "/" + strYear,
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());


        String encPwd = "QXBwdUB4eXoxMjM=";

        driver.findElement(password).sendKeys(EncodeDecode.perfromDecode(encPwd));
        LOGGER.log(Level.INFO, "Entered Password");
        reporter.test.pass("Entered Password",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

        driver.findElement(confimpwd).sendKeys(EncodeDecode.perfromDecode(encPwd));
        LOGGER.log(Level.INFO, "Entered Confirm Password");
        reporter.test.pass("Entered Confirm Password",
                MediaEntityBuilder.createScreenCaptureFromBase64String(reporter.getScreenshotExtent(driver)).build());

    }

    public void clickSubmit() {
        driver.findElement(submit).click();
        reporter.test.pass("Clicked on Submit button");
        LOGGER.log(Level.INFO, "Clicked Submit Button in Registration Page");
    }

    public void clickRefresh() {
        driver.findElement(refresh).click();
        reporter.test.pass("Clicked on Refresh button");
        LOGGER.log(Level.INFO, "Clicked Refresh Button in Registration Page");
    }
}
