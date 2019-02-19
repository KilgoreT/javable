package dataStructure._03_tree._02_234Tree;

public class Tree234 {

    private Node root = new Node();

    /**
     * Поиск элемента по ключу.
     * @param key ключ
     * @return DataItem
     */
    public DataItem find(int key) {
        Node current = root;
        int index;
        while (true) {
            if ((index = current.findItem(key)) != -1) {
                return current.getItem(index);
            } else if (current.isLeaf()) {
                return null;
            } else {
                current = getNextChild(current, key);
            }
        }
    }


    public void insert(DataItem item) {
        Node current = root;
        while (true) {
            if (current.ifFull()) {
                split(current);
                current = current.getParent();
                current = getNextChild(current, item.key);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(current, item.key);
            }
        }
        current.insertItem(item);
    }

    public void split(Node node) {

        Node parent;
        int itemIndex;

        // itemC уходит в nextNode
        DataItem itemC = node.removeItem();
        //itecB уходит в родителя
        DataItem itemB = node.removeItem();

        // Потомки для nextNode
        Node nextNodeChild2 = node.disconnectChild(2);
        Node nextNodeChild3 = node.disconnectChild(3);

        // 1. Построение nextNode: элемент itemC и два потомка
        Node nextNode = new Node();
        nextNode.insertItem(itemC);
        nextNode.connectChild(0, nextNodeChild2);
        nextNode.connectChild(1, nextNodeChild3);

        // если разбиваемый является root,
        // инициируем новый root
        // и добавляем потомком старый root
        if (node == root) {
            root = new Node();
            root.connectChild(0, node);
            parent = root;
        } else {
            parent = node.getParent();
        }

        // 2. itemB уходит к предку
        itemIndex = parent.insertItem(itemB);

        int itemCount = parent.getItemCount();
        // для наглядности обозначаю индекс самого старшего элемента предка
        int lastIndex = itemCount - 1;

        // перемещение связей родителя на одного потомка вправо
        // на случай, если после itemB есть еще элементы.
        for (int i = lastIndex; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1 , temp);
        }
        // 3. добавление nextNode к предку по нужному индексу.
        parent.connectChild(itemIndex + 1, nextNode);

    }

    public Node getNextChild(Node node, long key) {
        int index;
        int itemCount = node.getItemCount();
        for (index = 0; index < itemCount; index++) {
            if (key < node.getItem(index).key) {
                return node.getChild(index);
            }
        }
        return node.getChild(index);
    }

    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node node, int level, int childNumber) {

        System.out.print("level = " + level + " child = " + childNumber + " ");
        node.display();

        int itemCount = node.getItemCount();
        for (int i = 0; i < itemCount + 1; i++) {
            Node nextNode = node.getChild(i);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, i);
            } else {
                return;
            }
        }
    }

}
