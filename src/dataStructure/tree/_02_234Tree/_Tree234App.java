package dataStructure.tree._02_234Tree;

public class _Tree234App {

    public static void main(String[] args) {

        Tree234 tree = new Tree234();
        tree.insert(new DataItem(0));
        tree.insert(new DataItem(1));
        tree.insert(new DataItem(2));
        tree.insert(new DataItem(3));
        tree.insert(new DataItem(4));
        tree.insert(new DataItem(5));
        tree.insert(new DataItem(6));
        tree.insert(new DataItem(7));
        tree.insert(new DataItem(8));
        tree.insert(new DataItem(9));
        tree.insert(new DataItem(55));
        tree.insert(new DataItem(33));
        tree.insert(new DataItem(22));

        tree.displayTree();
    }
}
