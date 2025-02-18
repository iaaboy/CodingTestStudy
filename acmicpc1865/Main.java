package acmicpc1865;

import java.io.*;
import java.util.*;

public class Main {
    static long INF = Long.MAX_VALUE / 2 - 1;
    static Vertex[] v;
    static long[][] cost;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            v = new Vertex[N + 1];
            for (int i = 0; i < N + 1; i++) {
                v[i] = new Vertex();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                v[s].neighbor.add(new Node(e, w));
                v[e].neighbor.add(new Node(s, w));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(bf.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                v[s].neighbor.add(new Node(e, -w));
            }
            cost = new long[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], INF);
            }

            boolean result = false;
            for (int i = 1; i <= N; i++) {
                traverse(i);
                // System.out.println(i + " -> " + cost[i][i]);
                if (cost[i][i] < 0) {
                    result = true;
                    break;
                }
            }
            if (result) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    private static void traverse(int start) {
        Queue<State> q = new ArrayDeque<>();
        q.add(new State(start, 0));
        while (!q.isEmpty()) {
            State c = q.poll();
            // System.out.println(c);
            int next = c.index;
            for (Node n : v[next].neighbor) {
                if (n.visited < start && cost[start][n.end] > c.weight + n.weight) {
                    cost[start][n.end] = c.weight + n.weight;
                    n.visited = start;
                    q.add(new State(n.end, c.weight + n.weight));
                }
            }
        }
    }

    static class Vertex {
        ArrayList<Node> neighbor = new ArrayList<>();
    }

    static class Node {
        int end;
        long weight;
        int visited = 0;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class State {
        int index;
        long weight;

        public State(int index, long weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return index + "(" + weight + ")";
        }
    }
}

/*
1
4 2 2
3 4 1
2 4 1
1 2 1
1 3 10

 * 
 */