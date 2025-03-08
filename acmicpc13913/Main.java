package acmicpc13913;

import java.io.*;
import java.util.*;

/* 숨바꼭질 4
 * https://www.acmicpc.net/problem/13913
숨바꼭질 3풀이에서
최소인 경로가 갱신될때, 내 위치의 이전 위치를 저장한다.
답이 나온경우 도착(K)위치부터 거꾸로 경로를 stack에 저장.
스택에서 pop해서 출력하면 시작 -> 도착 경로임.
 */

public class Main {
    static int INF = 100000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.add(new Location(N, 0));
        int result = Integer.MAX_VALUE;
        int[] visited = new int[INF];
        int[] prev = new int[INF];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        while (!pq.isEmpty()) {
            Location c = pq.poll();
            // System.out.println(c.n + " , " + c.tick);
            if (c.n == K) {
                
                if (result > c.tick) {
                    prev[c.n] = c.n;
                    result = c.tick;
                }
                // result = Math.min(result, c.tick);
                continue;
            }
            if (c.n * 2 == K) {
                // result = Math.min(result, c.tick + 1);
                if(result > c.tick + 1) {
                    prev[c.n * 2] = c.n;
                    result = c.tick + 1;
                }
            } else {
                // n * 2
                if (c.n * 2 < INF && visited[c.n * 2] > c.tick) {
                    visited[c.n * 2] = c.tick;
                    prev[c.n * 2] = c.n;
                    pq.add(new Location(c.n * 2, c.tick + 1));
                }
            }
            if (c.n + 1 == K) {
                if(result > c.tick + 1) {
                    prev[c.n + 1] = c.n;
                    // result = Math.min(result, c.tick + 1);
                    result = c.tick + 1;
                }
            } else {
                if (c.n + 1 < INF && visited[c.n + 1] > c.tick + 1) {
                    visited[c.n + 1] = c.tick + 1;
                    prev[c.n + 1] = c.n;
                    pq.add(new Location(c.n + 1, c.tick + 1));
                }
            }
            if (c.n - 1 == K) {
                if(result > c.tick + 1) {
                    prev[c.n - 1] = c.n;
                    result = c.tick + 1;
                }
                // result = Math.min(result, c.tick + 1);
            } else {
                // n + 1
                if (c.n - 1 < INF && c.n - 1 >= 0 && visited[c.n - 1] > c.tick + 1) {
                    visited[c.n - 1] = c.tick + 1;
                    prev[c.n - 1] = c.n;
                    pq.add(new Location(c.n - 1, c.tick + 1));
                }
            }
        }
        // System.out.println(result);
        Stack<Integer> stack = new Stack<>();
        // stack.add(K);
        int cur = K;
        while (cur != N) {
            // System.out.print(cur + " ");
            stack.add(cur);
            cur = prev[cur];
        }
        stack.add(cur);
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
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
