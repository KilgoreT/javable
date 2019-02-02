package dataStructure.tree._00_binary;

public class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

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

    // ---- Обход ---- //
    void inOrder() {
        inOrder(root);
    }

    void preOrder() {
        preOrder(root);
    }

    void postOrder() {
        postOrder(root);
    }

    /**
     * Симметричный обход
     * ноды посещаются по мере возрастания их ключа.
     * @param node входная нода
     */
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.showNode());
            inOrder(node.getRight());
        }
    }

    /**
     * Прямой обход
     * пример назначения: обход алгебраического выражения в инфиксной записи.
     * @param node входная нода
     */

    private void preOrder(Node node) {

        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * Обратный обход
     * для постфиксной записи.
     * @param node входная нода
     */
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    Node getMinimum() {

        Node current = root;

        if (current == null) {
            return null;
        }
        while (current != null) {
            if(current.getLeft() != null) {
                current = current.getLeft();
            } else {
                return current;
            }
        }
        return current;
    }

    Node getMaximum() {

        Node current = root;

        if (current == null) {
            return null;
        }
        while (current != null) {
            if(current.getRight() != null) {
                current = current.getRight();
            } else {
                return current;
            }
        }
        return current;
    }


    void delete(int key) {}

}
