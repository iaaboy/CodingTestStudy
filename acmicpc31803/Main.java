package acmicpc31803;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[31][31];

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if (i < j)
                    continue;
                else if (i == j || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n][n/2]);
    }
}