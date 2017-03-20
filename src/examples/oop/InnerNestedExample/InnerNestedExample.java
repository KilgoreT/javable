package examples.oop.InnerNestedExample;

/**
 * Created by apomazkin on 17.03.2017.
 */
public class InnerNestedExample {
    private String privateField = "InnerNestedExample";
    private static String staticField = "static InnerNestedExample";

    /**
     * Inner класс находится внутри другого класса.
     * Inner класс имеет доступ к private полям того класса, в который он вложен.
     */
    class Inner {
        Inner() {
            privateField = "Inner";
            staticField = "static Inner";
        }
    }


    /**
     * Nested класс тоже вложен в другой класс.
     * но он static, а значит имеет доступ
     * только к static полям класса, в который он вложен.
     */
    static class Nested {
        Nested() {
            //privateField = "Nested";
            staticField = "static Nested";
        }
    }

}
