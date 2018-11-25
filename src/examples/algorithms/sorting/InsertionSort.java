package examples.algorithms.sorting;

/**
 *
 * Сортировка вставками
 *
 * bigIndex - указывает на очередную целевую позицию.
 * Все что меньше bigIndex - уже отсортировано по отношению друг к другу.
 * т.е. array[0 .. bigIndex - 1] - уже отсортированные,
 * а array[bigIndex + 1 .. n] - еще не просмотренные.
 */

public class InsertionSort {

    private static final int START_OF_ARRAY = 0;

    public static void main(String[] args) {

        int[] array = {8, 2, 5, 3, 6, 1, 9, 7, 4};

        for (int bigIndex = START_OF_ARRAY + 1; bigIndex < array.length; bigIndex++) {      // n

            int key = array[bigIndex];                                                      // n - 1

            for (int littleIndex = bigIndex - 1; littleIndex >= 0; littleIndex--) {         // E(j..n): 2 ^ Tj
                if (array[littleIndex] >  key) {                                            // E(j..n): 2 ^ (Tj - 1)
                    array[littleIndex + 1] = array[littleIndex];                            // E(j..n): 2 ^ (Tj - 1)
                    array[littleIndex] = key;                                               // E(j..n): 2 ^ (Tj - 1)
                }
            }

        }
        showResult(array);
    }

    private static void showResult(int[] list) {
        for (int aList : list) {
            System.out.println(aList);
        }
    }

}
