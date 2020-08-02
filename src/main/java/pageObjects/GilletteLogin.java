package pageObjects;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.ExtentReporterInit;
import org.openqa.selenium.WebDriver;
import specs.GilletteXpath;

import java.util.logging.Logger;

public class GilletteLogin  implements GilletteXpath {

        private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
        public BaseSession baseSession = null;
        public WebDriver driver = null;
        public ExtentReporterInit reporter = null;


        public GilletteLogin(BaseSession session) {
            this.baseSession = session;
            this.driver = session.driver;
            reporter = TestNgHooks.extentReporterInit;
        }

        public void GilletteIndia() throws  Exception{

          String strEmail = "appu.aztec1@gmail.com";
          String strpwd = "Tester#123";
          driver.findElement(signinEmail).sendKeys(strEmail);
          driver.findElement(signinPwd).sendKeys(strpwd);
          driver.findElement(signinbutton).click();





        }


}
