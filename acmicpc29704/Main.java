package acmicpc29704;

import java.io.*;
import java.util.*;

/* 벼락치기
 * https://www.acmicpc.net/problem/29704
 * dp snapsack
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());  // 문제 개수
        int T = Integer.parseInt(st.nextToken());  // 총 시간 제한

        int[] time = new int[N];
        int[] charge = new int[N];

        int totalScore = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            charge[i] = Integer.parseInt(st.nextToken());
            totalScore += charge[i];
        }

        int[][] dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int t = 0; t <= T; t++) {
                if (t < time[i - 1]) {
                    dp[i][t] = dp[i - 1][t]; // 시간 부족해서 못 풂
                } else {
                    dp[i][t] = Math.max(dp[i - 1][t], dp[i - 1][t - time[i - 1]] + charge[i - 1]);
                }
            }
        }

        System.out.println(totalScore - dp[N][T]);  // 최소 charge
    }
}