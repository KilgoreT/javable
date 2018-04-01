package examples.pattern._04_Behavioral._01_Observer.Freeman;

import java.util.Observable;

/**
 * Реализовано через встроенную поддержку Java
 * Класс наследуется от Observable
 * и для работы с подписчиками используются методы суперкласса.
 */
public class JavaSubject extends Observable{

    private float temperature;

    public void measurementsChanged() {
        // setChanged всегда должен вызываться,
        // для того, чтобы дать знать методу notifyObservers()
        // что появились новые данные.
        // на случай, если данные обновляются часто и несущественно,
        // то отсылась бы только существенные изменения, например.
        setChanged();
        // Объект данных не передается,
        // значит - используется модель "запроса данных"
        notifyObservers();
    }

    public void setMeasurements(float temperature) {
        this.temperature = temperature;
        measurementsChanged();
    }

    // getter для того, чтобы подписчик сам мог запросить данные
    public float getTemperature() {
        return temperature;
    }
}
