package GraphElPrimo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 70; i++) {
            File dir1 = new File("C:\\Users\\dasts\\Desktop\\Itis\\lol\\AISD\\Semestrovka_1\\src\\main\\java\\Tests");
            int edgeCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(new File(dir1,"Tests" + i + ".txt")))) {
                String line = reader.readLine();
                int vertex = Integer.parseInt(line);
                Graph graph = new Graph(vertex);

//                System.out.println("Кол-во вершин: " + vertex);
//                System.out.println("Содержимое файла:");

                while ((line = reader.readLine()) != null) {
                    edgeCount++;
//                    System.out.println(line);
                    String[] list = line.split(", ");
                    int[] edge = new int[list.length];
                    for (int j = 0; j < list.length; j++) {
                        edge[j] = Integer.parseInt(list[j]);
                    }
                    graph.addEdge(edge[0], edge[1], edge[2]);

                }
                Prim prim = new Prim(graph);
                System.out.println(edgeCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}