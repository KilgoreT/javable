package dataStructure._04_hash._00_linear_probing;

public class App {
    public static void main(String[] args) {
        HashTable table = new HashTable(9);
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

        table.insert(new DataItem(7109));
        table.displayTable();

        table.delete(777);
        table.displayTable();
    }
}
