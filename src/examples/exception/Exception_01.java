package examples.exception;

/**
 * Вывод:
 *  1
 *  2
 *  3
 */

public class Exception_01 {
    public static void main(String[] args) {

        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(1);
        }

        System.out.println(2);
    }
}
