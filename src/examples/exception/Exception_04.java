package examples.exception;

/**
 * Вывод:
 * > 0
 * > Exception in thread "main" java.lang.RuntimeException
 */

public class Exception_04 {
    public static void main(String[] args) {


        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.out.println(1);
        }

        /**
         * Если исключение не ловится, оно выбрасывается
         * и программа завершается
         */
        System.out.println(2);
    }
}
