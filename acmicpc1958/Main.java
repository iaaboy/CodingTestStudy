package acmicpc1958;

import java.io.*;
import java.util.*;

/* LCS 3
 * https://www.acmicpc.net/problem/1958
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bf.readLine().toCharArray();
        char[] b = bf.readLine().toCharArray();
        char[] c = bf.readLine().toCharArray();
        int[][][] dp = new int[a.length + 1][b.length + 1][c.length + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 1; k < dp[0][0].length; k++) {
                    if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        max = Math.max(max, dp[i][j][k]);
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}