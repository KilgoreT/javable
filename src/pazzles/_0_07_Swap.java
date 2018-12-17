package pazzles;

public class _0_07_Swap {
    public static void main(String[] args) {

        int x = 77;
        System.out.println("x = " + x + "; binary = " + Integer.toBinaryString(x));
        int y = 66;
        System.out.println("y = " + y + "; binary = " + Integer.toBinaryString(y));

/*        System.out.println(Integer.toBinaryString(x));
        System.out.println("^");
        System.out.println(Integer.toBinaryString(y));
        System.out.println("=");
        System.out.println(Integer.toBinaryString(x^y));*/

        /**
         * Результат XOR между двумя числами - маска
         * присваиваем ее одному из чисел.
         */
        // 1001101 (77) x
        // 1000010 (66) y
        // =
        // 0001111 (15) новое x - маска

        /**
         * Результат XOR между маской(новым значением одного из числа) и другим числом
         * будет бывшее значение переменной, в которой сейчас маска
         * присваиваем это значение второму числу, таким образом значение первого числа перешло во второе
         */

        // 1000010(y) ^ 0001111(mask) = 1001101(x)

        /**
         * Таким же образом ксоризуя маску и второе число(со значением первого)
         * и присваивая результат во второе число - получаем туда значение первого числа
         */
        // 1001101(y) ^ 0001111(mask) = 1000010(x)

        /**
         * т.е. (x ^ y ^ x) == y;
         */

        int x1 = x;
        int y1 = y;
        int mask = x1 ^ y1;
        x = x^y;

        System.out.println("x(" + x + ") = x(" + x1 +") ^ y("+ y1 +") -> " + x);
        y = y^x;
        System.out.println("y(" + y + ") = y(" + y1 +") ^ x("+ x +") -> " + y);
        x = y^x;
        System.out.println("x(" + x + ") = y(" + y +") ^ x("+ mask +") -> " + x);

        /**
         * Мораль
         * вся эта хуйня при текущих ресурсах неоправдана, так как такой код не ясен.
         */
        int xx = 1984;
        int yy = 2001;

        xx ^= yy ^=  xx ^= yy;
        System.out.println("xx = " + xx + "; yy = " + yy);

        /**
         * Это три XOR в одном выражении. Это работает в С,
         * но в JAVA это гарантированно не работает.
         * Операнды операторов работают слева направо.
         */
        int xxx = 1984;
        int yyy = 2001;

        //xxx ^= yyy ^= xxx ^= yyy;

        int tmp1 = xxx ^ yyy;
        System.out.println("(xxx ^= yyy) ^= xxx ^= yyy : " +  tmp1);
        xxx = tmp1;
        int tmp2 = tmp1 ^ xxx;
        System.out.println("((xxx ^= yyy) ^= xxx) ^= yyy : " +  tmp2);
        yyy = tmp2;
        int tmp3 = tmp2 ^ yyy;
        xxx = tmp3;
        System.out.println("(((xxx ^= yyy) ^= xxx) ^= yyy) : " +  tmp3);

        /**
         * вобщем, получается не то, что планировали получить.
         * можно сделать так:
         */
        xxx = 1984;
        yyy = 2001;
        yyy = (xxx ^= (yyy ^= xxx)) ^ yyy;
        System.out.println("x = " + xxx + " ; y = " + yyy);
        /**
         * но это трудночитаемый пиздец и так лучше не делать.
         */

        /**
         * МОРАЛЬ!!!
         * не нужно в одном выражении! одной и той же переменной присваивать значение больше чем один раз!
         * все эти программистские трюки остались в 90х. Код должен быть читаемый!
         */

    }
}
