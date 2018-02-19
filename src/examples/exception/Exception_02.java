package examples.exception;

/**
 * Вывод:
 * > Code
 * > RuntimeException
 * > AfterCode
 */

public class Exception_02 {
    public static void main(String[] args) {

        // из try можно попасть только в один catch
        // срабатывает первый подходящий catch

        /**
         * Если нужно обработать конкретный эксепшн,сначала указывается он.
         * Если далее неважно какие эксепшны - указывается общий класс для них.
         */
        try {
            System.out.println("Code");
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }

        System.out.println("AfterCode");
    }
}
