package examples.exception;

/**
 * Вывод:
 * > in try
 * > in finally
 * > 24
 */

public class Exception_10 {
    public static void main(String[] args) {

        System.out.println(f());
    }

    private static int f() {
        try {
            System.out.println("in try");
            throw new RuntimeException();
        } finally {
            /**
             * return в finally сильнее исключения в try
             * но так на практике делать очень нехорошо.
             * Вся бизнес логика должна быть в try,
             * а catch и finally должны только чинить проблемы,
             * не вмешиваясь в бизнес логику
             */
            System.out.println("in finally");
            return 24;
        }
    }
}
