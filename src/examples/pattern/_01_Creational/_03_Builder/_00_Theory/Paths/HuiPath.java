package examples.pattern._01_Creational._03_Builder._00_Theory.Paths;

import examples.pattern._01_Creational._03_Builder._00_Theory.PathIF;

/**
 * Реализация {@link PathIF}
 * Отличается тем, что посылает "нахуй", а не в какие-либо другие места.
 * В другие места посылает {@link ZhopaPath}, например.
 * При желании, можно создать много направлений (реализаций {@link PathIF}).
 * И это никак не отразится на основном рабочем коде.
 */

public class HuiPath implements PathIF {

    private String to;
    private String from;
    private String subject;

    public HuiPath(String to, String from, String subject) {
        this.to = to;
        this.from = from;
        this.subject = subject;
    }

    @Override
    public void send() {
        System.out.println(subject + "! Poshel " + to + " from " + from);
    }
}
