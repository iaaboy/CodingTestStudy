package acmicpc15992;

import java.io.*;
import java.util.*;
/* 1, 2, 3 더하기 7
 * https://www.acmicpc.net/problem/15992
 */

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[1001][1001];
        int MOD = 1000000009;
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        // dp[j][i] = dp[j - 1][i - 1] + dp[j - 2][i - 1] + dp[j - 3][i - 1]
        for (int i = 2; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                for (int k = 1; k < 4; k++) {
                    if (j - k > 0) {
                        dp[j][i] += dp[j - k][i - 1];
                        dp[j][i] %= MOD;
                    }
                }
            }
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(dp[N][M] + "\n");
        }
        System.out.print(sb);
    }
}
