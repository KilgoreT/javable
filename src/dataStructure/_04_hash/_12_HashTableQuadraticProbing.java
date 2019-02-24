package dataStructure._04_hash;

import dataStructure._04_hash.entity.DataItem;

/**
 * Квадратичное пробирование
 *
 * Попытка избежать группировки за счет шага:
 * X + 1^2, X + 2^2, X + 3^2 и т.д.
 *
 * Эта последовательность называется вторичной группировкой.
 * Может генерировать одни и теже смещения, если размер массива не простое число.
 * в этом случае шаг будет увеличиваться до тех пор, пока не переполнится переменная шага.
 *
 * В этом случае важно, чтобы размер массива был простым числом,
 * иначе возможна бесконечная последовательность проверок.
 */
public class _12_HashTableQuadraticProbing extends _10_AbstractOpenAddressing {

    _12_HashTableQuadraticProbing(int arraySize) {
        super(arraySize);
    }

    /**
     * Вставка элемента в таблицу
     *
     * @param item - элемент
     */
    @Override
    public void insert(DataItem item) {
        int step = 1;
        int hashValue = hashFunc(item.getKey());
        // ищем пустую или с удаленным элементом ячейку
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            // шаг
            hashValue = hashValue + getNextIndex(step);
            // если достигнет конца массива
            hashValue %= arraySize;
            // увеличиваем шаг
            step++;
        }
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
        int step = 1;
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem removed = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return removed;
            }
            hashValue = hashValue + getNextIndex(step++);
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
        int step = 1;
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue = hashValue + getNextIndex(step++);
            hashValue %= arraySize;
        }
        return null;
    }

    @Override
    public int getNextIndex(int step) {
        return (int) Math.pow(step, 2);
    }
}
