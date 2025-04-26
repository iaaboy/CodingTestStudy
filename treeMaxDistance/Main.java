package treeMaxDistance;

import java.util.*;

public class Main {
    static List<Edge>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = 6; // 노드 개수
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 추가: (양방향, u - v, 가중치 w)
        addEdge(0, 2, 540);
        addEdge(1, 2, 1051);
        addEdge(2, 4, 4750);
        addEdge(3, 5, 9476);
        addEdge(3, 4, 9616);

        // 1단계: 임의의 노드에서 DFS
        dfs(1, 0);

        // 2단계: 가장 멀리 있던 노드에서 다시 DFS
        Arrays.fill(visited, false);
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println("트리의 지름(최장 경로 길이): " + maxDist);
    }

    static void addEdge(int u, int v, int w) {
        tree[u].add(new Edge(v, w));
        tree[v].add(new Edge(u, w));
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }

        for (Edge e : tree[node]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight);
            }
        }
    }
}
