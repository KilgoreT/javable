package examples.pattern._01_Creational._03_Builder._01_Example;

public class RealBuilder extends AbstractBuilder {
    @Override
    public RealBuilder createBuilder() {
        o = new ExampleComplexObject();
        return this;
    }

    @Override
    public RealBuilder buildS1(String s1) {
        o.setS1(s1);
        return this;
    }

    @Override
    public RealBuilder buildS2(String s2) {
        o.setS2(s2);
        return this;
    }

    @Override
    public ExampleComplexObject build() {
        return o;
    }

}
