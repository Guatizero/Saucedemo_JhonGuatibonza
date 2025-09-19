package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.CarPage;

public class FinishPurchase implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CarPage.FINISH_BUTTON)
        );
    }
    public static FinishPurchase finishPurcharse() {
        return Tasks.instrumented(FinishPurchase.class);
    }
}

