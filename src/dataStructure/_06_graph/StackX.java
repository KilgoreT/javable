package dataStructure._06_graph;

/**
 * Стек.
 * Используется для обхода в глубину
 */
public class StackX {

    private final int SIZE = 20;
    private int[] stack;
    private int top;

    public StackX() {
        stack = new int[SIZE];
        top = -1;
    }

    public void push(int index) {
        stack[++top] = index;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
