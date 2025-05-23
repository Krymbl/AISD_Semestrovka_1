package GraphElPrimo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
    int iterationCount;
    boolean[] isVertex;
    ArrayList<Edge> primo = new ArrayList();
    int index;
    long time;

    public Prim(Graph graph) {
        index = 0;
        isVertex = new boolean[graph.vertexCount];
        isVertex[index] = true;

        PriorityQueue <Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));

        long startTime = System.nanoTime();

        for (Edge x : graph.edges[index]) {
            priorityQueue.add(x);
        }

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            if (!isVertex[current.second]) {
                primo.add(current);
                isVertex[current.second] = true;

                for (Edge x : graph.edges[current.second]) {
                    if (!isVertex[x.second]) {
                        priorityQueue.add(x);
                        iterationCount++;
                    }
                }
            }
            iterationCount++;


        }
        long stopTime = System.nanoTime();
        time = stopTime - startTime;

    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
//        for (Edge x : primo) {
//            stringBuilder.append(x.first + " <--> " + x.second + " " + x.weight + "\n");
//        }
        stringBuilder.append(time);
        return stringBuilder.toString();
    }
}
