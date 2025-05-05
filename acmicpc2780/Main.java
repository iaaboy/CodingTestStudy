package acmicpc2780;

import java.io.*;
import java.util.*;

/* 비밀번호
 * https://www.acmicpc.net/problem/2780
 * dp 이웃한 숫자의 경우의 수들을 더해나가는 dp.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int MOD = 1234567;
        int MAX = 1000;

        long[][] dp = new long[MAX + 1][10];
        int[][] neighbor = { { 7 }, { 2, 4 }, { 1, 3, 5 }, { 2, 6 }, { 1, 5, 7 },
                { 2, 4, 6, 8 }, { 3, 5, 9 }, { 0, 4, 8 }, { 7, 5, 9 }, { 8, 6 } };
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= MAX; i++) {
            for (int j = 0; j < neighbor.length; j++) {
                for (int n : neighbor[j]) {
                    dp[i][j] += dp[i - 1][n] % MOD;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += (dp[num][j]);
                sum %= MOD;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
