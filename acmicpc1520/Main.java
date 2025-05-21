package acmicpc1520;

import java.io.*;
import java.util.*;

/* 내리막 길
 * https://www.acmicpc.net/problem/1520
 * 4방향에서 오는 경우에 수를 더하는 dp
 */

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 1;
        int count = getCount(N - 1, M - 1);
        System.out.println(count);
    }

    private static int getCount(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        int sum = 0;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }
            if (map[ny][nx] > map[y][x]) {
                sum += getCount(ny, nx);
            }
        }
        dp[y][x] = sum;
        return dp[y][x];
    }

    static int[] dx = { 0, 1, -1, 0 };
    static int[] dy = { 1, 0, 0, -1 };
}