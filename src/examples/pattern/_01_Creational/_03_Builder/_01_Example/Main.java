package examples.pattern._01_Creational._03_Builder._01_Example;

public class Main {

    public static void main(String[] args) {

        ExampleComplexObject object = new RealBuilder()
                .createBuilder()
                .buildS1("this1")
                .buildS2("this2")
                .build();

        ExampleComplexObject object1 = ExampleComplexObject
                .createBuilder()
                .setS1("that1")
                .setS2("that2")
                .build();

        System.out.println(object.getS1());
        System.out.println(object.getS2());

        System.out.println(object1.getS1());
        System.out.println(object1.getS2());
    }

}
