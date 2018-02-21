package pattern.obsevable.com.observablepattern;

import java.util.Observable;

/**
 * Created by deepika on 21/2/18.
 */

public class ChangeTemp extends Observable {

    private static ChangeTemp INSTANCE = null;

    private ChangeTemp() {

    }

    public static ChangeTemp getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ChangeTemp();
        }

        return INSTANCE;
    }

    public void changeTempStatus(String status){
        setChanged();
        notifyObservers(status);
    }
}
