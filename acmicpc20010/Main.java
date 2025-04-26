package acmicpc20010;

import java.io.*;
import java.util.*;

/* 악덕 영주 혜유
 * https://www.acmicpc.net/problem/20010
최소 신장 트리.
가장 짧은(weight가 작은) 노드부터 검색하며 그룹인지 확인하고, 그룹이 아니면 합친다.

순환이 없는 무방향 그래프에서 최장 길이구하기.
아무거나 root로 잡고 가장 긴 리프노드 탐색(dfs).
탐색된 리프노드 기준으로 다시 한 번 dfs로 가장 긴 리프노드 탐색.
*/

public class Main {
    static int[] ids;
    static boolean[] visited;
    static Vertex[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ids = new int[V];
        v = new Vertex[V];
        for (int i = 0; i < V; i++) {
            ids[i] = i;
            v[i] = new Vertex();
        }
        Node[] n = new Node[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            n[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(n, (a, b) -> a.c - b.c);

        int totalCost = 0;
        int handledCount = 0;
        for (int i = 0; i < E; i++) {
            int s = n[i].s;
            int e = n[i].e;
            int c = n[i].c;
            if (getUnion(s) != getUnion(e)) {
                // System.out.println(s + " - " + e + " (" + n[i].c + ")");
                v[s].node.add(new Edge(e, c));
                v[e].node.add(new Edge(s, c));
                totalCost += n[i].c;
                if (++handledCount == V - 1) {
                    break;
                }
                setUnion(s, e);
            }
        }

        visited = new boolean[V];

        dfs(farNode, 0);
        Arrays.fill(visited, false);
        maxDist = 0;
        dfs(farNode, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(totalCost).append("\n");
        sb.append(maxDist);
        System.out.println(sb);
        // System.out.println(Arrays.toString(v));
    }

    static int maxDist = 0;
    static int farNode = 0;

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }

        for (Edge e : v[node].node) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.weight);
            }
        }
    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
    }

    static class Node {
        int s;
        int e;
        int c;

        public Node(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    static class Edge {
        int to, weight;

        public Edge(int e, int c) {
            this.to = e;
            this.weight = c;
        }

        @Override
        public String toString() {
            return to + "(" + weight + ")";
        }
    }

    static class Vertex {
        ArrayList<Edge> node = new ArrayList<>();

        @Override
        public String toString() {
            return node.toString();
        }
    }
}
