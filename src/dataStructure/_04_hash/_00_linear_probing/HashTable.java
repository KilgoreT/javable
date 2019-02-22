package dataStructure._04_hash._00_linear_probing;

/**
 * HashTable Example
 *
 * Коэффициент заполнения - отношение количества элементов в таблице к размеру таблицы.
 */
public abstract class HashTable {

    protected DataItem[] hashArray;
    protected int arraySize;
    protected DataItem nonItem;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
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

    public abstract void insert(DataItem item);
    public abstract DataItem delete(int key);
    public abstract DataItem find(int key);

    protected abstract int generateNextStep(int step);

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
     * Поиск элемента в таблице по значению элемента
     *
     * @param item - искомый элемент
     * @return - найденный элемент
     */
    public DataItem find(DataItem item) {
        return find(item.getKey());
    }

    /**
     * вывод таблицы на экран
     */
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

}
