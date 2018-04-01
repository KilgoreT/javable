package examples.pattern._04_Behavioral._01_Observer.Freeman;

public class Main {
    /**
     * Observer:
     * 1) отношение один-ко-многим
     * 2) при изменении одного объекта
     *    идет оповещение с обновление других зависимых объектов
     *
     * Реализация:
     * восновном на основе классов, реализующих интерфейсы субъекта(наблюдателя)
     */
    public static void main(String[] args) {
        // Использование рукописного паттерна
        ThisSubjectz subjectz = new ThisSubjectz();
        ThisObserverz observerz = new ThisObserverz(subjectz);
        subjectz.setMeasurements(99);

        // Использование средств Java
        JavaSubject javaSubject = new JavaSubject();
        JavaObserver javaObserver = new JavaObserver(javaSubject);
        javaSubject.setMeasurements(98);
    }
}
