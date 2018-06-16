package examples.pattern._01_Creational._03_Builder._00_Theory;

import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.HuiBuilder;
import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.OtherBuilder;
import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.ZhopaBuilder;

/**
 * Класс асстрактный.
 * Своих наследников он обязует реализовать какие-то методы.
 * Содержит метод getInstance(),
 * который исходя из содержания передаваемой строки
 * создает соответствующую реализацию {@link PathBuilder}
 * Различные реализации {@link PathBuilder} нужны для того,
 * чтобы строить соответственно различные реализации {@link PathIF}
 * Конкретная реализация {@link PathBuilder}
 * возвращает одну конкретную реализацию {@link PathIF}
 * См. далее пример реализации {@link OtherBuilder}
 */

public abstract class PathBuilder {

    private String speed;

    protected String getSpeed() {
        return speed;
    }

    static PathBuilder getInstance(String dest) {
        PathBuilder builder;
        if (dest.contains("hui")) {
            builder = new HuiBuilder();
        } else if (dest.contains("zhopa")) {
            builder = new ZhopaBuilder();
        } else {
            builder = new OtherBuilder();
        }

        return builder;
    }

    void speed(String value) {
        speed = value;
    }

    public abstract void to(String value);
    public abstract void from(String value);
    public abstract void subject(String value);
    public abstract PathIF getPath();
}
