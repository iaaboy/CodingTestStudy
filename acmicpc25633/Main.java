package acmicpc25633;

import java.io.*;
import java.util.*;

/* 도미노 넘어뜨리기 풀이
 * https://www.acmicpc.net/problem/25633
 */

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i개 쓰러뜨릴 경우 도미노합 최대값.
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = i; j > 0; j--) {
                if (dp[j - 1] == 0)
                    continue;
                if (dp[j - 1] >= arr[i]) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + arr[i]);
                }
            }
            dp[1] = Math.max(dp[1], arr[i]);
        }

        // System.out.println(Arrays.toString(dp));

        for (int i = N; i > 0; i--) {
            if (dp[i] != 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
