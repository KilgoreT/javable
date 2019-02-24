package dataStructure._04_hash;

import dataStructure._04_hash.entity.DataItem;

/**
 *
 * Методы открытой адрессации:
 * 1. Линейное пробирование
 * 2. Квадратичное пробирование
 * 3. Двойное хэширование
 *
 */
public abstract class _10_AbstractOpenAddressing extends _00_AbstractHashTable<DataItem, DataItem> {

    _10_AbstractOpenAddressing(int arraySize) {
        super(arraySize);
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
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
    void displayTable() {
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
