package dataStructure.tree._02_234Tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private static final int ORDER = 4;

    private Node parent;
    private int itemCount;
    private List<Node> childs = new ArrayList<>(ORDER);
    private List<DataItem> items = new ArrayList<>(ORDER - 1);
//    private Node[] childs = new Node[ORDER];
//    private DataItem[] items = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childs.add(childNum, child);
//        childs[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childIndex) {
        Node disconnected = childs[childIndex];
        childs[childIndex] = null;
        return disconnected;
    }

    public Node getChild(int childIndex) {
        return childs[childIndex];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childs[0] == null;
    }

    public int getItemCount() {
        return itemCount;
    }

    public DataItem getItem(int itemIndex) {
        return items[itemIndex];
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
            if (items[index] == null) continue;
            long thisKey = items[index].key;
            if (newKey < thisKey) {
                items[index + 1] = items[index];
            } else {
                items[index + 1] = item;
                return index + 1;
            }
        }
        items[0] = item;
        return 0;
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
