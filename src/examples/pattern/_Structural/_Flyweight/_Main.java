package examples.pattern._Structural._Flyweight;

public class _Main {

    private static final String TYPE_DEVELOPER = "developer";
    private static final String TYPE_DUCK = "duck";
    private static final String TYPE_BULLET = "bullet";

    public static void main(String[] args) {
        AnimalsContainer container = new AnimalsContainer();

        for (int i = 0 ; i < 100; i++) {
            if (isDeveloper(i)) {
                int count = (int) Math.round(Math.sqrt(i));
                container.addProps(TYPE_DEVELOPER, "хуяк-хуяк и в продакшн", count);
                continue;
            }

            if (isDack(i)) {
                int count = (int) Math.round(Math.sqrt(i));
                container.addProps(TYPE_DUCK, "кря", count);
            }

            if (isBullet(i)) {
                int count = (int) Math.round(Math.sqrt(i));
                container.addProps(TYPE_BULLET, "шшш", count);
            }
        }

        container.boooo();

    }

    private static boolean isBullet(int i) {
        if (Integer.bitCount(i) == 5) {
            return true;
        }
        return false;
    }

    private static boolean isDack(int i) {
        if (Integer.bitCount(i) == 3) {
            return true;
        }
        return false;
    }

    private static boolean isDeveloper(int i) {
        if (Integer.bitCount(i) == 1) {
            return true;
        }
        return false;
    }
}
