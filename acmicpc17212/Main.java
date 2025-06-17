package acmicpc17212;

import java.io.*;
import java.util.*;

/* 달나라 토끼를 위한 구매대금 지불 도우미
 * https://www.acmicpc.net/problem/17212
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] coins = {1,2,5,7};
        int [] dp = new int[N + 7 + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i <= N; i++) {
            for (int c : coins) {
                int prev = i - c;
                if(prev >= 0)
                    dp[i] = Math.min(dp[i] , dp[prev] + 1);
            }
        }
        System.out.println(dp[N]);
        // System.out.println(Arrays.toString(dp));
    }
}
