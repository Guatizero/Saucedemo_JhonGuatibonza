package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarPage {

    public static Target CHECKOUT_BUTTON = Target.the("checkout button")
            .locatedBy("//*[@id=\"checkout\"]");

    public static Target FIRST_NAME_INPUT = Target.the("first name input")
            .locatedBy("//*[@id=\"first-name\"]");

    public static Target LAST_NAME_INPUT = Target.the("last name input")
            .locatedBy("//*[@id=\"last-name\"]");

    public static Target POSTAL_CODE_INPUT = Target.the("postal code input")
            .locatedBy("//*[@id=\"postal-code\"]");

    public static Target CONTINUE_BUTTON = Target.the("continue button")
            .locatedBy("//*[@id=\"continue\"]");

    public static Target FINISH_BUTTON = Target.the("finish button")
            .locatedBy("//*[@id=\"finish\"]");

    public static Target CONFIRMATION_MESSAGE = Target.the("confirmation message: {0}")
            .locatedBy("//*[@id=\"checkout_complete_container\"]/h2");
}
