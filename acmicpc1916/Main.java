package acmicpc1916;

import java.io.*;
import java.util.*;

/* 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        City[] c = new City[N + 1];
        for (int i = 0; i <= N; i++) {
            c[i] = new City();
            c[i].nds = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            c[from].nds.add(new Node(to, cost));
            // c[to].nds.add(new Node(from, cost));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Road> pQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pQ.add(new Road(0, start, start));
        int minDist = Integer.MAX_VALUE;
        while (!pQ.isEmpty()) {
            Road cRoad = pQ.poll();
            // System.out.println(cRoad);
            City cow = c[cRoad.next];
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
        System.out.println(minDist);
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

    static class City {
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
