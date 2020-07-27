package specs;

import org.openqa.selenium.By;

import java.sql.Driver;

public interface RegisterPageXpath {

    public By firstName = By.xpath("//input[contains(@placeholder,'First Name')]");
    public By lastName = By.xpath("//input[contains(@placeholder,'Last Name')]");
    public By Email = By.xpath("//input[@type='email']");
    public By Phone = By.xpath("//input[@type='tel']");
    public By Gender = By.xpath("//input[@type='radio'][following-sibling::text()[position()=1][contains(., 'FeMale')]]");
    public By Country = By.xpath("//select[@id='countries']");


}
