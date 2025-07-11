package acmicpc2410;

import java.io.*;
import java.util.Arrays;

/* 2의 멱수의 합
 * https://www.acmicpc.net/problem/2410
 * dp 
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        // Arrays.fill(dp, 1);
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
            }
        }

        // System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);
    }
}
