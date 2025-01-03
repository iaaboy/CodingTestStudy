package acmicpc16493;

import java.io.*;
import java.util.*;

/* 최대 페이지 수
 * https://www.acmicpc.net/problem/16493
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[M + 1];
        int[] page = new int[M + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < M; ++i) {
            int firstDay = day[i];
            for (int j = N; j >= firstDay; --j) {
                dp[j] = Math.max(dp[j - firstDay] + page[i], dp[j]);
            }
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
