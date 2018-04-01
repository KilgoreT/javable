package examples.pattern._04_Behavioral._01_Observer.Freeman;

import java.util.ArrayList;

public class ThisSubjectz implements Subjectz {

    // массив, где будет хранить подписчиков
    private ArrayList observerz;
    // какие-то данные
    private float temperature;


    public ThisSubjectz() {
        this.observerz = new ArrayList();
    }

    /**
     * Регистрируем подписчиков
     * @param o подписчик, имплементирующий Observerz.
     */
    @Override
    public void registerObserver(Observerz o) {
        observerz.add(o);
    }

    /**
     * Удаление подписчика
     * Чтобы подписчик(Observerz) имел возможность отписаться от событий Subjectz.
     * @param o
     */
    @Override
    public void removeObserver(Observerz o) {
        int i = observerz.indexOf(o);
        if (i >= 0) {
            observerz.remove(i);
        }
    }

    /**
     * Рассылка событий всем подписчикам
     */
    @Override
    public void notifyOnserverz() {
        for (int i = 0; i < observerz.size(); i++) {
            Observerz observers = (Observerz) observerz.get(i);
            observers.update(temperature);
        }
    }

    /**
     * Метод, запускаемый в случае изменения данных.
     */
    public void measurementsChange() {
        notifyOnserverz();
    }

    /**
     * Метод для изменения данных.
     * @param temperature - обновляется поле класса.
     */
    public void setMeasurements(float temperature) {
        this.temperature = temperature;
        measurementsChange();
    }
}
