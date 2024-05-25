package acmicpc31871;

import java.io.*;
import java.util.*;

/* 영일랜드
 * https://www.acmicpc.net/problem/31871
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()) + 1; // 놀이기구 개수 + 입구
        int M = Integer.parseInt(bf.readLine()); // 간선 개수

        Vertex[] vt = new Vertex[N];
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> nodes = new HashMap<>();
            vt[i] = new Vertex(nodes);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (!vt[u].nodes.containsKey(v)) {
                vt[u].nodes.put(v, cost);
            } else {
                int curVal = vt[u].nodes.get(v);
                vt[u].nodes.put(v, Math.max(curVal, cost));
            }
        }

        for (Vertex vertex : vt) {
            vertex.priotizedNodes = new ArrayList<>();
            for (Integer key : vertex.nodes.keySet()) {
                vertex.priotizedNodes.add(new Node(key, vertex.nodes.get(key)));
            }
            vertex.priotizedNodes.sort((a, b) -> b.cost - a.cost);
        }

        // for (Vertex vertex : vt) {
        // System.out.println("pNode: " + vertex.priotizedNodes);
        // }

        boolean[] visited = new boolean[N];
        int result = visitNext(vt, 0, visited, 0, N, 0);
        System.out.println(result);
    }

    private static int visitNext(Vertex[] vt, int cur, boolean[] visited, int count, int N, int cost) {
        if (count == N && cur == 0) {
            return cost;
        }
        int finalC = -1;
        for (Node next : vt[cur].priotizedNodes) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                finalC = Math.max(finalC, visitNext(vt, next.to, visited, count + 1, N, cost + next.cost));
                visited[next.to] = false;
            }
        }

        return finalC;
    }

    public static class Vertex {
        public Vertex(HashMap<Integer, Integer> nodes) {
            this.nodes = nodes;
        }

        HashMap<Integer, Integer> nodes;
        ArrayList<Node> priotizedNodes;
    }

    public static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return to + "(" + cost + ")";
        }
    }
}
