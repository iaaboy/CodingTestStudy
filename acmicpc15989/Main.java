package acmicpc15989;

import java.io.*;

/* 1, 2, 3 더하기 4
 * https://www.acmicpc.net/problem/15989
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[10000 + 1];
        dp[0] = 1;
        int[] nums = { 1, 2, 3 };
        for (int num : nums) {
            for (int i = num; i < dp.length; i++) {
                dp[i] += dp[i - num];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < N; t++) {
            int num = Integer.parseInt(bf.readLine());
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}
