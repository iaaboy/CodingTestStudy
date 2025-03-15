package acmicpc3067;

import java.io.*;
import java.util.*;

/* coins , 동전
 * https://www.acmicpc.net/problem/9084
 * https://www.acmicpc.net/problem/3067
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] coin = new int[N + 1];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            // System.out.println(Arrays.toString(coin));

            int M = Integer.parseInt(bf.readLine());
            int[][] memo = new int[M + 1][N + 1]; // M , coin

            for (int i = 0; i <= N; i++) {
                memo[0][i] = 1;
            }

            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (coin[j] <= i) {
                        memo[i][j] = memo[i - coin[j]][j] + memo[i][j - 1];
                    } else {
                        memo[i][j] = memo[i][j - 1];
                    }
                }
            }

            // for (int j = 0; j <= N; j++) {
            //     for (int i = 0; i <= M; i++) {
            //         System.out.print(memo[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            sb.append(memo[M][N]).append("\n");
        }
        System.out.print(sb);
    }
}
