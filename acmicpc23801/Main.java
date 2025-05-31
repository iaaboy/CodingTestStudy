package acmicpc23801;

import java.io.*;
import java.util.*;

/* 두 단계 최단 경로 2
 * https://www.acmicpc.net/problem/23801
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
            v[end].add(new Node(start, dist));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long [] fromStart = getDistance(start);
        long [] fromEnd = getDistance(end);

        int P = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        long minDistance = Long.MAX_VALUE;
        // StringBuilder sb = new StringBuilder();
        for (int i = 0; i < P; i++) {
            int stopBy = Integer.parseInt(st.nextToken());
            long d1 = fromStart[stopBy];
            long d2 = fromEnd[stopBy];
            if (d1 != Long.MAX_VALUE && d2 != Long.MAX_VALUE) {
                minDistance = Math.min(minDistance, d1 + d2);
            }
        }
        if (minDistance == Long.MAX_VALUE) {
            minDistance = -1;
        }
        System.out.println(minDistance);
        // System.out.println(getDistance(start, end));
        // System.out.print(sb);
    }

    static long [] getDistance(int X) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pass> pq = new PriorityQueue<>();
        pq.offer(new Pass(X, 0));

        while (!pq.isEmpty()) {
            Pass cur = pq.poll();
            // System.out.println(c);

            if (dist[cur.index] < cur.dist) {
                continue;
            }

            for (Node next : v[cur.index]) {
                long nextVal = cur.dist + next.dist;
                if (nextVal < dist[next.to]) {
                    pq.offer(new Pass(next.to, nextVal));
                    dist[next.to] = nextVal;
                }
            }
        }
        return dist;
    }

    static class Pass implements Comparable<Pass> {
        int index;
        long dist;

        public Pass(int index, long dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pass o) {
            if (dist >= o.dist) {
                return 1;
            } else {
                return -1;
            }
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
