package examples.pattern._01_Creational._03_Builder._00_Theory;

import examples.pattern._01_Creational._03_Builder._00_Theory.entity.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Методу {@link PathParser} parse() передается строка,
 * на основаниии анализа которой
 * возвращается {@link PathIF} и у него вызывается метод send()
 * См. далее parse()
 */

public class Main {
    public static void main(String[] args) {
        List<Request> list = new ArrayList();
        list.add(new Request("hui bistro dvor"));
        list.add(new Request("hui bistro dvor ti"));
        list.add(new Request("hui bistro dvor vi"));
        list.add(new Request("zhopa bistro dvor"));
        list.add(new Request("pizda rayon"));
        list.add(new Request("pizda bistro podyezd ti"));


        for (Request request : list) {
            PathParser parser = new PathParser();
            (parser.parse(request)).send();
        }
    }
}
