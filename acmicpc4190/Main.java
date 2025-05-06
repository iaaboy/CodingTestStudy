package acmicpc4190;

import java.io.*;
import java.util.*;

/* Exact Change
 * https://www.acmicpc.net/problem/4190
 * basic snapsack
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bf.readLine());
        final int MAX = 100000;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int D = Integer.parseInt(bf.readLine());
            int N = Integer.parseInt(bf.readLine());
            int[] coin = new int[N];
            
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(bf.readLine());
            }
            
            int[] dp = new int[MAX + 1];
            Arrays.fill(dp, 0);
            
            for (int i = 0; i < N; i++) {
                for (int j = MAX - coin[i]; j >= 0; j--) {
                    if (dp[j] != 0 || j == 0) {
                        if (dp[j + coin[i]] != 0) {
                            dp[j + coin[i]] = Math.min(dp[j + coin[i]], dp[j] + 1);
                        } else {
                            dp[j + coin[i]] = dp[j] + 1;
                        }
                    }
                }
                
                if (dp[coin[i]] == 0) {
                    dp[coin[i]] = 1;
                }
            }

            for (int i = D; i <= MAX; i++) {
                if (dp[i] != 0) {
                    sb.append(i + " " + dp[i] + "\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
