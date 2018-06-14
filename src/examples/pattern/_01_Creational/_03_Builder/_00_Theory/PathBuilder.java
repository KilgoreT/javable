package examples.pattern._01_Creational._03_Builder._00_Theory;

import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.HuiBuilder;
import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.OtherBuilder;
import examples.pattern._01_Creational._03_Builder._00_Theory.Builders.ZhopaBuilder;

public abstract class PathBuilder {

    private String speed;

    public String getSpeed() {
        return speed;
    }

    static PathBuilder getInstance(String dest) {
        PathBuilder builder = null;
        if (dest.contains("hui")) {
            builder = new HuiBuilder();
        } else if (dest.contains("zhopa")) {
            builder = new ZhopaBuilder();
        } else {
            builder = new OtherBuilder();
        }

        return builder;
    }
    public abstract void to(String value);
    public abstract void from(String value);
    public void speed(String value) {
        speed = value;
    }
    public abstract void subject(String value);
    public abstract PathIF getPath();
}
