package acmicpc2240;

import java.io.*;
import java.util.*;

/* 자두나무
 * https://www.acmicpc.net/problem/2240
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + 1];
        int[][][] dp = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[2][i - 1][j - 1], dp[1][i - 1][j]);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1] + 1, dp[2][i - 1][j] + 1);
                }
            }
        }

        int maxPlums = 0;
        for (int pos = 1; pos <= 2; pos++) {
            for (int cnt = 0; cnt <= W + 1; cnt++) {
                maxPlums = Math.max(maxPlums, dp[pos][T][cnt]);
            }
        }

        System.out.println(maxPlums);
    }
}
