package acmicpc11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        System.out.println(binomial(n, k));
        br.close();
    }
    static int[][] dp;
    static int binomial(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }
        return dp[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}