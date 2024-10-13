package acmicpc16958;

import java.io.*;
import java.util.*;

/* 텔레포트
 * https://www.acmicpc.net/problem/16958
 */

public class Main {
    static boolean[] sp;
    static int[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        sp = new boolean[N];
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            sp[i] = Integer.parseInt(st.nextToken()) == 1;
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int[][] distance = new int[N][N];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], 100000000);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (sp[i] && sp[j]) {
                    distance[i][j] = Math.min(T, Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]));
                } else {
                    distance[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                }
            }
        }

        // for (int i = 0; i < distance.length; i++) {
        // System.out.println(Arrays.toString(distance[i]));
        // }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (s == e)
                        continue;
                    distance[s][e] = Math.min(distance[s][e], distance[s][m] + distance[m][e]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            sb.append(distance[from][to] + "\n");
        }
        System.out.print(sb);

        // for (int i = 0; i < distance.length; i++) {
        // System.out.println(Arrays.toString(distance[i]));
        // }
    }

    static int manhattan(int a, int b) {
        return Math.abs(x[a] - x[b]) + Math.abs(y[a] - y[b]);
    }
}
