package acmicpc28019;

import java.io.*;
import java.util.*;

/* 산지니의 여행계획
 * https://www.acmicpc.net/problem/28019
 */

public class Main {
    static Node[] nodes;
    static Vertex[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            nodes[i] = new Node(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()));
        }

        int start = Integer.parseInt(bf.readLine()) - 1;

        groupId = new int[N];
        for (int i = 0; i < N; i++) {
            groupId[i] = i;
        }

        Arrays.sort(nodes);
        for (Node node : nodes) {
            if (find(node.from) != find(node.to)) {
                node.isMainRoad = true;
                union(node.from, node.to);
            }
        }

        v = new Vertex[N];
        for (int i = 0; i < N; i++) {
            v[i] = new Vertex();
        }
        long nodeCostSum = 0;
        for (Node node : nodes) {
            if (node.isMainRoad) {
                nodeCostSum += node.cost;
                v[node.from].nodeIndexes.add(node);
                v[node.to].nodeIndexes.add(node);
            }
        }
        nodeCostSum += nodeCostSum;

        // System.out.println("nodeCostSum: " + nodeCostSum);

        visited = new boolean[N];
        visited[start] = true;
        travel(start, 0);

        // System.out.println(Arrays.toString(groupId));
        // System.out.println(Arrays.toString(nodes));
        // System.out.println(maxRoad);
        System.out.println(nodeCostSum - maxRoad);
    }

    static class Vertex {
        ArrayList<Node> nodeIndexes = new ArrayList<>();
    }

    static long maxRoad = 0;

    private static void travel(int start, long curSum) {
        // System.out.println("travel: " + start + "," + curSum);
        boolean anyHandled = false;
        for (Node next : v[start].nodeIndexes) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                anyHandled = true;
                travel(next.to, curSum + next.cost);
            }
            if (!visited[next.from]) {
                visited[next.from] = true;
                anyHandled = true;
                travel(next.from, curSum + next.cost);
            }
        }
        if (!anyHandled) {
            maxRoad = Math.max(curSum, maxRoad);
        }
    }

    static int[] groupId;
    static boolean[] visited;

    static int find(int id) {
        if (id == groupId[id])
            return id;
        return groupId[id] = find(groupId[id]);
    }

    static boolean union(int a, int b) {
        int groupA = find(a);
        int groupB = find(b);
        if (groupA == groupB) {
            return false;
        }
        groupId[groupB] = groupA;
        return true;
    }

    static class Node implements Comparable<Node> {
        int from, to, cost;
        boolean isMainRoad;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost - cost;
        }

        @Override
        public String toString() {
            return (from + 1) + "->" + (to + 1) + "(" + cost + "," + isMainRoad + ")";
        }
    }
}
