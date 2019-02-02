package dataStructure.tree._00_binary;

public class _TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert( 50, "+");
        tree.insert( 25, "*");
        tree.insert( 75, "-");
        tree.insert( 15, "15");
        tree.insert( 12, "12");
        tree.insert( 70, "70");
        tree.insert( 99, "99");

        Node found = tree.find(99);
        if (found != null) {
            System.out.println(found.showNode());
        } else {
            System.out.println("Node is null");
        }

        System.out.println("Симметричный обход:");
        tree.inOrder();

        System.out.println("\nПрямой обход:");
        tree.preOrder();

        System.out.println("\n\nОбратный обход:");
        tree.postOrder();

        System.out.println("\n\nПоиск минимума:");
        System.out.println(tree.getMinimum().showNode());

        System.out.println("\nПоиск максимума:");
        System.out.println(tree.getMaximum().showNode());
    }
}
