package examples.exception;

/**
 * Вывод:
 * > in try
 * > in finally
 * > Exception in thread "main" java.lang.NullPointerException
 */

public class Exception_11 {
    public static void main(String[] args) {

        System.out.println(f());
    }

    private static int f() {
        try {
            System.out.println("in try");
            throw new RuntimeException();
        } finally {
            /**
             * исключение в finally сильнее исключения в try
             */
            System.out.println("in finally");
            throw new NullPointerException();
        }
    }
}
