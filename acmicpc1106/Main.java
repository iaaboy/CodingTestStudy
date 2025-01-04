package acmicpc1106;

import java.io.*;
import java.util.*;

/* 호텔
 * https://www.acmicpc.net/problem/1106
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] pay = new int[N + 1];
        int[] customer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            pay[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C + 100; j++) {
                int idx = j - customer[i];
                if (idx >= 0 && dp[idx] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[idx] + pay[i]);
                } else {
                    // dp[j] = dp[j]; 없는 경우와 같으므로, 이전 값을 그대로 취함.
                }
            }
            // System.out.println(i + ": " + pay[i] + "," + customer[i] + ":" + Arrays.toString(dp));
        }
        int answer = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            answer = Math.min(dp[i], answer);
        }
        System.out.println(answer);
    }
}
