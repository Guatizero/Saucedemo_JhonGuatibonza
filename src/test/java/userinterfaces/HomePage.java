package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static Target SELECT_ITEM_BUTTON = Target.the("select item {0}")
            .locatedBy("//*[contains(text(), '{0}')]");

    public static Target CART_BUTTON = Target.the("cart button")
            .locatedBy("//*[@id=\"shopping_cart_container\"]/a");

}
