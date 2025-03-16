package acmicpc1904;

import java.io.*;

/* 01타일
 * https://www.acmicpc.net/problem/1904

 dp[i]
  - dp[i-2] 왼쪽에 00을 붙인다.
  - dp[i-1] 왼쪽에 1을 붙인다.
 >> dp[i] = dp[i-2] + dp[i-1]
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        System.out.println(dp[N]);
    }
}
