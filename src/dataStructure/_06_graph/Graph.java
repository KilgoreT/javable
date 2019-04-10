package dataStructure._06_graph;

public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;
    private char sortedArray[];

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
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(V start, V end) {
        adjMat[start.ordinal()][end.ordinal()] = 1;
        adjMat[end.ordinal()][start.ordinal()] = 1;
    }

    public void addDirectedEdge(V start, V end) {
        adjMat[start.ordinal()][end.ordinal()] = 1;
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

    /**
     * Построение минимального остовного дерева.
     * (Minimum Spanning Tree): где,
     * количество ребер всегда на одно меньше количества вершин.
     */
    public void mst() {

        vertexList[0].wasVisited = true;
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    /**
     * Топологическая сортировка,
     *  например, когда нужно отобразить зависимые элементы от других.
     * На выходе получаем топологически отсортированный граф.
     * Моделирование планирования заданий(элементов) с использованием графов,
     *  называется "анализом критических путей".
     *
     *  Топологическая сортировка должна применяться к графам, не содержащим циклов,
     *  т.е. направленным ациклическим графам.
     */
    public void topo() {
        // сохранение количества вершин
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("Error: Graph has cycles!");
                return;
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }
        System.out.print("Topology sorted order: ");
        for (int index = 0; index < orig_nVerts; index++) {
            System.out.print(sortedArray[index]);
        }
        System.out.println("");
    }

    /**
     * Метод возвращает вершину, не имеющую преемников
     * @return - вершина
     */
    private int noSuccessors() {
        boolean hasEdge;
        for (int row = 0; row < nVerts; row++) {
            hasEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    hasEdge = true;
                    break;
                }
            }
            if (!hasEdge) {
                return row;
            }
        }
        return -1;
    }

    private void deleteVertex(int deletedVertex) {
        if (deletedVertex != nVerts - 1) {
            for (int index = deletedVertex; index < nVerts - 1; index++) {
                vertexList[index] = vertexList[index + 1];
            }
            for (int row = deletedVertex; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }
            for (int col = deletedVertex; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
            nVerts--;
        }
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}
