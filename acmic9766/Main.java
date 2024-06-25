package acmic9766;

import java.io.*;

/* 서로 다른 자연수의 합
 *   - 몰라서 인터넷 찾아봄.
 * https://www.acmicpc.net/problem/9764
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int[][] dp = new int[2001][2001];
        int[][] sum = new int[2001][2001];
        for (int i = 1; i <= 2000; i++) {
            for (int j = 1; j < i; j++) {

                dp[i][j] = sum[i - j][j - 1];
                sum[i][j] = (dp[i][j] + sum[i][j - 1]) % 100999;
            }
            dp[i][i] = 1;
            sum[i][i] = (sum[i][i - 1] + 1) % 100999;
            for (int j = i + 1; j <= 2000; j++) {
                sum[i][j] = sum[i][j - 1];
            }
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();
        for (int l = 0; l < T; l++) {
            int N = Integer.parseInt(bf.readLine());
            sb.append(sum[N][N] + "\n");
        }

        System.out.println(sb);
    }
}
