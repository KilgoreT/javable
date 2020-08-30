package dataStructure._04_hash;

import dataStructure._04_hash.entity.Link;

public class _21_SeparateChainingHashTable extends _20_AbstractSeparateChaining {


    public _21_SeparateChainingHashTable(int arraySize) {
        super(arraySize);
    }

    @Override
    public int getNextIndex(int step) {
        throw new IllegalArgumentException();
    }

    @Override
    public void insert(Link link) {
        int key = link.getKey();
        int hashValue = hashFunc(key);
        hashArray[hashValue].insert(link);
    }
    @Override
    public Link delete(int key) {
        int hashValue = hashFunc(key);
        return hashArray[hashValue].delete(key);
    }

    @Override
    public Link find(int key) {
        int hashValue = hashFunc(key);
        return hashArray[hashValue].find(key);
    }

}
