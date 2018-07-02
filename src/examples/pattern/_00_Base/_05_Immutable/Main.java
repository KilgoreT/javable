package examples.pattern._00_Base._05_Immutable;

/**
 * Шаблон Immutable
 * 1. повышает надежность объектов,
 * которые совместно используют ссылки на один и тот же объект,
 * 2. уменьшает затраты на параллельный доступ к объекту.
 * см. {@link Point}
 */
public class Main {

    private Point point = new Point(1, 1);

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        System.out.println(point.getX() + " " + point.getY());
        point = point.offset(2, 1);
        System.out.println(point.getX() + " " + point.getY());

    }
}
