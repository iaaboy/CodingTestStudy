package acmicpc2294;

import java.io.*;
import java.util.*;

/* 동전 2
 * https://www.acmicpc.net/problem/2294
snapsack dp
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }
        int[][] dp = new int[K + 1][N]; // N coin , K 합 , 값 최소 동전
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= K; i++) {
            if (i % coin[0] == 0) {
                dp[i][0] = i / coin[0];
            }
        }

        // for (int n = 0; n < N; n++) {
        //     for (int k = 0; k <= K; k++) {
        //         if (dp[k][n] == Integer.MAX_VALUE) {
        //             System.out.print("-- ");
        //         } else
        //             System.out.print(dp[k][n] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j < N; j++) {
                int upper = dp[i][j - 1];
                int div = INF;
                if (i % coin[j] == 0) {
                    div = i / coin[j];
                }
                int upperLeft = INF;
                if(i >= coin[j] && dp[i - coin[j]][j - 1] != INF) {
                    upperLeft = dp[i - coin[j]][j - 1] + 1;
                }
                int left = INF;
                if(i >= coin[j] && dp[i - coin[j]][j] != INF) {
                    left = dp[i - coin[j]][j] + 1;
                }

                dp[i][j] = Math.min(Math.min(left, upper), Math.min(div, upperLeft));
            }
        }

        for (int n = 0; n < N; n++) {
            for (int k = 0; k <= K; k++) {
                if (dp[k][n] == Integer.MAX_VALUE) {
                    System.out.print("- ");
                } else
                    System.out.print(dp[k][n] + " ");
            }
            System.out.println();
        }
        if (dp[K][N-1] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K][N - 1]);
        }
    }
}

/*
8 17
13
1
10
11
1
8
14
12
 */