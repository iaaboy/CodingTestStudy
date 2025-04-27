package acmicpc25343;

import java.io.*;
import java.util.*;

/* 최장 최장 증가 부분 수열
 * https://www.acmicpc.net/problem/25343
 * LIS를 dp로. 이 때 2차원 배열을 기준으로 푼다.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 1;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이전까지 다시 방문
                for (int y = 0; y <= i; y++) {
                    for (int x = 0; x <= j; x++) {
                        if (arr[i][j] > arr[y][x] && dp[i][j] < dp[y][x] + 1) {
                            dp[i][j] = dp[y][x] + 1;
                            if (max < dp[i][j]) {
                                max = dp[i][j];
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(max);
    }
}
