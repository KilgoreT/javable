package dataStructure.tree._02_234Tree;


public class Node {

    private static final int ORDER = 4;
    public static final int FIRST_INDEX = 0;

    private Node parent;
    private int itemCount;

    private Node[] children = new Node[ORDER];
    private DataItem[] items = new DataItem[ORDER - 1];

    public void connectChild(int index, Node child) {
        children[index] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int index) {
        Node disconnected = children[index];
        children[index] = null;
        return disconnected;
    }

    public Node getChild(int index) {
        return children[index];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return children[FIRST_INDEX] == null;
    }

    public int getItemCount() {
        return itemCount;
    }

    public DataItem getItem(int index) {
        return items[index];
    }

    public boolean ifFull() {
        return itemCount == ORDER - 1;
    }

    public int findItem(long key) {
        for(int index = 0; index < ORDER - 1; index++) {
            if (items[index] == null) {
                break;
            } else if (items[index].key == key) {
                return index;
            }
        }
        return -1;
    }

    public int insertItem(DataItem item) {
        itemCount++;
        long newKey = item.key;

        for (int index = ORDER - 2; index >= 0; index--) {

            if (items[index] == null) {
                continue;
            }

            long thisKey = items[index].key;
            if (newKey < thisKey) {
                items[index + 1] = items[index];
            } else {
                items[index + 1] = item;
                return index + 1;
            }
        }
        items[FIRST_INDEX] = item;
        return FIRST_INDEX;
    }

    public DataItem removeItem() {
        DataItem removed = items[itemCount - 1];
        items[itemCount - 1] = null;
        itemCount--;
        return removed;
    }

    public void display() {
        for (int index = 0; index < itemCount; index++) {
            items[index].display();
        }
        System.out.println("/");
    }
}
