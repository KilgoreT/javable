package examples.pattern._01_Creational._03_Builder._00_Theory;

import examples.pattern._01_Creational._03_Builder._00_Theory.entity.Request;

public class PathParser {
    public static final String TO_HUI = "hui";
    public static final String TO_ZHOPA = "zhopa";
    public static final String TO_PIZDA = "pizda";
    public static final String FROM_RAYON = "rayon";
    public static final String FROM_DVOR = "dvor";
    public static final String FROM_PODYEZD = "podyezd";
    public static final String SUBJECT_TI = "ti";
    public static final String SUBJECT_VI = "vi";
    public static final String SUBJECT_SALAGI = "salagi";
    public static final String SPEED_BISTRO = "bistro";
    private PathBuilder builder;

    PathIF parse(Request request) {
        builder = PathBuilder.getInstance(request.getMessage());
        if (request.getMessage().contains(TO_HUI)) {
            builder.to(TO_HUI);
        } else if (request.getMessage().contains(TO_ZHOPA)) {
            builder.to(TO_ZHOPA);
        } else if (request.getMessage().contains(TO_PIZDA)) {
            builder.to(TO_PIZDA);
        }

        if (request.getMessage().contains(FROM_RAYON)) {
            builder.from(FROM_RAYON);
        } else if (request.getMessage().contains(FROM_DVOR)) {
            builder.from(FROM_DVOR);
        } else {
            builder.from(FROM_PODYEZD);
        }

        if (request.getMessage().contains(SUBJECT_TI)) {
            builder.subject(SUBJECT_TI);
        } else if (request.getMessage().contains(SUBJECT_VI)) {
            builder.subject(SUBJECT_VI);
        } else {
            builder.subject(SUBJECT_SALAGI);
        }

        if (request.getMessage().contains(SPEED_BISTRO)) {
            builder.speed(SPEED_BISTRO);
        }



        return builder.getPath();
    }
}
