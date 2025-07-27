package acmicpc15817;

import java.io.*;
import java.util.*;

/* 배수 공사
 * https://www.acmicpc.net/problem/15817
 * dp 배낭문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][X + 1];
        for (int i = 0; i <= X; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int length = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int countLeft = count;
            int next = length;
            while (countLeft-- > 0) {
                if (next > X)
                    break;
                dp[i][next] += 1;
                next += length;
            }
            if (i != 1) {
                for (int j = 1; j <= X; j++) {
                    if (dp[i - 1][j] != 0) {
                        countLeft = count;
                        next = j + length;
                        while (countLeft-- > 0) {
                            if (next > X)
                                break;
                            dp[i][next] += dp[i - 1][j];
                            next += length;
                        }
                    }
                    dp[i][j] += dp[i-1][j];
                }
                
            }
        }
        System.out.println(dp[N][X]);
        // for (int i = 0; i < dp.length; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }
    }
}
/*
5 30
4 3
6 3
9 2
7 9
3 7
 */