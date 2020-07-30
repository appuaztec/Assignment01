package specs;

import org.openqa.selenium.By;

public interface SelectableXpath {

    public By defaultFuncTab = By.xpath("//a[contains(text(),'Default Functionality')]");
    public By serialFuncTab = By.xpath("//a[contains(text(),'Serialize')]");

    public String defaultList = "(//div[@id='Default']/ul/li/b[text()='@LISTDATA']/..)[1]";
    public String selectedList = "(//div[@id='Default']/ul/li/b[text()='@LISTDATA']/..)[1]";

    public String serialList = "(//div[@id='Serialize']/ul/li/b[text()='@LISTDATA']/..)[1]";
    public String serialselectedList = "(//div[@id='Serialize']/ul/li/b[text()='@LISTDATA']/..)[1]";
}
