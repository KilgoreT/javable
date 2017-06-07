package examples.collection.perf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apomazkin on 27.02.2017.
 */
public class ListTest {
    public static void main(String[] args) {
        long t0, t1;
        List<String> list;

        list = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            list.add("" + i);
        }
        t0 = System.currentTimeMillis();
        testListContains(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.contains: " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetFirst(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.get(first): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetLast(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.get(last): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetMiddle(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.get(middle): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertFirst(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.insert(first): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertLast(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.insert(last): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertMiddle(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList.insert(middle): " + (t1 - t0));

        System.out.println();

        list = new LinkedList<>();
        for (int i = 0; i < 10_000; i++) {
            list.add("" + i);
        }
        t0 = System.currentTimeMillis();
        testListContains(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.contains: " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetFirst(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.get(first): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetLast(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.get(last): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListGetMiddle(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.get(middle): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertFirst(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.insert(first): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertLast(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.insert(last): " + (t1 - t0));

        t0 = System.currentTimeMillis();
        testListInsertMiddle(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList.insert(middle): " + (t1 - t0));

    }
    private static void testListContains(List<String> list) {
        for (int i = 0; i < 100_000; i++) {
            list.contains("XYZ");
        }
    }
    private static void testListGetFirst(List<String> list) {
        for (int i = 0; i < 10_000; i++) {
            String value = list.get(0);
        }
    }
    private static void testListGetLast(List<String> list) {
        int size = list.size();
        for (int i = 0; i < 10_000; i++) {
            String value = list.get(size - 1);
        }
    }
    private static void testListGetMiddle(List<String> list) {
        int size = list.size();
        for (int i = 0; i < 100_000; i++) {
            String value = list.get(size / 2);
        }
    }
    private static void testListInsertFirst(List<String> list) {
        for (int i = 0; i < 100_000; i++) {
            list.add(0, "A");
        }
    }
    private static void testListInsertLast(List<String> list) {
        for (int i = 0; i < 10_000; i++) {
            list.add("A");
        }
    }
    private static void testListInsertMiddle(List<String> list) {
        int size = list.size();
        for (int i = 0; i < 100_000; i++) {
            list.add(size / 2, "A");
        }
    }
}
