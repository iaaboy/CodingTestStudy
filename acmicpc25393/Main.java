package acmicpc25393;

import java.io.*;
import java.util.*;

/*
 * 풀이중.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Line[] l = new Line[N];
        ArrayList<Edge> edges = new ArrayList<>(N * 2);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            l[i] = new Line(s, e);
            edges.add(new Edge(s, i, true));
            edges.add(new Edge(e, i, false));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (!edge.isStart) {
                sb.append(edge.time).append(" ");
            }
            for (int j = i - 1; j >= 0; j++) {
                
            }
        }

        int Q = Integer.parseInt(bf.readLine());
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    static class Line {
        int s, e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static class Edge implements Comparable<Edge> {
        int time;
        int index;
        boolean isStart;

        public Edge(int time, int index, boolean isStart) {
            this.time = time;
            this.index = index;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Edge o) {
            if (time == o.time) {
                if (isStart) {
                    return -1;
                }
            }
            return time - o.time;
        }

        @Override
        public String toString() {
            return time + " " + isStart;
        }
    }
}
