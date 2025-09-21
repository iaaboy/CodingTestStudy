package acmicpc34409;

import java.io.*;
import java.util.*;

/* 무등산 등반
 * https://www.acmicpc.net/problem/34409
 */

public class Main {
    static int[][] map;
    static int[][] dp;
    static int pX, pY;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int sY = Integer.parseInt(st.nextToken()) - 1;
        int sX = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) {
                    max = map[i][j];
                    pY = i;
                    pX = j;
                }
            }
        }
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        Queue<Coord> q = new ArrayDeque<>();
        dp[sY][sX] = 0;
        q.add(new Coord(sY, sX));
        while (!q.isEmpty()) {
            Coord cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || ny >= N || nx >= M) {
                    continue;
                }
                int diff = map[ny][nx] - map[cur.y][cur.x];
                if (Math.abs(diff) > c) {
                    continue;
                }

                if (diff > 0) {
                    diff = Math.abs(diff) * a;
                } else if (diff < 0) {
                    diff = Math.abs(diff) * b;
                } else {
                    diff = 1;
                }
                if (dp[cur.y][cur.x] + diff < dp[ny][nx]) {
                    dp[ny][nx] = dp[cur.y][cur.x] + diff;
                    q.add(new Coord(ny, nx));
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(dp[i]));
        // }

        if (dp[pY][pX] == Integer.MAX_VALUE) {
            dp[pY][pX] = -1;
        }
        System.out.println(dp[pY][pX]);

    }

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
}
