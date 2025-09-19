package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Select;
import userinterfaces.HomePage;
import userinterfaces.ItemPage;

public class AddItem implements Task {

    private final String item;

    public AddItem(String item) {
        this.item = item;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePage.SELECT_ITEM_BUTTON.of(item)),
            Click.on(ItemPage.ADD_ITEM_BUTTON),
            Click.on(ItemPage.BACK_TO_PRODUCTS_BUTTON)
            );
    }

    public static AddItem toCart(String item) {
        return Tasks.instrumented(AddItem.class, item);
    }
}
