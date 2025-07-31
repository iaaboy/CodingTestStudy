package acmicpc16132;

import java.io.*;
import java.util.Arrays;

/* 그룹 나누기 (Subset)
 * https://www.acmicpc.net/problem/16132
 * dp, 배낭문제
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int sum = (N % 2 == 0) ? (N + 1) * (N / 2) : (((N + 2) * (N / 2)) + 1);
        sum/=2;
        // System.out.println(sum);
        long[][] dp = new long[N + 1][sum + 1];

        for (int i = 0; i <= N; i++) {
            // dp[i][0] = 1;
        }
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                    dp[i][j] += dp [i-1][j];
                    if (j + i > sum)
                        continue;
                    dp[i][j + i] += dp[i - 1][j];

            }
        }
        for (int i = 0; i <=N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[N][sum] / 2);
    }
}
