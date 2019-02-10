package dataStructure.tree._02_234Tree;

public class Tree234 {

    private Node root = new Node();

    public int find(int key) {
        Node current = root;
        int childNumber;
        while (true) {
            if ((childNumber = current.findItem(key)) != -1) {
                return childNumber;
            } else if (current.isLeaf()) {
                return -1;
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
        DataItem itemB;
        DataItem itemC;
        Node parent;
        Node child2;
        Node child3;
        int itemIndex;

        itemC = node.removeItem();
        itemB = node.removeItem();
        child2 = node.disconnectChild(2);
        child3 = node.disconnectChild(3);
        Node newRight = new Node();

        if (node == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, node);
        } else {
            parent = node.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getItemCount();

        for (int i = n - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i +1 , temp);
        }
        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
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
