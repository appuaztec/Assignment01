package specs;

import org.openqa.selenium.By;

public interface GilletteXpath {
 //public By clickSignIn= By.xpath("//a[@title='SIGN IN']");
 public By signinEmail = By.xpath("//input[@data-key='signInEmailAddress']");
 public By signinPwd = By.xpath("//input[@data-key='currentPassword']");
 public By signinbutton = By.xpath("//input[@type='submit']");

}
