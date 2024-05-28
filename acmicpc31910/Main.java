package acmicpc31910;

import java.io.*;
import java.util.*;

/* 이진수 격자
 * https://www.acmicpc.net/problem/31910
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[][] arr = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = arr[0][0];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                long up = y == 0 ? arr[y][x] : dp[y - 1][x] * 2 + arr[y][x];
                long left = x == 0 ? arr[y][x] : dp[y][x - 1] * 2 + arr[y][x];
                dp[y][x] = Math.max(up, left);
            }
            // printDP(dp);
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
