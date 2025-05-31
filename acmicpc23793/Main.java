package acmicpc23793;

import java.io.*;
import java.util.*;

/* 두 단계 최단 경로 1
 * https://www.acmicpc.net/problem/23793
 */

public class Main {
    static ArrayList<Node>[] v;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        v = new ArrayList[N + 1];
        for (int i = 0; i < v.length; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            v[start].add(new Node(end, dist));
        }

        st = new StringTokenizer(bf.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int xy = getDistance(X, -1, Y);
        int yz = getDistance(Y, -1, Z);
        // System.out.println();
        int xyz = getDistance(X, Y, Z);

        if (xy > 0 && yz > 0) {
            System.out.println(xy + yz + " " + xyz);
        } else {
            System.out.println("-1 " + xyz);
        }
    }

    static int getDistance(int X, int Y, int Z) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[X] = 0;
        if (Y != -1) {
            dist[Y] = 0;
        }

        PriorityQueue<Pass> pq = new PriorityQueue<>();
        pq.offer(new Pass(X, 0));

        while (!pq.isEmpty()) {
            Pass cur = pq.poll();
            // System.out.println(c);

            if (dist[cur.index] < cur.dist) {
                continue;
            }
            if (cur.index == Z) {
                return cur.dist;
            }

            for (Node next : v[cur.index]) {
                int nextVal = cur.dist + next.dist;
                if (nextVal < dist[next.to]) {
                    pq.offer(new Pass(next.to, nextVal));
                    dist[next.to] = nextVal;
                }
            }
        }
        if (dist[Z] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[Z];
    }

    static class Pass implements Comparable<Pass> {
        int index;
        int dist;

        public Pass(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pass o) {
            return dist - o.dist;
        }

        @Override
        public String toString() {
            return index + "(" + dist + ")";
        }
    }

    static class Node {
        int to;
        int dist;

        public Node(int t, int d) {
            this.to = t;
            this.dist = d;
        }
    }
}
