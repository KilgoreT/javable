package dataStructure._06_graph;

import dataStructure._06_graph.Graph.V;

public class App {
    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(V.A, V.C);
        graph.addEdge(V.C, V.E);
        graph.addEdge(V.E, V.D);
        graph.addEdge(V.E, V.G);
        graph.addEdge(V.D, V.B);
        graph.addEdge(V.G, V.F);

        System.out.println("Visit: ");
        graph.dfs();

    }
}
