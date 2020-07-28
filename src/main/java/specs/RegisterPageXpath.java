package specs;

import org.openqa.selenium.By;

import java.sql.Driver;

public interface RegisterPageXpath {

    public By firstName = By.xpath("//input[contains(@placeholder,'First Name')]");
    public By lastName = By.xpath("//input[contains(@placeholder,'Last Name')]");
    public By Address = By.xpath("//textarea[@ng-model='Adress']");
    public By Email = By.xpath("//input[@type='email']");
    public By Phone = By.xpath("//input[@type='tel']");
    public By Gender = By.xpath("//input[@type='radio'][following-sibling::text()[position()=1][contains(., 'FeMale')]]");
    public By Hobbies = By.xpath("//input[@type='checkbox']");
    public By Country = By.xpath("//select[@id='countries']");
    public By Languages = By.xpath("//div[@id='msdd']");
    public By Skills = By.xpath("//select[@id='Skills']");
    public By Selectcountry = By.xpath("//span[@role='combobox']");
    public String SelectCountry1 = "//li[text()='@COUNTRY']";
    public By DOBYear = By.xpath("//select[contains(@placeholder,'Year')]");
    public By DOBmonth = By.xpath("//select[contains(@placeholder,'Month')]");
    public By DOBday = By.xpath("//select[contains(@placeholder,'Day')]");
    public By password = By.xpath("//input[@id='firstpassword']");
    public By confimpwd = By.xpath("//input[@id='secondpassword']");
    public By submit = By.xpath("//button[@id='submitbtn']");




}
