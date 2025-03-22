package acmicpc1865;

import java.io.*;
import java.util.*;

/* 웜홀
 * https://www.acmicpc.net/problem/1865
벨만포드로 음수 사이클이 존재하는지 확인한다.!!!
벨만 포드를 한 번 돌리고, 음수 사이클이 존재하는지 각 노드에 대해 확인.
 */

public class Main {
    static int INF = Integer.MAX_VALUE;
    static Edge[] roads;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            roads = new Edge[M * 2 + W];
            int idx = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                roads[idx++] = new Edge(from, to, weight);
                roads[idx++] = new Edge(to, from, weight);
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                int weight = Integer.parseInt(st.nextToken());
                roads[idx++] = new Edge(from, to, -weight);
            }

            String result = "NO\n";
            distance = new int[N];
            Arrays.fill(distance, INF);
            bellmanFord();
            for (int i = 0; i < N; i++) {
                if (!checkRoads(i)) {
                    result = "YES\n";
                    break;
                }
            }
            sb.append(result);
        }
        System.out.print(sb);
    }

    static int[] distance;

    public static void bellmanFord() {

        for (int i = 0; i < distance.length; i++) {
            distance[i] = 0;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < roads.length; j++) {
                int u = roads[j].source;
                int v = roads[j].dest;
                int weight = roads[j].weight;

                if (distance[u] != INF && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }
    }

    static boolean checkRoads(int source) {
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i].source;
            int v = roads[i].dest;
            int weight = roads[i].weight;
            if (distance[u] != INF && distance[u] + weight < distance[v]) {
                // System.out.println("Error occurred. Negative edge weight cycles detected");
                return false;
            }
        }
        return true;
    }

    static class Edge {
        int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
