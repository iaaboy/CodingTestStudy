package acmicpc11727;

import java.io.*;

/* 2×n 타일링 2
 * https://www.acmicpc.net/problem/11727
dp[3]의 경우,
dp[2] 왼쪽에 I 추가  III, I=,Iㅁ 
   >> dp[i-1] 그래도 가져옴
dp[1] 왼쪽에 = 추가  =I
dp[1] 왼쪽에 ㅁ추가  ㅁI
   >> dp[i-2]를 두번 가져옴

dp[i] = (dp[i - 1] + dp[i - 2] * 2)
*/

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N + 2];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[N]);
    }
}
