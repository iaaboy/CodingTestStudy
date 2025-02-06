package acmicpc13549;

import java.io.*;
import java.util.*;

/* 숨바꼭질 3
 * https://www.acmicpc.net/problem/13549
 */

public class Main {
    static int INF = 100000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // if (N == K) {
        //     System.out.println(0);
        //     // return;
        // }

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(N, 0));
        int result = Integer.MAX_VALUE;
        int [] visited = new int[INF];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        while (!pq.isEmpty()) {
            Location c = pq.poll();
            // System.out.println(c.n + " , " + c.tick);
            if (c.n == K) {
                result = Math.min(result, c.tick); 
                continue;
            }
            if (c.n * 2 == K) {
                result = Math.min(result, c.tick);
            } else {
                // n * 2
                if (c.n * 2 < INF && visited[c.n * 2] > c.tick) {
                    visited[c.n * 2] = c.tick;
                    pq.add(new Location(c.n * 2, c.tick));
                }
            }
            if (c.n + 1 == K) {
                result = Math.min(result, c.tick + 1);
            } else {
                if (c.n + 1 < INF && visited[c.n + 1] > c.tick + 1) {
                    visited[c.n + 1] = c.tick + 1;
                    pq.add(new Location(c.n + 1, c.tick + 1));
                }
            }
            if (c.n - 1 == K) {
                result = Math.min(result, c.tick + 1);
            } else {
                // n + 1
                if (c.n - 1 < INF && c.n - 1 >= 0 && visited[c.n - 1] > c.tick + 1) {
                    visited[c.n - 1] = c.tick + 1;
                    pq.add(new Location(c.n - 1, c.tick + 1));
                }
            }
        }
        System.out.println(result);
    }

    static class Location implements Comparable<Location> {
        public Location(int n, int tick) {
            this.n = n;
            this.tick = tick;
        }

        int n;
        int tick;

        @Override
        public int compareTo(Location o) {
            return tick - o.tick;
        }
    }
}
