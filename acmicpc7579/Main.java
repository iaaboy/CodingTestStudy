package acmicpc7579;

import java.io.*;
import java.util.*;

/* 앱
 * https://www.acmicpc.net/problem/7579
 * dp 배낭문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // app 개수
        int M = Integer.parseInt(st.nextToken()); // 최대 메모리
        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int maxC = 0;
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            maxC += c[i];
        }

        int[][] dp = new int[N + 1][maxC + 1];
        int minCost = Integer.MAX_VALUE;
        for (int app = 1; app <= N; app++) {
            for (int cost = 0; cost <= maxC; cost++) {
                dp[app][cost] = dp[app - 1][cost];
                if (cost >= c[app]) {
                    dp[app][cost] = Math.max(dp[app - 1][cost - c[app]] + m[app], dp[app][cost]);
                }
                if(dp[app][cost] >= M) {
                    minCost = Math.min(minCost, cost);
                }
            }
        }
        System.out.println(minCost);
        // printTable(N, maxC, dp);
    }

    private static void printTable(int N, int maxC, int[][] dp) {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= maxC; j++) {
                if (dp[i][j] == Integer.MAX_VALUE / 2) {
                    System.out.print("- ");
                } else
                    System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
5 12
7 2 3 4 5
3 0 4 2 3
 */