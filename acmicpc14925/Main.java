package acmicpc14925;

import java.io.*;
import java.util.*;

/* 목장 건설하기
 * https://www.acmicpc.net/problem/14925
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[M][N];
        int[][] up = new int[M][N];
        int[][] left = new int[M][N];
        int maxSquare = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    up[i][j] = i != 0 ? up[i - 1][j] + 1 : 1;
                    left[i][j] = j != 0 ? left[i][j - 1] + 1 : 1;
                    dp[i][j] = Math.min((i != 0 && j != 0) ? dp[i - 1][j - 1] + 1 : 1, Math.min(up[i][j], left[i][j]));
                    maxSquare = Math.max(dp[i][j], maxSquare);
                }
            }
        }
        System.out.println(maxSquare);
        // for (int i = 0; i < M; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.print(dp[i][j]);
        // }
        // System.out.println("");
        // }
    }
}