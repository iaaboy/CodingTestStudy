package acmicpc30797;

import java.io.*;
import java.util.*;

/* 가희와 여행가요
 * https://www.acmicpc.net/problem/30797
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[Q];
        groupId = new int[N];
        for (int i = 0; i < N; i++) {
            groupId[i] = i;
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to, cost, time);
        }
        Arrays.sort(nodes);

        long costSum = 0;
        int timeMax = 0;
        for (Node node : nodes) {
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                costSum += node.cost;
                timeMax = Math.max(timeMax, node.time);
            }
        }

        int groupIdCount = 0;
        for (int i = 0; i < N; i++) {
            if (groupId[i] == i) {
                groupIdCount++;
            }
        }

        if (groupIdCount == 1) {
            System.out.println(timeMax + " " + costSum);
        } else {
            System.out.println(-1);
        }
    }

    static class Node implements Comparable<Node> {
        int from, to;
        int cost, time;

        public Node(int from, int to, int cost, int time) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (cost == o.cost) {
                return time - o.time;
            } else {
                return cost - o.cost;
            }
        }

        @Override
        public String toString() {
            return from + "-" + to + "(" + cost + "," + time + ")";
        }
    }

    static int groupId[];

    static int find(int x) {
        if (groupId[x] == x)
            return x;
        return groupId[x] = find(groupId[x]);
    }

    // Union-Find: union
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)
            return false;
        groupId[rootB] = rootA;
        return true;
    }
}
