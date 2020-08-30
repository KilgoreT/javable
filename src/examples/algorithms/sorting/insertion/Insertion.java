package examples.algorithms.sorting.insertion;

import static examples.algorithms.Const.SECOND_ELEMENT;

class Insertion {

    void sortInc(int[] data) {
        print("Before", data);

      /*
            Внешний цикл по массиву
            Границы внешнего:
                от второго элемента(SECOND или 1)
                до последнего элемента массива(length - 1)

            Внутренний цикл:
            Границы:
                от первого элемента(FIRST или 0)
                до первого элемента внешнего цикла
            |innerIndex|...|externalIndex|...|length - 1|

            @param key - всегда первый элемент внешнего цикла
       */
        for (int externalIndex = SECOND_ELEMENT; externalIndex < data.length; externalIndex++) {
            int key = data[externalIndex];
            int innerIndex = externalIndex - 1;

            while (innerIndex >= 0 && data[innerIndex] > key) {
                data[innerIndex + 1] = data[innerIndex];
                innerIndex = innerIndex - 1;
            }
            data[innerIndex + 1] = key;
        }

        print("After", data);

    }

    void sortDec(int[] data) {
        print("Before", data);
        for (int externalIndex = data.length - 2; externalIndex >= 0; externalIndex--) {
            int key = data[externalIndex];
            int innerIndex = externalIndex + 1;
            while (innerIndex <= data.length - 1 && data[innerIndex] > key) {
                data[innerIndex - 1] = data[innerIndex];
                innerIndex = innerIndex + 1;
            }
            data[innerIndex - 1] = key;
        }
        print("After", data);
    }

    // <<<<<<<<<
    // |[externalIndex]|[innerIndex]|length - 1|
    void sortIncEnd(int[] data) {
        print("Before", data);
        for (int externalIndex = data.length - 2; externalIndex >= 0; externalIndex--) {
            int key = data[externalIndex];
            int innerIndex = externalIndex + 1;

            while (innerIndex < data.length - 1 && data[innerIndex] > key) {
                data[innerIndex - 1] = data[innerIndex];
                innerIndex++;
            }
            if (innerIndex == data.length - 1 && data[innerIndex] > key) {
                data[innerIndex - 1] = data[innerIndex];
                data[innerIndex] = key;
            } else {
                data[innerIndex - 1] = key;
            }
        }
        print("After", data);

    }

    private void print(String title, int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            sb.append("; ");
        }
        System.out.println(title + ": " + sb.toString());
    }
}
