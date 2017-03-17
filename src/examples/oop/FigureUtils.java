package examples.oop;

/**
 * Created by apomazkin on 16.03.2017.
 */
public class FigureUtils {


    // Overloading
    public static double perimeter(Oval figure) {
        return 2 * Math.PI * figure.radius;
    }

    public static double perimeter(Figure figure) {
        throw new UnsupportedOperationException();
    }
}
