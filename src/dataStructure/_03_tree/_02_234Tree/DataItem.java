package dataStructure._03_tree._02_234Tree;

public class DataItem {

    long key;
    String value;

    public DataItem(long key) {
        this.key = key;
        this.value = String.valueOf(key);
    }

    public void display() {
        System.out.print("/" + value);
    }

}
