package examples.thread;

/**
 * Created by apomazkin on 02.03.2017.
 */
public class ThreadExample_02_Join {
    public static void main(String[] args) {
        /**
         * Создаются два класса имплементировнных Runnable
         * Должен быть реализован метод run(),
         * в котором идет код, который нужно выполнять одновременно.
         */
        Runnable printA = new PrintRunnable02("A", 150);
        Runnable printB = new PrintRunnable02(" B", 210);
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
        /**
         * Thread.join() останавливает поток(main),
         * из которого вызывается Thread.start().
         * Этот поток(main) ожидает выполнения Thread
         * и только потом продолжает работу.
         */
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * если закоментировать вышестоящий try с  threadA.join(),
         * то main напечатает "Finish" до того, как закончат работу потоки A и B.
         * В текущей ситуации "Finish" будет напечатана после окончания потока threadA,
         * а поток threadB будет продолжать работу еще какие-то время.
         */
        System.out.println("   Finish");
    }
}

/**
 * имплементация от Runnable
 * реализован метод run().
 */
class PrintRunnable02 implements Runnable {
    private String msg;
    private long sleepMillis;

    public PrintRunnable02(String msg, long sleepMillis) {
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
