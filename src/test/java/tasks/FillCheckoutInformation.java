package tasks;

import models.CheckoutData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.CarPage;

public class FillCheckoutInformation implements Task {
    private final CheckoutData data;

    public FillCheckoutInformation(CheckoutData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(data.getFirstname()).into(CarPage.FIRST_NAME_INPUT),
            Enter.theValue(data.getLastname()).into(CarPage.LAST_NAME_INPUT),
            Enter.theValue(data.getPostalcode()).into(CarPage.POSTAL_CODE_INPUT),
            Click.on(CarPage.CONTINUE_BUTTON)
        );
    }

    public static FillCheckoutInformation withInformation(CheckoutData data) {
        return Tasks.instrumented(FillCheckoutInformation.class, data);
    }
}
