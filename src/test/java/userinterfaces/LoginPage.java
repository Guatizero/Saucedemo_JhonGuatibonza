package userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class LoginPage {

    public static Target USERNAME_INPUT = Target.the("username")
            .locatedBy("//input[@id='user-name']");

    public static Target PASSWORD_INPUT = Target.the("password")
            .locatedBy("//input[@id='password']");

    public static Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("//input[@id='login-button']");

}
