package examples.algorithms.sorting.insertion;

public class Main {

    public static void main(String[] args) {

        int[] list = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] list1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Insertion insertion = new Insertion();
//        insertion.sortDec(list);
        insertion.sortIncEnd(list1);
    }


}
