package examples.oop.InnerNestedExample;

/**
 * Created by apomazkin on 17.03.2017.
 */
public class InnerNestedExample {
    private String privateField = "InnerNestedExample";
    private static String staticField = "static InnerNestedExample";

    class Inner {
        Inner() {
            privateField = "Inner";
            staticField = "static Inner";
        }
    }

    static class Nested {
        Nested() {
            //privateField = "Nested";
            staticField = "static Nested";
        }
    }

}
