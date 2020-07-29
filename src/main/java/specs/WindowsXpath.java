package specs;

import org.openqa.selenium.By;

public interface WindowsXpath {

    public By openTabbedWindows = By.xpath("//div[@id='Tabbed' and contains(@class,'active')]/a");
    public  By openNewseperateWindows = By.xpath("//a[contains(@href,'Seperate') and contains(text(),'Open New Seperate Windows')]");
    public By openSeperateMultiple = By.xpath("//a[contains(@href,'Multiple') and contains(text(),'Open Seperate Multiple Windows')]");

}
