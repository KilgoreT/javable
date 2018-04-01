package examples.pattern._04_Behavioral._01_Observer.Freeman;

public interface Subjectz {
    public void registerObserver(Observerz o);
    public void removeObserver(Observerz o);
    public void notifyOnserverz();
}
