package acmicpc5972;

import java.io.*;
import java.util.*;

/* 택배 배송
 * https://www.acmicpc.net/problem/5972
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Cow[] c = new Cow[N + 1];
        for (int i = 0; i < N; i++) {
            c[i] = new Cow();
            c[i].nds = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int fr = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            c[fr].nds.add(new Node(to, cost));
            c[to].nds.add(new Node(fr, cost));
        }

        PriorityQueue<Road> pQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pQ.add(new Road(0, 0, 0));

        while (!pQ.isEmpty()) {
            Road cRoad = pQ.poll();
            System.out.println(cRoad);
            Cow cow = c[cRoad.nd];
            for (Node n : cow.nds) {
                if (n.target == cRoad.prev)
                    continue;
                if (n.target == N - 1) {
                    System.out.println(cRoad.distance + n.cost);
                    return;
                }
                pQ.add(new Road(cRoad.distance + n.cost, n.target, cRoad.nd));
            }

        }
    }

    static class Road {
        int distance;
        int nd;
        int prev;

        public Road(int distance, int nd, int prev) {
            this.distance = distance;
            this.nd = nd;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return nd + ":" + distance;
        }
    }

    static class Cow {
        ArrayList<Node> nds;
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
