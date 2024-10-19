package acmicpc2011;

import java.io.*;

/* 암호코드
 * https://www.acmicpc.net/problem/2011
 */

public class Main {
    static int[] num;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = bf.readLine().toCharArray();

        if (ch[0] == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[ch.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= ch.length; i++) {
            if (ch[i - 1] != '0') {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            int num = ((ch[i - 2] - '0') * 10) + ch[i - 1] - '0';
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[ch.length]);
    }
}
