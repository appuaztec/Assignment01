package specs;

import org.openqa.selenium.By;

public interface Framexpath {

    public By singleFrameButton = By.xpath("//a[@href='#Single']");
    public By singleframe = By.xpath("//iframe[@id='singleframe']");
    public By Textbox1 = By.xpath("//input[@type='text']");

    //Case 2
    public By iframeButton = By.xpath("//a[@href='#Multiple']");
    public By OuterFrame = By.xpath("//iframe[contains(@src,'MultipleFrames')]");
    public By innerFrame = By.xpath("//iframe[contains(@src,'SingleFrame')]");

}
