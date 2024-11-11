package acmicpc11404;

import java.io.*;
import java.util.*;

/* 플로이드
 * https://www.acmicpc.net/problem/11404
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int INF = 100000 * 100 * 100;
        int[][] map = new int[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            if (map[start][end] == 0) {
                map[start][end] = cost;
            } else {
                map[start][end] = Math.min(map[start][end], cost);
                ;
            }
        }

        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // sb.append(map[i][j] + " ");
        // }
        // sb.append("\n");
        // }
        // sb.append("---\n");

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (m == s) {
                    continue;
                }
                for (int e = 0; e < N; e++) {
                    if (s == e) {
                        continue;
                    }
                    if (map[s][m] == 0 || map[m][e] == 0) {
                        continue;
                    }
                    if (map[s][e] == 0) {
                        map[s][e] = map[s][m] + map[m][e];
                    } else {
                        map[s][e] = Math.min(map[s][e], map[s][m] + map[m][e]);
                    }
                }
            }
        }

        // sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
