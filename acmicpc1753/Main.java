package acmicpc1753;

import java.io.*;
import java.util.*;

/* 최단경로
 * https://www.acmicpc.net/problem/1753
 */

public class Main {
    static int INF = -1;
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bf.readLine()); // start

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.get(s).add(new Node(e, w));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        dist[K] = 0;
        while (!q.isEmpty()) {
            Node c = q.poll();
            for (Node node : map.get(c.p)) {
                if (dist[node.p] == INF || dist[c.p] + node.weight < dist[node.p]) {
                    dist[node.p] = dist[c.p] + node.weight;
                    q.add(new Node(node.p, dist[c.p] + node.weight));
                }
            }
        }

        // System.out.println(Arrays.toString(dist));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == -1) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int p;
        int weight;

        public Node(int p, int w) {
            this.p = p;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
