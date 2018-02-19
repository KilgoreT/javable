package examples.exception;

/**
 * Вывод:
 * > Code
 * > NullPointerException
 * > Exception in thread "main" java.lang.NullPointerException
 */
public class Exception_06 {
    public static void main(String[] args) {

        try {
            System.out.println("Code");
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            /**
             * как-то поработали с данным исключением
             * и снова его послали
             */
            throw e;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }

        System.out.println("AfterCode");
    }
}
