package acmicpc17208;

import java.io.*;
import java.util.*;

/* 카우버거 알바생 
 * https://www.acmicpc.net/problem/17208
 * dp 배낭
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[N][M + 1][K + 1];
        int[] cheese = new int[N];
        int[] potato = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            cheese[i] = Integer.parseInt(st.nextToken());
            potato[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < N; k++) {
            for (int j = 0; j <= K; j++) {
                for (int i = 0; i <= M; i++) {
                    int c = i - cheese[k];
                    int p = j - potato[k];
                    if (c < 0 || p < 0) {
                        if (k > 0) {
                            dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i][j]);
                        }
                        continue;
                    }
                    if (k == 0) {
                        dp[k][i][j] = 1;
                    } else {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][c][p] + 1);
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i][j]);
                    }
                }
            }
            printData(k, M, K, dp);
        }

        System.out.println(dp[N - 1][M][K]);
    }

    private static void printData(int n, int M, int K, int[][][] dp) {
        // System.out.println("n:" + n);
        // for (int i = 0; i <= M; i++) {
        //     for (int j = 0; j <= K; j++) {
        //         System.out.print(dp[n][i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}
