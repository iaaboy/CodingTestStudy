package acmicpc1010;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
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

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n] + "\n");
        }
        System.out.println(sb.toString());
    }
}