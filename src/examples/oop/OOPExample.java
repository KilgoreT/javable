package examples.oop;

/**
 * Created by apomazkin on 16.03.2017.
 */
public class OOPExample {
    public static void main(String[] args) {

    /**
     * Ссылка figure имеет тип Figure.
     * Объект в хипе имеет тип Oval.
     */
    Figure figure = new Oval(5);
    Oval oval = new Oval(5);

    /**
     * Если у объекта вызывается метод,
     * то используется правая часть,
     * то есть тип будет Oval.
     * и в итоге метод info() вызывается
     * не у типа Figure, а у типа Oval.
     */
    System.out.println(figure.info());

    /**
     *  Если в метод передается объект figure,
     *  то используется левая часть,
     *  то есть тип будет Figure.
     *  Соответственно, сигнатура метода perimeter будет такая:
     *  perimeter(Figure figure), а не perimeter(Oval figure)
     *  и это на уровне компилятора
     *  называется Overloading
     */

    //System.out.println(FigureUtils.perimeter(oval));
    FigureUtils.perimeter(figure);

    }
}
