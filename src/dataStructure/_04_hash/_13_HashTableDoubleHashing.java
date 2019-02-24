package dataStructure._04_hash;

import dataStructure._04_hash.entity.DataItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Двойное хэширование.
 * Предпочтение следует оставлять за ним
 *
 * Смещение генерируется в зависимости от ключа:
 * хэширование ключа другой хэш-функцией.
 *
 * Требования к вторичной хэш-функции:
 * 1. Вторичная хэш-функция не должна совпадать с первичной.
 * 2. Ее результат никогда не должен быть нулем. Иначе смещения не будет.
 * Для этой задачи подходит:
 * смещение = константа - (ключ % константа), где
 * константа - простое число, меньшее размера массива.
 * При такой функции смешение варьируется от 1 до константы.
 *
 */
public class _13_HashTableDoubleHashing extends _10_AbstractOpenAddressing {

    public _13_HashTableDoubleHashing(int arraySize) {
        super(arraySize);
    }

    @Override
    public void insert(DataItem item) {
        int hashValue = hashFunc(item.getKey());
        // в отличии от других реализаций открытой адресации, шаг высчитывается по вторичной хэш-функции от ключа.
        int step = secondHashFunc(item.getKey());
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            hashValue += step;
            hashValue %= arraySize;
        }
        hashArray[hashValue] = item;
    }

    @Override
    public DataItem delete(int key) {
        int hashValue = hashFunc(key);
        int step = secondHashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem removed = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return removed;
            }
            hashValue += step;
            hashValue %= arraySize;
        }
        return null;
    }

    @Override
    public DataItem find(int key) {
        int hashValue = hashFunc(key);
        int step = secondHashFunc(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue += step;
            hashValue %= arraySize;
        }
        return null;
    }

    @Override
    protected int hashFunc(int key) {
        return key % arraySize;
    }

    @Override
    public int getNextIndex(int step) {
        throw new NotImplementedException();
    }

    private int secondHashFunc(int key) {
        return 5 - key % 5;
    }
}
