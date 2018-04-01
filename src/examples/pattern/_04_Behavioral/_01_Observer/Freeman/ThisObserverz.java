package examples.pattern._04_Behavioral._01_Observer.Freeman;

public class ThisObserverz implements Observerz{

    // данные
    private float temperature;
    // ссылка на субьект, чтобы была возможность отписаться.
    private Subjectz subjectz;

    public ThisObserverz(Subjectz subjectz) {
        this.subjectz = subjectz;
        subjectz.registerObserver(this);
    }

    @Override
    public void update(float temp) {
        this.temperature = temp;
        display();
    }

    private void display() {
        System.out.println("Temp is " + temperature);
    }
}
