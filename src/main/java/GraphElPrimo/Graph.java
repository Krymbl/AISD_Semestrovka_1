package GraphElPrimo;

import java.util.ArrayList;

public class Graph {
    ArrayList<Edge>[] edges;
    int vertexCount;
    int[] vertex;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        edges = new ArrayList[vertexCount];
        vertex = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertex[i] = i;
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int first, int second, int weight) {
        Edge edge = new Edge(first, second, weight);
        edges[first].add(edge);
        edges[second].add(new Edge(second,first,weight));
    }
}
