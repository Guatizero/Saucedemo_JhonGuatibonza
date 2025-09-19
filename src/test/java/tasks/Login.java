package tasks;


import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.LoginPage;


public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(username).into(LoginPage.USERNAME_INPUT),
            Enter.theValue(password).into(LoginPage.PASSWORD_INPUT),
            Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
        public static Login doLogin(String username, String password){
            return Tasks.instrumented(Login.class,username,password);
        }

}
