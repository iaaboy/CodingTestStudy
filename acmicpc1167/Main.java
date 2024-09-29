package acmicpc1167;

/* 트리의 지름
 * https://www.acmicpc.net/problem/1167
 */

import java.io.*;
import java.util.*;

public class Main {
    static Vertex[] ver;
    static int maxTree = 0;
    static int farPoint = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(bf.readLine());
        ver = new Vertex[V + 1];
        for (int i = 0; i < ver.length; i++) {
            ver[i] = new Vertex();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int n = 1;
            int c = 1;
            while (true) {
                n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }
                c = Integer.parseInt(st.nextToken());
                ver[v].nodes.add(new Node(n, c));
            }
        }

        boolean[] visited = new boolean[V + 1];
        visited[1] = true;
        visit(visited, 1, 0);
        if (farPoint != 0) {
            visited = new boolean[V + 1];
            visited[farPoint] = true;
            visit(visited, farPoint, 0);
        }
        // System.out.println(i + ":" + maxTree);

        // for (int i = 0; i < ver.length; i++) {
        // System.out.println(i + ":" + ver[i]);
        // }

        System.out.println(maxTree);

    }

    private static void visit(boolean visited[], int cur, int cost) {
        if (ver[cur].nodes.size() == 1) {
            if (maxTree < cost) {
                maxTree = cost;
                farPoint = cur;
                // System.out.println(cur + ":" + cost);
            }

        }
        for (Node n : ver[cur].nodes) {
            if (!visited[n.node]) {
                visited[n.node] = true;
                visit(visited, n.node, cost + n.cost);
            }
        }
    }

    static class Vertex {
        ArrayList<Node> nodes = new ArrayList<>();

        @Override
        public String toString() {
            return nodes.toString();
        }
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return node + "(" + cost + ")";
        }
    }
}
