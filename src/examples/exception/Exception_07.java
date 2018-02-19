package examples.exception;

/**
 * Вывод:
 * > in try
 * > in finally
 * > Exception in thread "main" java.lang.RuntimeException
 */
public class Exception_07 {
    public static void main(String[] args) {
        /**
         * этот sout не выполнится никогда,
         * потому что в ходе вызова функции
         * возникнет исключение.
         * Из метода исключение уходит в main.
         */
        System.out.println(f());
    }

    private static int f() {
        try {
            System.out.println("in try");
            throw new RuntimeException();
        } finally {
            /**
             * Чтобы не случилось, после try отработает finally
             * Например, чтобы закрыть какие-то ресурсы,
             * дописать в файлик, отправить ошибку куда-то.
             */
            System.out.println("in finally");
        }
    }
}
