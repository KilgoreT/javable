package examples.pattern._01_Creational._03_Builder._00_Theory.Builders;

import examples.pattern._01_Creational._03_Builder._00_Theory.PathBuilder;
import examples.pattern._01_Creational._03_Builder._00_Theory.PathIF;
import examples.pattern._01_Creational._03_Builder._00_Theory.Paths.HuiPath;

public class OtherBuilder extends PathBuilder {
    private String to;
    private String from;
    private String subject;


    @Override
    public void to(String value) {
        to = value;
    }

    @Override
    public void from(String value) {
        from = value;
    }

    @Override
    public void subject(String value) {
        subject = value;
    }

    @Override
    public PathIF getPath() {
        return new HuiPath(to, from, subject);
    }
}
