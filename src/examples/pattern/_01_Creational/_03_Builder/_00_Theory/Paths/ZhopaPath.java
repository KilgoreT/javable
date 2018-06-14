package examples.pattern._01_Creational._03_Builder._00_Theory.Paths;

import examples.pattern._01_Creational._03_Builder._00_Theory.PathIF;

public class ZhopaPath implements PathIF {

    private String to;
    private String from;
    private String subject;
    private String speed;

    public ZhopaPath(String to, String from, String subject, String speed) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.speed = speed;
    }

    @Override
    public void send() {
        System.out.println(subject + "! Poshel " + to + " from " + from + "! " + speed + "!!!");
    }
}
