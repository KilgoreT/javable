package dataStructure._03_tree._00_binary;

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


    boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // поиск удаляемого узла
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                isLeftChild = true;
                parent = current;
                current = parent.getLeft();
            } else {
                isLeftChild = false;
                parent = current;
                current = parent.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        // если у удаляемого нет потомков
        if (hasNoChild(current)) {
            if (current == root) {
                root = null;
                return true;
            }
            if (isLeftChild) {
                parent.setLeft(null);
                return true;
            }
            if (!isLeftChild) {
                parent.setRight(null);
                return true;
            }
        }

        // если у удаляемого левый потомок
        if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
                return true;
            }
            if (isLeftChild) {
                parent.setLeft(current.getLeft());
                return true;
            }
            if (!isLeftChild) {
                parent.setRight(current.getLeft());
                return true;
            }
        }

        // если у удаляемого правый потомок
        if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
                return true;
            }
            if (isLeftChild) {
                parent.setLeft(current.getRight());
                return true;
            }
            if (!isLeftChild) {
                parent.setRight(current.getRight());
                return true;
            }
        }

        // если у удаляемого есть оба потомка
        Node successor = getSuccessor(current);
        if (current == root) {
            root = successor;
            return true;
        }
        if (isLeftChild) {
            parent.setLeft(successor);
            successor.setLeft(current.getLeft());
            return true;
        }
        if (!isLeftChild) {
            parent.setRight(successor);
            successor.setLeft(current.getLeft());
            return true;
        }
        return false;
    }

    /**
     * Чтобы удалить ноду с двумя потомками,
     * нужно заменить ее на преемника(successor).
     * Преемник - та нода правого потомка,
     * которая имеет наименьший ключь(но этот ключ больше чем у удаляемой ноды)
     * Т.е.
     * 1. преемник вырезается из правого потомка удаляемой ноды и подставляется на место удаляемой ноды
     * 2. правым потомком преемника становится правый потомок удаляемой ноды.
     * @param delNode удаляемая нода
     * @return нода-преемник
     */
    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRight();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        // проверяется тот случай, когда правый потомок является преемником,
        // т.е. правый потомок не имеет левой ветки.
        if (successor != delNode.getRight()) {
            // у преемника по определению нет левых потомков, но могут быть правые
            // поэтому предку преемника добавляем в левую ветвь правого потомка преемника
            successorParent.setLeft(successor.getRight());
            // преемнику в правую ветвь добавляем правую ветвь удаляемой ноды.
            successor.setRight(delNode.getRight());
        }
        return successor;
    }


    private boolean hasNoChild(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
