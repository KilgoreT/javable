package examples.exception;

/**
 * Вывод:
 * > in try
 * > in finally
 * > 24
 */

public class Exception_09 {
    public static void main(String[] args) {

        System.out.println(f());
    }

    private static int f() {
        try {
            System.out.println("in try");
            return 42;
        } finally {
            /**
             * return в finally сильнее return в try
             */
            System.out.println("in finally");
            return 24;
        }
    }
}
