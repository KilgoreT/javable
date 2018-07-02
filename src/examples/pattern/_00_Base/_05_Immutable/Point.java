package examples.pattern._00_Base._05_Immutable;

/**
 * {@link Point} - объект значений (value object).
 * На объект {@link Point} наложен запрет на изменение.
 * Изменять его может только конструктор при создании,
 * какие-либо методы изменения создают новый объект с новыми значениями.
 * Минусы:
 * 1. иногда все же необходимо синхронизировать доступ,
 * но в джаве присвоение ссылки - это атомарная операция
 * и синхронизировать доступ не требуется.
 * 2. Замена объекта предусматривает копирование значений из старого в новый объект,
 * что может сказаться на производительности.
 */
class Point {

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Point offset(int offsetX, int offsetY) {
        return new Point(x + offsetX, y + offsetY);
    }
}
