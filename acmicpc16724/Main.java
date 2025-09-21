package acmicpc16724;

import java.io.*;
import java.util.*;

/* 피리 부는 사나이
 * https://www.acmicpc.net/problem/16724
 */

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        int index = 1;
        int metNumber = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j] == 0) {
                    metNumber = travel(i, j, index);
                    if (metNumber != index) {
                        setDp(i, j, metNumber, index);
                    } else {
                        index++;
                    }
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(index - 1);
    }

    private static void setDp(int y, int x, int index, int prevNumber) {
        while (true) {
            if (dp[y][x] != prevNumber) {
                return;// met me.
            }
            dp[y][x] = index;
            int d = map[y][x] == 'U' ? 0 : map[y][x] == 'D' ? 1 : map[y][x] == 'L' ? 2 : 3;
            y += dy[d];
            x += dx[d];
        }
    }

    // up down left right
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    private static int travel(int y, int x, int index) {
        while (true) {
            if (dp[y][x] > 0) {
                return dp[y][x];// met me or join to other
            }
            dp[y][x] = index;
            int d = map[y][x] == 'U' ? 0 : map[y][x] == 'D' ? 1 : map[y][x] == 'L' ? 2 : 3;
            y += dy[d];
            x += dx[d];
        }
    }
}
