package examples.thread;

/**
 * Created by apomazkin on 02.03.2017.
 */
public class ThreadExample_03_DeadLock {
    public static void main(String[] args) {
        /**
         * Получаем ссылку на текущий поток
         * и вызывает для него join().
         * Это deadlock, когда потоки ждут друг друга
         * и процесс зависает.
         */
        Thread thread = Thread.currentThread();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
