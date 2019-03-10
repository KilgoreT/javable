package examples.types;

public class BinaryOperation {

    public static void main(String[] args) {
//       int i = 77;
//       showNumber(i);
//       showNumber(i >>> 1);
//       showNumber(0x55555555);
//       showNumber((i >>> 1) & 0x55555555);
//        showNumber(77777L);
//        showNumber(1L << 10);
//        showNumber((1L << 10) - 1);
//        showNumber(77777L & ((1L << 10) - 1));
//        compareNumber(77777L, (77777L & ((1L << 10) - 1)));
    }

    public static void showNumber(int number) {
        System.out.println("Decimal: " + number +
                "; binary: " + Integer.toBinaryString(number) +
                "; hex: " + Integer.toHexString(number));
    }

    public static void showNumber(long number) {
        System.out.println("Decimal: " + number +
                "; binary: " + Long.toBinaryString(number) +
                "; hex: " + Long.toHexString(number));
    }

    public static void compareNumber(long first, long second) {
        System.out.println(">>>: " + String.format("%64s", Long.toBinaryString(first)).replace(" ", "0"));
        System.out.println(">>>: " + String.format("%64s", Long.toBinaryString(second)).replace(" ", "0"));
    }

    /**
     * Мы хотим посчитать количество бит в long числе,
     * но не все,
     * а только до какого-то определенного бита.
     * Например, в 1111111010 проверить первые 4 бита и получить результат 2.
     * @param index - индекс, до которого считаются биты.
     * @param data - число, в котором высчитываются биты
     * @return - количество битов единиц
     *
     *  (1L << index) - 1 - получаем цепочку выставленных единиц нужной длины
     *  через коньюнцию удаляем все выставленные единицы, позиция которых превышает длину
     *  передаем полученное число в Long.bitCount()
     */
    public static int countOnesBefore(int index, long data) {
        final int BITS_PER_WORD = Long.SIZE;
        if (index >= BITS_PER_WORD) {
            return Long.bitCount(data);
        }
        return Long.bitCount(data & ((1L << index) - 1));
    }

    /**
     * Получить подрят нужное количество бинарных единиц.
     * @param length - длинна выражения из бинарных единиц
     * @return получившееся число.
     *
     *  1L << length - единицу просто переносим на необходимый отступ
     *  вычитаем единицу и получаем число со всеми включенными битами нужной длинны
     */
    private static long getOnesWithLength(int length) {
        return (1L << length) - 1;
    }
}
