package GraphsGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 15;
        int maxEdges;
        List<Edge> edges;
        String fileName = "Tests";

        for (int i = 0; i < 70; i++) {
            int edgeCount = 0;

            String fileNameNew = fileName + "" + i;

            maxEdges = n * (n - 1) / 2;
            //edgeCount = n - 1 + new Random().nextInt(maxEdges - (n - 1) + 1); // от (n-1) до max возможных
            edges = generateConnectedGraph(n, maxEdges, 1, new Random().nextInt(2, 10000));

            System.out.println("Вершин: " + n);
            for (Edge edge : edges) {
                System.out.println(edge);
            }
            File dir1 = new File("C:\\Users\\dasts\\Desktop\\Itis\\lol\\AISD\\Semestrovka_1\\src\\main\\java\\Tests");

            try (FileWriter fw = new FileWriter(new File(dir1, "Tests" + i + ".txt"))) {
                fw.write(n + "\n");
                for (Edge edge : edges) {
                    fw.write(edge.toString() + "\n");
                    edgeCount++;
                }
                System.out.println("Граф записан, кол-во входных данных: " + edgeCount);
                n+=2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class Edge {
        int first, second, weight;

        Edge(int first, int second, int weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return first + ", " + second + ", " + weight;
        }
    }
    static List<Edge> generateConnectedGraph(int n, int edgeCount, int minWeight, int maxWeight) {
        Random rand = new Random();
        List<Edge> edges = new ArrayList<>();
        Set<String> existing = new HashSet<>();

        // Сначала создаём остов (связность)
        List<Integer> nodes = new ArrayList<>();
        nodes.add(0);

        while (nodes.size() < n) {
            int first = nodes.get(rand.nextInt(nodes.size()));
            int second;
            do {
                second = rand.nextInt(n);
            } while (nodes.contains(second));

            nodes.add(second);
            int weight = rand.nextInt(maxWeight - minWeight + 1) + minWeight;
            edges.add(new Edge(first, second, weight));
            existing.add(edgeKey(first, second));
        }

        // Добавляем оставшиеся рёбра
        while (edges.size() < edgeCount) {
            int first = rand.nextInt(n);
            int second = rand.nextInt(n);
            if (first != second && !existing.contains(edgeKey(first, second))) {
                int weight = rand.nextInt(maxWeight - minWeight + 1) + minWeight;
                edges.add(new Edge(first, second, weight));
                existing.add(edgeKey(first, second));
            }
        }

        return edges;
    }
    static String edgeKey(int u, int v) {
        return u < v ? u + "-" + v : v + "-" + u;
    }

}
