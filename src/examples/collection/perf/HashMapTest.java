package examples.collection.perf;

import java.util.HashMap;

/**
 * Created by apomazkin on 01.03.2017.
 */
public class HashMapTest {
    public static int INITIAL_CAPACITY = 16 * 16 * 16 * 16 * 16;
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(INITIAL_CAPACITY, 1);
        for (int i = 0; i < INITIAL_CAPACITY - 1; i++) {
            map.put(i, -i);
        }
        // ловим процесс расширения HashMap
        long t0 = System.nanoTime();
        map.put(-1, null);
        long t1 = System.nanoTime();
        System.out.println(t1 - t0);

        long t2 = System.nanoTime();
        map.put(-2, null);
        long t3 = System.nanoTime();
        System.out.println(t3 - t2);

        long t4 = System.nanoTime();
        map.put(-3, null);
        long t5 = System.nanoTime();
        System.out.println(t5 - t4);
    }
}
