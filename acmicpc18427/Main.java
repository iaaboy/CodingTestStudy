package acmicpc18427;

import java.io.*;
import java.util.*;

/* 함께 블록 쌓기
 * https://www.acmicpc.net/problem/18427
 * dp 배낭문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int dp[][] = new int[N + 1][H + 1];
        // for (int i = 0; i < dp.length; i++) {
        // dp[i][0] = 1;
        // }
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> blocks = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                blocks.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j <= H; j++) {
                dp[i][j] += dp[i - 1][j];
                for (Integer b : blocks) {
                    if (j + b > H)
                        continue;
                    dp[i][j + b] += (dp[i - 1][j]) % 10007;
                }
            }

            // for (int j = 0; j < dp.length; j++) {
            // System.out.println(Arrays.toString(dp[j]));
            // }
        }
        System.out.println(dp[N][H] % 10007);
    }
}

/*
3 3 5
2 3 5
3 5
1 2
 */