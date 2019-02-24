package dataStructure._04_hash;

/**
 * HashTable Example
 *
 * Коэффициент заполнения - отношение количества элементов в таблице к размеру таблицы.
 */
public abstract class _00_AbstractHashTable<T, M> {


    T[] hashArray;
    int arraySize;
    M nonItem;


    _00_AbstractHashTable(int arraySize) {
        this.arraySize = arraySize;
    }

    /**
     * Хэш функция.
     * Здесь это остаток от деления.
     *
     * Требования к хэш-фукнции:
     * 1. Быстрые вычисления.
     * 2. Случайные ключи:
     *  в идеале у каждого значения ключа - уникальный индекс.
     *  на практике, приходится сжимать большой диапазон ключей в меньший диапазон индексов,
     *  например, формулой: индекс = ключ % размер_массива.
     *  из ключа нужно исключить неинформативные части.
     *  включить ВСЕ необходимые данные! каждая часть ключа должна вносить свой вклад в вычисление.
     *
     * @param key - ключ
     * @return значение хэш-кода
     */
    int hashFunc(int key) {
        return key % arraySize;
    }

    public abstract int getNextIndex(int step);

    public abstract void insert(M item);
    public abstract M delete(int key);
    public abstract M find(int key);
}
