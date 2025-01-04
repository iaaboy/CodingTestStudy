package acmicpc22115;

import java.io.*;
import java.util.*;

/* 창영이와 커피
 * https://www.acmicpc.net/problem/22115
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());// 필요한 caffeine
        int[] caffeine = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            caffeine[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int maxCaffeine = 0;
        for (int i = 1; i <= N; i++) {
            maxCaffeine += caffeine[i];
            maxCaffeine = Math.min(maxCaffeine, K);
            for (int j = maxCaffeine; j >= 1; j--) {
                int prevIndex = j - caffeine[i];
                if (prevIndex < 0) {
                    // dp[j] = dp[j]; 이전값 그대로
                } else {
                    if (dp[prevIndex] != Integer.MAX_VALUE)
                        dp[j] = Math.min(dp[prevIndex] + 1, dp[j]);
                }
            }
            // System.out.println(i + ", " + maxCaffeine + ":" + Arrays.toString(dp));
        }

        if (dp[K] == Integer.MAX_VALUE) {
            dp[K] = -1;
        }
        System.out.println(dp[K]);
    }
}
