package pazzles;

/**
 * Created by apomazkin on 21.02.2017.
 */
public class LongDivision {
    public static void longDivision() {
        /** MICROS_PER_DAY
         * в переменной вызывается переполнение,
         * потому что, хотя тип финальной переменной long,
         * ее составляющие даны как int.
         * Приведение к long происходит уже после переполнения в рассчетах "24 * 60 * 60 * 1000 * 1000",
         * поэтому результат деления неверный
         */
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        /**
         * MICROS_PER_DAY_L
         * первый множитель в формате long,
         * поэтому дальнейшее вычисление будет происходить с приведением к long
         * ВНИМАНИЕ: лучше использовать ЗАГЛАВНУЮ L, что бы не путать с единицей(1 и l).
         */
        final long MICROS_PER_DAY_L = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY_L = 24L * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY_L / MILLIS_PER_DAY_L);

        /**
         * When working with large numbers,
         * watch out for overflow—it’s a silent killer.
         * Решения два:
         * вызывать исключение, если произошло переполнение (как в ADA) или
         * автоматически приводить к более вместительному типу при переполнении (как в Lisp)
         * НО это дополнительные издержки производительности и в JAVA этого нет.
         */
    }
}
