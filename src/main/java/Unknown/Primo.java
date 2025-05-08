package Unknown;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Primo {
    boolean[] isVertex;
    ArrayList<Edge> primo = new ArrayList();
    int indexStart;

    public Primo(Graph graph) {
        indexStart = 0;
        isVertex = new boolean[graph.vertexCount];
        isVertex[indexStart] = true;

        PriorityQueue <Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));

        for (Edge x : graph.edges[indexStart]) {
            priorityQueue.add(x);
        }

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            if (!isVertex[current.second]) {
                primo.add(current);
                isVertex[current.second] = true;
            }

            for (Edge x : graph.edges[current.second]) {
                if (!isVertex[x.second]) {
                    priorityQueue.add(x);
                }
            }
        }

    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edge x : primo) {
            stringBuilder.append(x.first + " <--> " + x.second + " " + x.weight + "\n");
        }
        return stringBuilder.toString();
    }
}
