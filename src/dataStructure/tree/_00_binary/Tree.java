package dataStructure.tree._00_binary;

public class Tree {

    private Node root;

    Node find(int key) {

        Node current = root;

        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return  null;
            }
        }
        return current;
    }

    void insert(int key, Object data) {

        Node newNode = new Node();
        newNode.setKey(key);
        newNode.setData(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;

        while (current.getKey() != newNode.getKey()) {

            if (newNode.getKey() < current.getKey()) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    return;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                        return;
                }
                current = current.getRight();
            }
        }
    }

    void delete(int key) {}

}
