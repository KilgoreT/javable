package dataStructure._04_hash._00_linear_probing;

/**
 * Квадратичное пробирование
 *
 * Попытка избежать группировки за счет шага:
 * X + 1^2, X + 2^2, X + 3^2 и т.д.
 *
 * Эта последовательность называется вторичной группировкой.
 *
 * В этом случае важно, чтобы размер массива был простым числом,
 * иначе возможна бесконечная последовательность проверок.
 */
public class HashTableQuadraticProbing extends HashTable {

    public HashTableQuadraticProbing(int arraySize) {
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
        int hashValue = getHashCode(item.getKey());
        // ищем пустую или с удаленным элементом ячейку
        while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
            // шаг
            hashValue = hashValue + generateNextStep(step);
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
        int hashValue = getHashCode(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                DataItem removed = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return removed;
            }
            hashValue = hashValue + generateNextStep(step++);
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
        int hashValue = getHashCode(key);
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            hashValue = hashValue + generateNextStep(step++);
            hashValue %= arraySize;
        }
        return null;
    }

    @Override
    protected int generateNextStep(int step) {
        return (int) Math.pow(step, 2);
    }
}
