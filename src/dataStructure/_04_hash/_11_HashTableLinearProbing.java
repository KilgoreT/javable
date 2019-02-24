package dataStructure._04_hash;

import dataStructure._04_hash.entity.DataItem;

/**
 * Линейное пробирование.
 *
 * Если индекс массива уже занят другим объектом,
 * то объект записывается в следующую свободную ячейку
 * с шагом X + 1, X + 2, X + 3 и т.д.
 *
 * => возникают группы элементов.
 * Эта разновидность группировки называется первичной.
 * Группировка снижает быстродействие таблицы.
 */
public class _11_HashTableLinearProbing extends _10_AbstractOpenAddressing {

    public _11_HashTableLinearProbing(int arraySize) {
        super(arraySize);
    }

    /**
     * Вставка элемента в таблицу
     *
     * @param item - элемент
     */
    @Override
    public void insert(DataItem item) {

        int hashValue = hashFunc(item.getKey());

        // пока не встретится пустая ячейка массива,
        // либо с объектом, помеченным на удаление,
        // продолжаем увеличивать хэш-значение на один пункт.
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            ++hashValue;
            hashValue %= arraySize;
            // а если все ячейки массива заполнены, то будет жопа
            // оставим ее для научной пользы
        }
        // раз мы здесь - нашлась пустая ячейка.
        hashArray[hashValue] = item;
    }

    /**
     * Удаление элемента таблицы по ключу
     *
     * @param key - ключ
     * @return удаляемый элемент
     */
    @Override
    public DataItem delete(int key) {
        int hashValue = hashFunc(key);

        // если ячейка не пустая, значит удаляемый элемент находится в ней,
        // либо дальше в последовательности ячеек.
        // если последовательность прервется, а элемент не найден, возвращается null
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem removed = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return removed;
            }
            ++hashValue;
            // при достижении конца таблицы
            hashValue %= arraySize;
        }
        return null;
    }

    /**
     * Поиск элемента по ключу
     *
     * @param key - ключ
     * @return найденный элемент
     */
    @Override
    public DataItem find(int key) {
        int hashValue = hashFunc(key);

        // в этот раз проверяем, чтобы цепочка обрывалась только пустой ячейкой.
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue = getNextIndex(hashValue);
            hashValue %= arraySize;
        }
        return null;
    }

    @Override
    public int getNextIndex(int step) {
        return ++step;
    }
}
