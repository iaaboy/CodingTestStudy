package acmicpc23743;

import java.io.*;
import java.util.*;

/* 방탈출, 그래프 최소 스패닝 트리
 * https://www.acmicpc.net/problem/23743
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to, cost);
        }

        groupId = new int[N];
        int[] emergencyPathCost = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            groupId[i] = i;
            emergencyPathCost[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nodes);

        long[] groupCostSum = new long[N];
        for (Node node : nodes) {
            int mergeInto = find(node.from);
            int mergefrom = find(node.to);
            if (mergeInto != mergefrom) {
                long maxEscape = Math.max(emergencyPathCost[mergeInto] , emergencyPathCost[mergefrom]);
                if (maxEscape <= node.cost) {
                    continue;
                }

                union(node.from, node.to);
                groupCostSum[mergeInto] += groupCostSum[mergefrom];
                groupCostSum[mergeInto] += node.cost;
                emergencyPathCost[mergeInto] = Math.min(emergencyPathCost[mergeInto], emergencyPathCost[mergefrom]);
            }
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (groupId[i] == i) {
                sum += emergencyPathCost[i];
                sum += groupCostSum[i];
            }
        }
        System.out.println(sum);
    }

    static int[] groupId;

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

    static class Node implements Comparable<Node> {
        int from, to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}

/*
4 4
1 2 2
2 4 4
1 3 5
3 4 3
5 3 7 8
 */