package dataStructure._04_hash._00_linear_probing;

public class App {
    public static void main(String[] args) {
//        HashTableLinearProbing table = new HashTableLinearProbing(9);
        HashTableQuadraticProbing table = new HashTableQuadraticProbing(13);
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
