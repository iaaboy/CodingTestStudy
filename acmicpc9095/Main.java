package acmicpc9095;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            sb.append(dp[N] + "\n");
        }
        System.out.println(sb.toString());
    }
}
