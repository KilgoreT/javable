package examples.collection;

import static java.lang.Math.abs;

/**
 * Простая реализация HashMap
 * Для чего: ускорения добавления и поиска, так как соответствие между hashcode и бакетом вычисляется.
 * Недостатки: память потребляется даже нулевыми бакетами.
 * Для того, чтобы от роста данных не было задержек, увеличивают размер массива бакетов и проводят "рехэшинг",
 * т.е. перераспределение записей по бакетам.
 */
public class Maps {
    public static void main(String[] args) {
        System.out.println("0");
    }
}


class XHashMap<K, V> implements XMap<K, V> {
    /**
     * if (count * 0.75 > size) {
     *     идет rehashing: увеличивается количество бакетов.
     * }
     */
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;
    private final static int DEFAULT_INITIAL_CAPACITY = 16;

    private final float loadFactor;
    /**
     * внутри HashMap массив, его элементы наз. buckets.
     * в бакете находится первый элемент связанного списка.
     */
    private Entry<K, V>[] table;
    private int size = 0;

    public XHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public  XHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        table = new Entry[initialCapacity];
    }

    @Override
    public void put(K key, V value) {
        /**
         * При добавлении:
         * 1. вычисляется hashcode (ключ)
         * 2. вычисляется индекс бакета
         * т.е. соотношение между ключем и бакетом не хранится, а вычисляется.
         */
        int bucketIndex = abs(key.hashCode()) % table.length;
        Entry<K, V> currentEntry = table[bucketIndex];
        table[bucketIndex] = new Entry<K, V>(key, value, currentEntry);
        size++;
        if (size * loadFactor > table.length) {
            Entry<K, V>[] newTable = new Entry[table.length * 2];
            transfer(this.table, newTable);
        }
    }

    private void transfer(Entry<K, V>[] oldTable, Entry<K, V>[] newTable) {
        for (int oldBucketIndex = 0; oldBucketIndex < oldTable.length; oldBucketIndex++) {
            Entry<K, V> oldEntry = oldTable[oldBucketIndex];
            while (oldEntry != null) {
                K key = oldEntry.key;
                V value = oldEntry.value;
                int newBucketIndex = key.hashCode() % newTable.length;
                Entry<K, V> newEntry = newTable[newBucketIndex];
                newTable[newBucketIndex] = new Entry<> (key, value, newEntry);
            }
        }
    }

    /**
     * поиск производится по ключу.
     */
    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public void remove(K key) {
        throw new UnsupportedOperationException();
    }

}


/**
 * Нода для структуры LinkedList
 * @param <K0> - ключ.
 * @param <V0> - значение
 *  next - ссылка на следующую ноду.
 */
class Entry<K0, V0> {
    final K0 key;
    V0 value;
    Entry<K0, V0> next;

    Entry(K0 key, V0 value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


interface XMap<K, V> {
    //K key;
    //V value;
    void put(K key, V value);
    V get(K ke);
    boolean containsKey(K key);
    void remove(K key);
}
