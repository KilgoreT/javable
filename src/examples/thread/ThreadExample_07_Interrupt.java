package examples.thread;

/**
 * Created by apomazkin on 09.03.2017.
 */
public class ThreadExample_07_Interrupt {
    /**
     * thread.interrupt() - прерывает поток.
     * thread.isInterrupted() - возвращает прерван ли поток (boolean).
     * thread.interrupted() (статический) - возвращает прерван ли поток,
     * но потом сбрасывает значение, что не конвенционально.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread myThread = Thread.currentThread();
                /**
                 * Периодически можно проверять, прерван ли поток.
                 * Но если вычисления в while делаются долго,
                 * то не сразу станет известно, что поток прерван.
                 */
                while (!myThread.isInterrupted()) {
                    System.out.println("hello");
                    for (int i = 0; i < 1_000_000_000L; i++);
                }
            }
        });
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();

    }
}
