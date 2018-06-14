package examples.pattern._01_Creational._03_Builder._01_Example;

abstract class AbstractBuilder {
    protected ExampleComplexObject o;

    public ExampleComplexObject getExampleComplexObject() {
        return o;
    }

    public abstract RealBuilder createBuilder();

    public abstract RealBuilder buildS1(String s1);
    public abstract RealBuilder buildS2(String s2);
    public abstract ExampleComplexObject build();
}
