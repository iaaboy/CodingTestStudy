package BellmanFord;

import java.util.Arrays;

class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFord {
    static final int INFINITY = Integer.MAX_VALUE;

    public static void bellmanFord(Edge[] edges, int edgeCount, int nodeCount, int source) {
        int[] distance = new int[nodeCount];
        Arrays.fill(distance, INFINITY);
        distance[source] = 0;

        for (int i = 0; i < nodeCount - 1; i++) {
            for (int j = 0; j < edgeCount; j++) {
                int u = edges[j].source;
                int v = edges[j].dest;
                int weight = edges[j].weight;

                if (distance[u] != INFINITY && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (int i = 0; i < edgeCount; i++) {
            int u = edges[i].source;
            int v = edges[i].dest;
            int weight = edges[i].weight;
            if (distance[u] != INFINITY && distance[u] + weight < distance[v]) {
                System.out.println("Error occurred. Negative edge weight cycles detected");
                return;
            }
        }

        for (int i = 0; i < nodeCount; i++) {
            System.out.println("The shortest distance between nodes " + source + " and " + i + " is " + 
                               (distance[i] == INFINITY ? "INFINITY" : distance[i]));
        }
    }

    public static void main(String[] args) {
        int nodeCount = 5;
        Edge[] edges = {
            new Edge(0, 1, 6),
            new Edge(0, 2, 7),
            new Edge(1, 2, 8),
            new Edge(1, 3, 5),
            new Edge(1, 4, -4),
            new Edge(2, 3, -3),
            new Edge(2, 4, 9),
            new Edge(3, 1, -2),
            new Edge(4, 3, 7)
        };

        bellmanFord(edges, edges.length, nodeCount, 0);
        // bellmanFord(edges, edges.length, nodeCount, 1);
    }
}
