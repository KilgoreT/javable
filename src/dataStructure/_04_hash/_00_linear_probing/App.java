package dataStructure._04_hash._00_linear_probing;

public class App {
    public static void main(String[] args) {
//        _00_HashTableLinearProbing table = new _00_HashTableLinearProbing(9);
        _01_HashTableQuadraticProbing table = new _01_HashTableQuadraticProbing(13);
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
