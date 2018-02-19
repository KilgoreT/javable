package examples.exception;

/**
 * Вывод:
 * > in try
 * > in finally
 * > 42
 */
public class Exception_08 {
    public static void main(String[] args) {

        System.out.println(f());
    }

    private static int f() {
        try {
            System.out.println("in try");
            return 42;
        } finally {
            //finally сильнее даже return
            System.out.println("in finally");
        }
    }
}
