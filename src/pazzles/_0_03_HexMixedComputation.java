package pazzles;

/**
 * Created by apomazkin on 21.02.2017.
 */
public class _0_03_HexMixedComputation {
    public static void hexAddition() {
        System.out.println(
                Long.toHexString(0x100000000L + 0xcafebabe)
                /**
                 * Expected result: 1cafebabe
                 * Но получаем: cafebabe.
                 * Почему?
                 * Если отрицательные десятичные числа видно по знаку (-)
                 * то hex пишутся без знака.
                 * Как понять, что hex отрицательно?
                 * Если первый бит(самый старший) установен в 1.
                 * 0xcafebabe == ‭11001010111111101011101010111110‬ b
                 * значит 0xcafebabe - отрицательно.
                 * Приводим 0xcafebabe к Long, получаем:
                 *      0xffffffffcafebabeL
                 *    + 0x0000000100000000L
                 *    = --------------------
                 *      0x00000000cafebabeL
                 *
                 * Исправляется указанием типа Long для второго слагаемого.
                 */
        );
        System.out.println(
                Long.toHexString(0x100000000L + 0xcafebabeL)
                /**
                 * Исправляется указанием типа Long для второго слагаемого.
                 * Вывод: не использовать в выражениях аргументы разных типов.
                 */
        );
    }
}
