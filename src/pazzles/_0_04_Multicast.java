package pazzles;

public class _0_04_Multicast {
    public static void main(String[] args) {

        System.out.println(
                (int)(char)(byte) -1
        );

        /**
         * int -> byte (narrowing primitive conversion)
         * Отсекаются все, кроме младших 8 битов.
         * Итог: это все еще -1
         * или byte 11111111
         */

        /**
         * byte -> char (widening and narrowing primitive conversion)
         * поэтому byte -> int -> char
         * byte -> int это 32 включенных бита
         * int -> char это 16 включенных битов.
         * Итог: 65535
         */

        /**
         * char -> int
         * Итог: 65535
         */

        char c = 'a';
        /**
         * char
         * единственный беззнаковый тип.
         * лучше избегать его конвертации в более широкий тип.
         * если не нужен знак - использовать битовую маску:
         */
        int i = c & 0xffff;

        /**
         * если нужен знак,
         * кастить char в short
         */
        int ii = (short) c;

        /**
         * byte -> char
         */
        byte b = 0b1111111 ;
        char сс = (char) (b & 0xff); // если byte -> char и не нужен знак - использовать маску
        char ccc = (char) b;         // если нужен знак


    }
}
