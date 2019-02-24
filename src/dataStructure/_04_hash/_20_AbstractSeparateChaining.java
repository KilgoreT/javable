package dataStructure._04_hash;

import dataStructure._04_hash.entity.Link;
import dataStructure._04_hash.entity.SortedList;

/**
 * Метод цепочек.
 * Ключ хэшируется в индекс обычным способом,
 * но элемент добавляется в связанный список.
 * Коэффициен заполнения может быть больше единицы без значительного ущерба для быстродействия.
 *
 * Вместо связанного списка в каждой ячейке могут быть массивы.
 * Их называются гнездами(buckets).
 *
 */
public abstract class _20_AbstractSeparateChaining extends _00_AbstractHashTable<SortedList, Link> {

    _20_AbstractSeparateChaining(int arraySize) {
        super(arraySize);
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

}
