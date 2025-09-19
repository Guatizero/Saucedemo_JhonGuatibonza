package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;
import tasks.AddItem;
import tasks.Login;
import tasks.GoToCart;
import tasks.Checkout;
import tasks.FillCheckoutInformation;
import tasks.FinishPurchase;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Constants.ACTOR;
import static utils.Constants.URL;

import questions.ConfirmationMessage;
import models.CheckoutData;

public class PurchaseStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("Que el usuario ingresa a la página de SauceDemo")
    public void queElUsuarioIngresaALaPáginaDeSauceDemo() {
        theActorCalled(ACTOR).attemptsTo(
                Open.url(URL)
        );
    }

    @Y("Se autentica con el usuario {string} y la contraseña {string}")
    public void seAutenticaConElUsuarioYLaContraseña(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.doLogin(username, password)
        );
    }
    @Cuando("Agrega dos productos al carrito {string} e {string}")
    public void agregaDosProductosAlCarritoE(String item1, String item2) {
        theActorInTheSpotlight().attemptsTo(
                 AddItem.toCart(item1),
                 AddItem.toCart(item2)
         );
    }

    @Y("Continua con la compra y los datos {string}, {string}, {string}")
    public void continuaConLaCompraYLosDatos(String firstname, String lastname, String postalcode) {
        CheckoutData data = new CheckoutData(firstname, lastname, postalcode);
        theActorInTheSpotlight().attemptsTo(
            GoToCart.goToCart(),
            Checkout.now(),
            FillCheckoutInformation.withInformation(data),
            FinishPurchase.finishPurcharse()
        );
    }

    @Entonces("se visualiza el mensaje de confirmación {string}")
    public void seVisualizaElMensajeDeConfirmacion(String mensaje) {
        theActorInTheSpotlight().should(
            seeThat(ConfirmationMessage.confirmationMessage(), equalTo(mensaje))
        );
    }

}
