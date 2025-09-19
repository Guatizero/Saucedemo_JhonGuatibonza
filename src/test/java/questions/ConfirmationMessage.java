package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import userinterfaces.CarPage;

public class ConfirmationMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return CarPage.CONFIRMATION_MESSAGE.resolveFor(actor).getText();
    }

    public static ConfirmationMessage confirmationMessage() {
        return new ConfirmationMessage();
    }
}

