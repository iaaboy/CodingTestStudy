package acmicpc27361;

import java.io.*;
import java.util.*;

/* 막대 자르기
 * https://www.acmicpc.net/problem/27361
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            int [] arr = new int[N];
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            // Arrays.sort(arr);
            long [] pay = new long[N];
            for (int j = 0; j < pay.length; j++) {
                if (arr[j] <= 1) {
                    pay[j] = 0;
                } else {
                    pay[j] = a * (long) Math.pow(arr[j] - 1, 2) + b;
                }
            }
            long[] dp = new long[K + 1];
            for (int j = 1; j < dp.length; j++) {
                dp[j] = Long.MAX_VALUE;
            }
            int totalStic = 0;
            for (int j = 0; j < arr.length; j++) {
                totalStic += arr[j];
                int indexMax = Math.min(totalStic, K);
                for (int k = indexMax; k >= 0; k--) {
                    int index = Math.max(0, k - arr[j]);
                    dp[k] = Math.min(dp[k], dp[index] + pay[j]);
                }
            }
            // System.out.println(Arrays.toString(arr));
            // System.out.println(Arrays.toString(pay));
            // System.out.println(Arrays.toString(dp));
            sb.append(dp[K]).append("\n");
            // System.out.println(dp[K]);
        }
        System.out.print(sb);
    }
}
