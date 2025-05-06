package acmicpc4781;

import java.io.*;
import java.util.*;

/* 사탕 가게
 * https://www.acmicpc.net/problem/4781
 * 전형적인 배낭문제. 
 * 부동소수점 이해 필요.
 * 오차 없이 하려면 :  Double.parseDouble(st.nextToken()) * 100 + 0.5f
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5f);
        StringBuilder sb = new StringBuilder();
        while (N != 0 && M != 0) {
            long[] cal = new long[N];
            int[] price = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                cal[i] = Long.parseLong(st.nextToken());
                price[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5f);
            }
            long[] dp = new long[M + 1];
            for (int i = 1; i <= M; i++) {
                for (int item = 0; item < N; item++) {
                    if (i - price[item] >= 0) {
                        dp[i] = Math.max(dp[i], dp[i - price[item]] + cal[item]);
                    }
                }
            }
            sb.append(dp[M]).append("\n");
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5f);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.print(sb);
    }
}
