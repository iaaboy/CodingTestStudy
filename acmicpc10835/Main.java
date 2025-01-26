package acmicpc10835;

import java.io.*;
import java.util.*;

/* 카드게임
 * https://www.acmicpc.net/problem/10835
 */

public class Main {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        int[] s1 = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            s1[i] = Integer.parseInt(st.nextToken());
        }
        int[] s2 = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            s2[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = checkStack(s1, s2, 0, 0);
        System.out.println(result);
    }

    private static int checkStack(int[] s1, int[] s2, int i1, int i2) {
        // System.out.println(i1 + ", " + i2 + ", k: " + k);
        if (i1 == N || i2 == N) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        int result = Math.max(checkStack(s1, s2, i1 + 1, i2), checkStack(s1, s2, i1 + 1, i2 + 1)); // throw left, throw both
        if (s1[i1] > s2[i2]) {
            int throwRight = checkStack(s1, s2, i1, i2 + 1) + s2[i2];
            result = Math.max(result, throwRight);
        }
        dp[i1][i2] = result;
        return result;
    }
}
