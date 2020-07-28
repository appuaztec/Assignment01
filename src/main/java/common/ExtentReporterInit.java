package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentReporterInit {

    public ExtentHtmlReporter extentSparkReporter = null;
    public ExtentReports extent = null;
    public ExtentTest test = null;

    public String repHTMLFileName = null;
    public String repTestName = null;
    public String repTestDesc = null;
    public String repFolderPath = null;


    public ExtentReporterInit(String repHTMLFileName, String repTestName, String repTestDesc) throws Exception {
        this.repHTMLFileName = repHTMLFileName; //FileName (without Extension)
        this.repTestName = repTestName; //Test Name
        this.repTestDesc = repTestDesc; //Test Description
        this.repFolderPath = System.getProperty("user.dir") + "\\target\\Extend-Reports"; //Path to store Reports

        try {
            /*Delete Previous one*/
            // FileUtils.forceDelete(new File(this.repFolderPath));
        } catch (Exception e) {
            System.out.println("Error in Deleting Reports Folder " + e.getMessage());
        }

        //Initilize reporter
        initReporter();
    }

    public synchronized void initReporter() {

        //Folder name
        String folderPathWithFileName = this.repFolderPath + "\\" + this.repHTMLFileName;
        String reportDirectoryName;

        //File Name inside the Folder
        reportDirectoryName = folderPathWithFileName + "\\" + this.repHTMLFileName + "_" + this.getTimeStamp();
        System.out.println("Report Name : " + reportDirectoryName);


        // start reporters

        extentSparkReporter = new ExtentHtmlReporter(reportDirectoryName + ".html");
        extentSparkReporter.config().setDocumentTitle("Title");
        extentSparkReporter.config().setReportName(this.repTestName);
        extentSparkReporter.config().setTheme(Theme.STANDARD);

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        System.out.println("extent = " + extent);
        extent.attachReporter(extentSparkReporter);
        // creates a toggle for the given test, adds all log events under it
        test = extent.createTest(this.repTestName, this.repTestDesc);
    }

    public String getScreenshotExtent(WebDriver driver) {
        String Base64StringofScreenshot = "";
        TakesScreenshot tst = ((TakesScreenshot) driver);
        Base64StringofScreenshot = tst.getScreenshotAs(OutputType.BASE64);
        return Base64StringofScreenshot;
    }

    public synchronized void genReport() {
        System.out.println("CusExtentReporter.genReport" + this.repHTMLFileName);
        System.out.println("extent = " + extent);
        this.extent.flush();
    }

    public String getTimeStamp() {
        long timeInMillis = System.currentTimeMillis();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(timeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String dateforrow = dateFormat.format(cal1.getTime());
        return dateforrow;
    }

}
