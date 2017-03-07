package examples.thread;

/**
 * Created by apomazkin on 07.03.2017.
 */
public class ThreadExample_04_Synchronized {
    public static void main(String[] args) {
        ThreadExample_04_Synchronized ref = new ThreadExample_04_Synchronized();
        for (int i = 0; i < 5; i++) {
            new Thread(new BlockedMethodCaller(ref, i)).start();
        }
    }


    /**
     * Синхронизированный метод означает, что идет синхронизация по this этого метода.
     * Метод синхронизирован, поэтому в него зайти может только один поток.
     * Причем зайти могут несколько, но работать одновременно не могут.
     * Допустим, если один зашел и сделал sleep, то никто не зайдет.
     * Если один зашел и сделал wait(), то он останавливается и заходит другой.
     *
     * mutual exclusion - взаимное исключение
     */

    public synchronized void f(int x) throws InterruptedException {
        System.out.println("+" + x);
        Thread.sleep(1000);
        System.out.println("-" + x);
    }
}

class BlockedMethodCaller implements Runnable {

    private final ThreadExample_04_Synchronized ref;
    private final int x;

    BlockedMethodCaller(ThreadExample_04_Synchronized ref, int x) {
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
