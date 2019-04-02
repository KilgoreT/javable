package dataStructure._06_graph;

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;

    public enum V {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P
    }

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int ii = 0; ii < MAX_VERTS; ii++) {
                adjMat[i][ii] = 0;
            }
        }
        theStack = new StackX();
        theQueue = new Queue();
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(V start, V end) {
        adjMat[start.ordinal()][end.ordinal()] = 1;
        adjMat[end.ordinal()][start.ordinal()] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    /**
     * Обход в глубину
     */
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int peek) {
        for (int index = 0; index < nVerts; index++) {
            if (adjMat[peek][index] == 1 && vertexList[index].wasVisited == false) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Обход в ширину: реализуется на базе очереди
     * Находит сначало все вершины на расстоянии одного ребра.
     * Это можно использовать для поиска кратчайшего пути от начальной вершины к заданной.
     */
    public void bfs() {

        // начинаем с вершины "ноль"!
        vertexList[0].wasVisited = true;
        displayVertex(0);
        // вставка в конец очереди
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
