package dataStructure.tree._00_binary;

public class _TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert( 50, "50 objects");
        tree.insert( 25, "25 objects");
        tree.insert( 75, "75 objects");
        tree.insert( 15, "15 objects");
        tree.insert( 12, "12 objects");
        tree.insert( 99, "99 objects");

        Node found = tree.find(99);
        if (found != null) {
            System.out.println(found.showNode());
        } else {
            System.out.println("Node is null");
        }
    }
}
