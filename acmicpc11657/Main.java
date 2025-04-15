package acmicpc11657;

import java.io.*;
import java.util.*;

/* 타임머신
 * https://www.acmicpc.net/problem/11657
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());// 도시
        int M = Integer.parseInt(st.nextToken());// 노선

        Route[] nodes = new Route[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            nodes[i] = new Route(Integer.parseInt(st.nextToken()) -1, Integer.parseInt(st.nextToken()) -1,
                    Integer.parseInt(st.nextToken()));
        }

        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Route r = nodes[j];
                if (distance[r.start] != Long.MAX_VALUE &&
                        distance[r.end] > distance[r.start] + r.cost) {
                    distance[r.end] = distance[r.start] + r.cost;
                }
            }
        }

        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Route r = nodes[i];
            if (distance[r.start] != Long.MAX_VALUE
                    && distance[r.end] > distance[r.start] + r.cost) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for (int i = 1; i < N; i++) {
                if (distance[i] == Long.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }

    }

    static class Route {
        int start;
        int end;
        int cost;

        public Route(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}