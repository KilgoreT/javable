package examples.pattern._01_Creational._03_Builder._00_Theory;

import examples.pattern._01_Creational._03_Builder._00_Theory.entity.Request;

/**
 * {@link PathParser} создан исключительно для того,
 * чтобы обрабатывать некую строку
 * и на основании ее создавать {@link PathBuilder} builder.
 */

class PathParser {
    private static final String TO_HUI = "hui";
    private static final String TO_ZHOPA = "zhopa";
    private static final String TO_PIZDA = "pizda";
    private static final String FROM_RAYON = "rayon";
    private static final String FROM_DVOR = "dvor";
    private static final String FROM_PODYEZD = "podyezd";
    private static final String SUBJECT_TI = "ti";
    private static final String SUBJECT_VI = "vi";
    private static final String SUBJECT_SALAGI = "salagi";
    private static final String SPEED_BISTRO = "bistro";
    private PathBuilder builder;


    /**
     * Создает соответствующий builder исходя из содержания передаваемой строки.
     * Далее исходя из какого-то анализа строки, передает в builder некие параметры.
     * В конце вызывает {@link PathBuilder} getPath(),
     * который возвращает из метода {@link PathIF}
     *
     * @param request строка на входе для анализа
     * @return объект {@link PathIF}
     */
    PathIF parse(Request request) {
        /**
         * Создается builder методом {@link PathBuilder} getInstance()
         * Пока мы не знаем, какая именно реализация {@link PathBuilder} создается.
         */
        builder = PathBuilder.getInstance(request.getMessage());
        /**
         * На основании содержания в строке каких-то слов,
         * в builder передаются параметры
         */
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


        /**
         * Возвращается какоя-то реализация {@link PathIF}
         * Cм. далее {@link PathBuilder}
         */
        return builder.getPath();
    }
}
