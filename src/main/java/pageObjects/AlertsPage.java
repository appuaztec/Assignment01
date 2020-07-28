package pageObjects;

import baseInit.BaseSession;
import org.openqa.selenium.WebDriver;
import specs.AlertsPageXpath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlertsPage implements AlertsPageXpath {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
    public BaseSession baseSession = null;
    public WebDriver driver = null;

    public AlertsPage(BaseSession session) {
        this.baseSession = session;
        this.driver = session.driver;
    }

    public void perfromAlerts() {

        LOGGER.log(Level.INFO, "LOG FROM perfromRegistration");
    }

}
