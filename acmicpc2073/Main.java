package acmicpc2073;

import java.io.*;
import java.util.*;

/* 수도배관공사
 * https://www.acmicpc.net/problem/2073
 * dp 배낭문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][] dp = new int[P][D + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int length;
        int capacity;
        for (int y = 0; y < P; y++) {
            st = new StringTokenizer(bf.readLine());
            length = Integer.parseInt(st.nextToken());
            capacity = Integer.parseInt(st.nextToken());
            for (int x = 1; x <= D; x++) {
                if (y == 0)
                    continue;
                if (x >= length + 1) {
                    if (dp[y - 1][x - length] != -1) {
                        dp[y][x] = Math.min(dp[y - 1][x - length], capacity);
                    }
                }
                dp[y][x] = Math.max(dp[y][x], dp[y - 1][x]);
            }
            dp[y][length] = Math.max(capacity, dp[y][length]);
        }

        // for (int i = 0; i < P; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }

        int max = 0;
        for (int y = 0; y < P; y++) {
            max = Math.max(max, dp[y][D]);
        }
        System.out.println(max);
    }
}
