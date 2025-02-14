package acmicpc2156;

import java.io.*;

/* 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[3][N];
        dp[1][0] = dp[2][0] = Integer.parseInt(bf.readLine());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));

            dp[1][i] = dp[0][i - 1] + num;
            dp[2][i] = dp[1][i - 1] + num;
        }
        int maxNum = Math.max(Math.max(dp[2][N - 1], dp[1][N - 1]), dp[0][N - 1]);
        System.out.println(maxNum);
    }
}