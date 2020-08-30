package examples.algorithms.sorting.merge;

public class Merge {

    public void sort(int[] data) {

    }

    // p <= q < r
    // [p..q] [q+1..r]
    // 3, 7, 11
    // [3..7]      [8..11]
    //    5           4
    //    4(с нуля)
    public void merge(int[] data) {

        int p = 0;
        int q = data.length / 2 - 1;
        int r = data.length - 1;


        int n1 = q - p + 1;
        int n2 = r - q;

        int[] listL = new int[n1];
        int[] listR = new int[n2];

        for (int i = 0; i < n1; i++) {
            listL[i] = data[p + i];
        }

        for (int i = 0; i < n2; i++) {
            listR[i] = data[q + 1 + i];
        }

        print(listL);
        print(listR);

        if (listL.length != 1) {
            merge(listL);
        }
//
        if (listR.length != 1) {
            merge(listR);
        }

        int indexL = 0;
        int indexR = 0;

        for (int i = p; i <= r; i++) {
            if (indexL > q) {
                data[i] = listR[indexR];
                indexR++;
                continue;
            }
            if (indexR > q) {
                data[i] = listL[indexL];
                indexL++;
                continue;
            }

            if (listL[indexL] <= listR[indexR]) {
                data[i] = listL[indexL];
                indexL++;
            } else {
                data[i] = listR[indexR];
                indexR++;
            }
        }

        print(data);

    }

    private void print(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            sb.append("; ");
        }
        System.out.println(sb.toString());
    }
}
