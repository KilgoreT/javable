package examples.thread;

/**
 * Created by apomazkin on 07.03.2017.
 */
public class ThreadExample_05_Wait {
    public static void main(String[] args) {

        ThreadExample_05_Wait ref = new ThreadExample_05_Wait();
        for (int i = 0; i < 5; i++) {
            new Thread(new WaitMethodCaller(ref, i)).start();
        }
    }


    /**
     * Синхронизированный метод означает, что идет синхронизация по this этого метода.
     * Метод синхронизирован, поэтому в него зайти может только один поток.
     * Причем зайти могут несколько, но работать одновременно не могут.
     * Допустим, если один зашел и сделал sleep, то никто не зайдет.
     * Если один зашел и сделал wait(), то он останавливается и заходит другой,
     * как мы это и видим в данном примере
     *
     * conditional waiting - условное ожидание
     */

    public synchronized void f(int x) throws InterruptedException {
        System.out.println("+" + x);
        this.wait();
        System.out.println("-" + x);
    }
}

class WaitMethodCaller implements Runnable {

    private final ThreadExample_05_Wait ref;
    private final int x;

    WaitMethodCaller(ThreadExample_05_Wait ref, int x) {
        this.x = x;
        this.ref = ref;
    }

    @Override
    public void run() {
        try {
            ref.f(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
