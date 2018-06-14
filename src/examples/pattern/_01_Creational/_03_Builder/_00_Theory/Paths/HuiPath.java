package examples.pattern._01_Creational._03_Builder._00_Theory.Paths;

import examples.pattern._01_Creational._03_Builder._00_Theory.PathIF;

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
