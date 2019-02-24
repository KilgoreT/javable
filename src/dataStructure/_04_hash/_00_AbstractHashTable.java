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
