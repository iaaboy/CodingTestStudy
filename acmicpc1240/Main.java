package acmicpc1240;

import java.io.*;
import java.util.*;

/* 노드사이의 거리
 * https://www.acmicpc.net/problem/1240
 */

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            dist[s][e] = w;
            dist[e][s] = w;
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (s == e) {
                        continue;
                    }
                    if (dist[s][e] == 0 && dist[s][m] != 0 && dist[m][e] != 0) {
                        dist[s][e] = dist[s][m] + dist[m][e];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dist[s][e]).append("\n");
        }
        System.out.print(sb);
        // for (int s = 0; s < N; s++) {
        //     for (int e = 0; e < N; e++) {
        //         System.out.print(dist[s][e] + " ");
        //     }
        //     System.out.println();
        // }
    }
}
