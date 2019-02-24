package dataStructure._04_hash;

import dataStructure._04_hash.entity.DataItem;

public class App {
    public static void main(String[] args) {
//        _11_HashTableLinearProbing table = new _11_HashTableLinearProbing(13);
//        _12_HashTableQuadraticProbing table = new _12_HashTableQuadraticProbing(13);
        _13_HashTableDoubleHashing table = new _13_HashTableDoubleHashing(13);
//        _21_SeparateChainingHashTable table = new _21_SeparateChainingHashTable(13);
        table.displayTable();

        table.insert(new DataItem(41));
        table.displayTable();

        table.insert(new DataItem(777));
        table.displayTable();

        table.insert(new DataItem(2));
        table.displayTable();

        table.insert(new DataItem(18));
        table.displayTable();

        table.insert(new DataItem(19));
        table.displayTable();

        table.insert(new DataItem(20));
        table.displayTable();

        table.insert(new DataItem(37));
        table.displayTable();

        table.insert(new DataItem(42));
        table.displayTable();

        table.insert(new DataItem(2));
        table.displayTable();

        table.insert(new DataItem(7));
        table.displayTable();

        table.insert(new DataItem(7109));
        table.displayTable();

        table.delete(777);
        table.displayTable();
    }
}
