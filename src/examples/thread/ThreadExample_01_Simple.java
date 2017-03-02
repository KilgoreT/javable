package examples.thread;

/**
 * Created by apomazkin on 02.03.2017.
 */
public class ThreadExample_01_Simple {
    public static void main(String[] args) {
        /**
         * Создаются два класса имплементировнных Runnable
         * Должен быть реализован метод run(),
         * в котором идет код, который нужно выполнять одновременно.
         */
        Runnable printA = new PrintRunnable01("A", 150);
        Runnable printB = new PrintRunnable01(" B", 210);
        /**
         * Создаются Thread объекты под классы Runnable.
         */
        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        /**
         * запускаются методом start().
         */
        threadA.start();
        threadB.start();

    }
}

/**
 * имплементация от Runnable
 * реализован метод run().
 */
class PrintRunnable01 implements Runnable {
    private String msg;
    private long sleepMillis;

    public PrintRunnable01(String msg, long sleepMillis) {
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
    }
}
