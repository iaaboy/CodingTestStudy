package acmicpc30460;

import java.io.*;
import java.util.*;

/* 스위치
 * https://www.acmicpc.net/problem/30460 
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        final int ON1 = 0;
        final int ON2 = 1;
        final int ON3 = 2;
        final int OFF = 3;
        int[][] dp = new int[N][4];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -30);
        }
        dp[0][ON1] = 2 * arr[0];
        dp[0][OFF] = arr[0];
        for (int i = 1; i < N; i++) {
            int temp = (i < 3)? dp[i - 1][OFF] : Math.max(dp[i - 1][ON3], dp[i - 1][OFF]);
            dp[i][ON1] = temp + 2 * arr[i];
            dp[i][ON2] = dp[i - 1][ON1] + 2 * arr[i];
            if(i >= 2) {
                dp[i][ON3] = dp[i - 1][ON2] + 2 * arr[i];
            }
            dp[i][OFF] = temp + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            // for (int j = 0; j < N; j++) {
            //     System.out.print(dp[j][i] + " ");
            // }
            // System.out.println();
            max = Math.max(dp[N - 1][i], max);
        }
        System.out.println(max);
    }
}
