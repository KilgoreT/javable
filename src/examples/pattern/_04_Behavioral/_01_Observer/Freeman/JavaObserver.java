package examples.pattern._04_Behavioral._01_Observer.Freeman;

import java.util.Observable;
import java.util.Observer;

/**
 * Подписчик имплементирует интерфейс Observer
 * и должен реализовать метод update();
 */
public class JavaObserver implements Observer {

    Observable observable;
    private float temperature;

    public JavaObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * Реализованный метод из интерфеса
     * @param observable, нужен, чтобы получить доступ к Observable,
     *           если данные не пришли в параметрах
     * @param arg параметры, в которых содержатся данные.
     *            Если null, значит это намек, что данные нужно самому запросить.
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof JavaSubject) {
            JavaSubject javaSubject = (JavaSubject) observable;
            this.temperature = javaSubject.getTemperature();
            display();
        }
    }

    private void display() {
        System.out.println("Temp is " + temperature);
    }
}
