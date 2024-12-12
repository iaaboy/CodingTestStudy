package acmicpc13703;

import java.io.*;
import java.util.*;

/* 물벼룩의 생존확률
 * https://www.acmicpc.net/problem/13703
 */

public class Main {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        dp = new long[63 * 2 + 1][63 + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        long count = move(K, N);
        System.out.println(count);
    }

    private static long move(int k, int n) {
        if (dp[k][n] != -1) {
            return dp[k][n];
        }
        if (k == 0) {
            dp[k][n] = 0;
            return 0;
        }
        if (k > n) {
            long leftCount = (long) Math.pow(2, n);
            dp[k][n] = leftCount;
            return leftCount;
        }
        long c = move(k + 1, n - 1);
        c += move(k - 1, n - 1);
        dp[k][n] = c;
        return c;
    }
}
