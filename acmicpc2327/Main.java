package acmicpc2327;

import java.io.*;
import java.util.*;

/* 말아톤
 * https://www.acmicpc.net/problem/2327
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] member = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            member[i][0] = Integer.parseInt(st.nextToken()); // height
            member[i][1] = Integer.parseInt(st.nextToken()); // speed
        }

        int[][] dp = new int[N + 1][H + 1]; // index : height , value : speed
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= H; j++) {
                int index = member[i][0];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j + index > H) {
                    continue;
                }
                if (dp[i - 1][j] != 0 && dp[i][j + index] < Math.min(dp[i - 1][j], member[i][1])) {
                    dp[i][j + index] = Math.min(dp[i - 1][j], member[i][1]);
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(dp[N][H]);
    }
}
