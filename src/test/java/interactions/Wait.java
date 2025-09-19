package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Wait implements Interaction {
    private final long time;

    public Wait(long time) {
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Wait Milisec(int time){
        return Tasks.instrumented(Wait.class,time);
    }
}
