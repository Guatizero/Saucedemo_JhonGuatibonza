package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.HomePage;

public class GoToCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(HomePage.CART_BUTTON)
        );
    }
    public static GoToCart goToCart() {
        return Tasks.instrumented(GoToCart.class);
    }
}

