package acmicpc1915;

import java.io.*;
import java.util.*;

/* 가장 큰 정사각형
 * https://www.acmicpc.net/problem/1915
 * dp...
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
            
        }
        int max = 0;
        boolean hasItem = false;
        loop:
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (map[i][k] == '1') {
                    hasItem = true;
                    break loop;
                }
            }
        }
        int[][] dp = new int[N][M];
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (map[i - 1][j] == '1' && map[i][j - 1] == '1' && map[i - 1][j-1] == '1' && map[i][j] == '1' ) {
                    dp[i][j] = 1;   
                }
            }
        }

        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (dp[i][j] == 1) {
                    int minPre = Math.min(dp[i-1][j-1],Math.min(dp[i - 1][j], dp[i][j - 1]));
                    if(minPre > 0) {
                        dp[i][j] += minPre;   
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        max = max == 0 ? hasItem ? 1 : 0  : (max + 1) * (max + 1);
        System.out.println(max);
    }
}

/*
5 5
11110
11110
11110
11110
11110

5 1
0
0
1
0
0

 */