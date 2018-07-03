package examples.pattern._00_Base._07_Proxy;

public class MutableInteger {

    public int val;

    public MutableInteger(int value) {
        setValue(value);
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

}
