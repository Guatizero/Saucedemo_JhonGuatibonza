package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.CarPage;

public class Checkout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CarPage.CHECKOUT_BUTTON)
        );
    }
    public static Checkout now() {
        return Tasks.instrumented(Checkout.class);
    }
}

