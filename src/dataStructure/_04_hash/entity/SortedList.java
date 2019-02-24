package dataStructure._04_hash.entity;

public class SortedList {
    private Link first;

    public SortedList() {
        this.first = null;
    }

    public void insert(Link link) {
        int key = link.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
            link.next = current;
        }
    }

    public Link delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            Link deleted = first;
            first = first.next;
            return deleted;
        } else {
            Link deleted = previous.next;
            previous.next = current.next;
            return deleted;
        }
    }

    public Link find(int key) {
        Link current = first;

        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
