package examples.exception;


/**
 * Вывод:
 * > Code
 * > NullPointerException
 * > Exception in thread "main" java.lang.ArithmeticException
 */
public class Exception_05 {
    public static void main(String[] args) {

        try {
            System.out.println("Code");
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            /**
             * Этот AE не может обработаться нижеследующим catch,
             * потому что тот catch ловит только из try,
             * к которому относится.
             */
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            /**
             * Данный catch относится к try
             * и не ловит исключения в других catch
             */
            System.out.println("ArithmeticException");
        }

        System.out.println("AfterCode");
    }
}
