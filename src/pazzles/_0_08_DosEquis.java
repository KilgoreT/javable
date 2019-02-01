package pazzles;

public class _0_08_DosEquis {
    /**
     * исп. "Два Х"
     */
    public static void main(String[] args) {

        char x = 'X';
        int i = 0;

        System.out.print("must be 'X' : ");
        System.out.println(true ? x : 0);

        System.out.print("must be 'X' : ");
        System.out.println(false ? i : x);

        /**
         * Три правила:
         * 1. если второй и третий операторы одного типа, результат будет того же типа.
         * 2. если первый имеет тип Т(byte, short, char), а другой константа int - результат тип Т.
         * 3. во всех остальных случаях работает numeric promotion(контекст преобразования),
         * где используется Identity conversion, либо Widening conversion.
         *
         * т.е.
         *  true ? x : 0 - где первый char, второй константа int - результат char.
         * но
         *  false ? i : x - где первый char, второй int - результат int(widening conversion).
         */

        /**
         * можно переменную int финализировать и тогда получится то, что ожидается увидеть.
         */
        final int ii = 0;
        System.out.print("must be 'X' : ");
        System.out.println(false ? ii : x);

        /**
         * МОРАЛЬ:
         * в тернарном операторе лучше использовать один тип для второго и третьего операнда.
         */
    }
}
