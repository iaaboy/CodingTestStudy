package acmicpc11779;

import java.io.*;
import java.util.*;

/* 최소비용 구하기 2
 * https://www.acmicpc.net/problem/11779
 * dijkstra , 경로를 저장
 */

public class Main {
    private static Vertex[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int INF = Integer.MAX_VALUE / 2 - 1;
        c = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            c[i] = new Vertex();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            c[from].nds.add(new Node(to, cost));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];
        int[] prev = new int[N + 1];
        for (int distance2 = 0; distance2 < distance.length; distance2++) {
            distance[distance2] = INF;
        }

        PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pQ.add(new Node(start, 0));
        while (!pQ.isEmpty()) {
            Node cRoad = pQ.poll();
            // System.out.println(cRoad);
            Vertex cow = c[cRoad.target];
            if (cRoad.target == end) {
                break;
            }
            for (Node n : cow.nds) {
                if (cRoad.cost + n.cost >= distance[n.target]) {
                    continue;
                }
                distance[n.target] = cRoad.cost + n.cost;
                prev[n.target] = cRoad.target;
                pQ.add(new Node(n.target, cRoad.cost + n.cost));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append("\n");
        Stack<Integer> visited = new Stack<>();
        int now = end;
        while (now != start) {
            visited.add(now);
            now = prev[now];
        }
        visited.add(now);
        sb.append(visited.size()).append("\n");
        while (!visited.empty()) {
            sb.append(visited.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static class Vertex {
        ArrayList<Node> nds = new ArrayList<>();
    }

    static class Node {
        int target;
        int cost;

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
