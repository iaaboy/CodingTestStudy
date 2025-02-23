package acmicpc14002;

import java.io.*;
import java.util.*;

/* 가장 긴 증가하는 부분 수열 4
 * https://www.acmicpc.net/problem/14002
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 1;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        StringBuilder sb = new StringBuilder();
        int curMax = max;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == curMax) {
                sb.insert(0, arr[i] + " ");
                curMax--;
            }
        }
        sb.insert(0, max + "\n").append("\n");
        System.out.print(sb);
    }
}
