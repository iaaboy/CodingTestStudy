package acmicpc1504;

import java.io.*;
import java.util.*;

/* 특정한 최단 경로
 * https://www.acmicpc.net/problem/1504
 */

public class Main {
    private static Vertex[] c;
    private static ArrayList<Node> nodesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        c = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            c[i] = new Vertex();
            c[i].nds = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Node nd1 = new Node(to, cost);
            nodesList.add(nd1);
            c[from].nds.add(nd1);
            Node nd2 = new Node(from, cost);
            nodesList.add(nd2);
            c[to].nds.add(nd2);
        }

        st = new StringTokenizer(bf.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int su = dijkstra(1, u);
        int uv = dijkstra(u, v);
        int vn = dijkstra(v, N);

        int resultSUVN = su + uv + vn;
        if (su == -1 || uv == -1 || vn == -1) {
            resultSUVN = Integer.MAX_VALUE;
        }

        int sv = dijkstra(1, v);
        int vu = dijkstra(v, u);
        int un = dijkstra(u, N);

        int resultSVUN = sv + vu + un;
        if (sv == -1 || vu == -1 || un == -1) {
            resultSVUN = Integer.MAX_VALUE;
        }

        int result = Math.min(resultSUVN, resultSVUN);
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        System.out.println(result);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Road> pQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pQ.add(new Road(0, start, start));
        int minDist = Integer.MAX_VALUE;
        while (!pQ.isEmpty()) {
            Road cRoad = pQ.poll();
            // System.out.println(cRoad);
            Vertex cow = c[cRoad.next];
            if (cRoad.next == end && minDist > cRoad.distance) {
                minDist = cRoad.distance;
                break;
            }
            for (Node n : cow.nds) {
                if (n.visited) { // 같은 노드를 재방문 하지 않도록 함
                    continue;
                }
                if (n.target == cRoad.prev)
                    continue;
                if (cRoad.distance + n.cost >= minDist) {
                    continue;
                }
                n.visited = true;
                // System.out.println(cRoad.next + " -> " + n.target + " , " + cRoad.distance +
                // " " + n.cost);
                pQ.add(new Road(cRoad.distance + n.cost, n.target, cRoad.next));
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }
        for (Node nd : nodesList) {
            nd.visited = false;
        }
        return minDist;
    }

    static class Road {
        int distance;
        int next;
        int prev;

        public Road(int distance, int next, int prev) {
            this.distance = distance;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return next + ":" + distance;
        }
    }

    static class Vertex {
        ArrayList<Node> nds;
    }

    static class Node {
        int target;
        int cost;
        boolean visited;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return target + "(" + cost + ")";
        }
    }
}
