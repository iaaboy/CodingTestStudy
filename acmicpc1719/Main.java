package acmicpc1719;

import java.io.*;
import java.util.*;

/* 택배
 * https://www.acmicpc.net/problem/1719
 * 플로이드–워셜
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        final int INF = Integer.MAX_VALUE / 2;
        int[][] distance = new int[n + 1][n + 1];
        int[][] route = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], INF);
            for (int j = 0; j <= n; j++) {
                route[i][j] = i;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            distance[start][end] = Math.min(d, distance[start][end]);
            distance[end][start] = Math.min(d, distance[end][start]);
            route[start][end] = end;
            route[end][start] = start;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (distance[s][e] > distance[s][mid] + distance[mid][e]) {
                        distance[s][e] = distance[s][mid] + distance[mid][e];
                        route[s][e] = route[s][mid];
                        route[e][s] = route[e][mid];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("-");
                } else {
                    sb.append(route[i][j]);
                }
                if (j!=n) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
