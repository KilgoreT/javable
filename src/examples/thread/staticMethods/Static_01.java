package examples.thread.staticMethods;

/**
 *  С помощью статических методов Thread можно манипулировать текущим потоком,
 *  но это не сильно похоже на многопоточность:
 *  sout в main и f() выполняются поочередно
 */
public class Static_01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            /**
             * Метод статический
             * поэтому относится к нашему потоку, а не создается новый.
             */
            Thread.sleep(200);
            System.out.println("A");
            f();
        }
    }

    private static void f() throws InterruptedException {
        Thread.sleep(260);
        System.out.println(" B");
    }
}
