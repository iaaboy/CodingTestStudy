package acmicpc5582;

import java.io.*;
import java.util.*;

/* 공통 부분 문자열
 * https://www.acmicpc.net/problem/5582
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bf.readLine().toCharArray();
        char[] b = bf.readLine().toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}