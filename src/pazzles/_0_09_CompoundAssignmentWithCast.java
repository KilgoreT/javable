package pazzles;

public class _0_09_CompoundAssignmentWithCast {
    public static void main(String[] args) {

        short x = 0;
        int i = 123456;

        System.out.println("x += i : " + (x += i));

        /**
         * Assignment compound operator:
         *  E1 op= E2 эквивалентно E1 = (T) ((E1) op (E2)), где Т тип E1.
         *
         *  т.е. присутствует скрытый каст.
         *  Если результат присваивания шире, чем переменная E1,
         *  то срабатывает скрытое narrowing primitive conversion.
         *
         *  Таким образом,
         *   в x += i, результат сложения кастится в short и значение теряет свою точность.
         */

        /**
         * казалось бы идентичное по смыслу выражение x = x + i
         * выдаст error: incompatible types: possible lossy conversion from int to short
         */

        /**
         * МОРАЛЬ:
         * внимательно следить, чтобы в compound assignment использовался одинаковый тип
         * и чтобы результат не выходил за границы этого типа.
         */
    }
}
