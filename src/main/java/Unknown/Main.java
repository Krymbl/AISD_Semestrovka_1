package Unknown;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 1);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 4, 4);
        graph.addEdge(2, 3, 4);

        Primo primo = new Primo(graph);
        System.out.println(primo);
    }
}