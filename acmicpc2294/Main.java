package acmicpc2294;

import java.io.*;
import java.util.*;

/* 동전, 동전 1
 * https://www.acmicpc.net/problem/2293
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(bf.readLine());
        }

        int[][] memo = new int[K + 1][N + 1]; // M , coin

        for (int i = 0; i <= N; i++) {
            memo[0][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (coin[j] <= i) {
                    memo[i][j] = memo[i - coin[j]][j] + memo[i][j - 1];
                } else {
                    memo[i][j] = memo[i][j - 1];
                }
            }
        }

        // for (int j = 0; j <= N; j++) {
        //     for (int i = 0; i <= K; i++) {
        //         System.out.print(memo[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        sb.append(memo[K][N]).append("\n");
        System.out.print(sb);
    }
}
