package dataStructure._04_hash._00_linear_probing;

/**
 * Линейное пробирование.
 */
public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            } else {
                System.out.print("*** ");
            }
        }
        System.out.println("");
    }

    /**
     * Хэш функция.
     * Благодаря остатку от деления блаблаблаблаблабла
     *
     * @param key - ключ
     * @return значение хэш-кода
     */
    public int getHashCode(int key) {
        return key % arraySize;
    }

    /**
     * Вставка элемента в таблицу
     *
     * @param item - элемент
     */
    public void insert(DataItem item) {

        int hashValue = getHashCode(item.getKey());

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
    public DataItem delete(int key) {
        int hashValue = getHashCode(key);

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
     * Удаление элемента из таблицы
     *
     * @param item - удаляемый элемент
     * @return DataItem - удаленный элемент
     */
    public DataItem delete(DataItem item) {
        return delete(item.getKey());
    }

    /**
     * Поиск элемента по ключу
     *
     * @param key - ключ
     * @return найденный элемент
     */
    public DataItem find(int key) {
        int hashValue = getHashCode(key);

        // в этот раз проверяем, чтобы цепочка обрывалась только пустой ячейкой.
        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getKey() == key) {
                return hashArray[hashValue];
            }
            ++hashValue;
            hashValue %= arraySize;
        }
        return null;
    }

    /**
     * Поиск элемента в таблице по значению элемента
     *
     * @param item - искомый элемент
     * @return - найденный элемент
     */
    public DataItem find(DataItem item) {
        return find(item.getKey());
    }


}
