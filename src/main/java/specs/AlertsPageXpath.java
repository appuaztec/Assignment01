package specs;

import org.openqa.selenium.By;

public interface AlertsPageXpath {

    public By okButton = By.id("OKTab");
    public By okAndCancel = By.xpath("//a[@href='#CancelTab']");
    public By alertWithText = By.xpath("//a[@href='#Textbox']");
    //public By alertBox = By.xpath("//button[@onclick='alertbox()']");
    /*public By confirmBox = By.xpath("//button[@onclick='confirmbox()']");
    public By okMessage = By.cssSelector("//p[@id='demo' and contains(text(),'You pressed Ok')]");
    public By cancelMessage = By.xpath(" //p[@id='demo' and contains(text(),'You Pressed Cancel')]");
*/
}
