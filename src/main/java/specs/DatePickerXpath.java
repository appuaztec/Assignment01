package specs;

import org.openqa.selenium.By;

public interface DatePickerXpath {

    public By datePickerLabel = By.xpath("//label[@class='control-label']");
    public By datePickerDwidget = By.xpath("//input[@id='datepicker1']");
    public By  datePickerImg= By.xpath("//img[@class='imgdp']");
    public By rightArrow = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
    public By rightArrow10 = By.xpath("div/table/tbody/tr[2]/td[5]/a[1]");
    ////div/table/tbody/tr[2]/td[5]/a[1]//

    public By prevButton = By.xpath("//a/span[text()='Prev']");
    public By nextButton = By.xpath("//a/span[text()='Next']");
    public String dateSelector = "//table[@class='ui-datepicker-calendar']/tbody//a[text()='@DATE']";



}
