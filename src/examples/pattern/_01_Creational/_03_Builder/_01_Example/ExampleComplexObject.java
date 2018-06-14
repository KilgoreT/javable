package examples.pattern._01_Creational._03_Builder._01_Example;

public class ExampleComplexObject {
    private String s1;
    private String s2;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public static TheBuilder createBuilder() {
        return new TheBuilder();
    }

    public static class TheBuilder {
        private ExampleComplexObject o;

        public TheBuilder() {
            this.o = new ExampleComplexObject();
        }

        public TheBuilder setS1(String s1) {
            o.setS1(s1);
            return this;
        }
        public TheBuilder setS2(String s2) {
            o.setS2(s2);
            return this;
        }
        public ExampleComplexObject build() {
            return o;
        }

    }
}
