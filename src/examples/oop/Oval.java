package examples.oop;

/**
 * Created by apomazkin on 16.03.2017.
 */
public class Oval extends Figure {
    public int radius;

    public Oval(int radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return "Oval: " + radius + " radius.";
    }
}
