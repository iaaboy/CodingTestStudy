package acmicpc13905;

import java.io.*;
import java.util.*;

/* 세부
 * https://www.acmicpc.net/problem/13905
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ids = new int[N + 1];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        Bridge[] nodes = new Bridge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[i] = new Bridge(from, to, cost);
        }
        Arrays.sort(nodes, (a, b) -> b.cost - a.cost);
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            // from 과 to 를 union
            int from = nodes[i].from;
            int to = nodes[i].to;
            setUnion(from, to);
            cost = Math.min(cost, nodes[i].cost);

            // check s와 e가 연결되었는지...
            if (getUnion(s) == getUnion(e)) {
                System.out.println(cost);
                return;
            }
        }
        System.out.println("0");
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

    static class Bridge {
        int from;
        int to;
        int cost;

        public Bridge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return from + "," + to + "(" + cost + ")";
        }
    }
}
