package pazzles;

public class _0_10_AssignmentRules {
    public static void main(String[] args) {

        /**
         * Задача, подобрать такие x и i, чтобы
         * x = x + i - было корректным
         * x += i - не было корректным
         */


        /**
         * Compound Assignment
         */
        // 1. в "op=" оба должны быть примитивами
        int x = 1;
        int i = 1;
        x += i;
        System.out.println("x must be 2 : " + x);

        // 2. правый может быть любым объектом, если левый String(string concatenation)

        String xString = "zhopa";
        xString += new Box("горит");
        System.out.println(xString);

        /**
         * Simple assignment
         */
        // 1. Можно использовать любые объекты,
        // если правая стороны "is assignment compatible" левой стороне.
        // другими словами, их можно присваивать
        //
        Box zhopa = new Box("zhopa");
        System.out.println(zhopa = new Box("не горит"));

        /**
         * Ответ:
         */
        Object xx = "Zhopa";
        String ii = "горит";
        // корректное:
        xx = xx + ii;
        // некорректное:
        xx += ii; // на самом деле в Java8 оно работает! Поправили.
    }
}

class Box {

    private String name;

    public Box(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " " + name;
    }
}