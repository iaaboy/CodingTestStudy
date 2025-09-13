package acmicpc14217;

import java.io.*;
import java.util.*;

/* 그래프 탐색
 * https://www.acmicpc.net/problem/14217
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        City[] cities = new City[N];
        for (int i = 0; i < N; i++) {
            cities[i] = new City();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            cities[s].neighbor.add(e);
            cities[e].neighbor.add(s);
        }
        int Q = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            Integer s = Integer.parseInt(st.nextToken()) - 1;
            Integer e = Integer.parseInt(st.nextToken()) - 1;
            if (cmd == 1) {
                cities[s].neighbor.add(e);
                cities[e].neighbor.add(s);
            } else {
                cities[s].neighbor.remove(e);
                cities[e].neighbor.remove(s);
            }
            int[] dist = new int[N];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new ArrayDeque<>();
            dist[0] = 0;
            q.add(0);
            while (!q.isEmpty()) {
                int c = q.poll();
                for (Integer next : cities[c].neighbor) {
                    if (dist[next] == -1 || dist[next] > dist[c] + 1) {
                        dist[next] = dist[c] + 1;
                        q.add(next);
                    }
                }
            }
            sb.append(Arrays.toString(dist).replaceAll("[\\[\\],]", "")).append("\n");
        }
        System.out.print(sb);
    }

    static class City {
        ArrayList<Integer> neighbor = new ArrayList<>();
    }
}
