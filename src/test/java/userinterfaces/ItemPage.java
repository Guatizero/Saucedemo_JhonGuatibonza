package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ItemPage{

    public static Target ADD_ITEM_BUTTON = Target.the("add item button")
            .locatedBy("//*[@id=\"add-to-cart\"]");

    public static Target BACK_TO_PRODUCTS_BUTTON = Target.the("back to products button")
            .locatedBy("//*[@id=\"back-to-products\"]");



}
