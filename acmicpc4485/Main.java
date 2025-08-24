package acmicpc4485;

import java.io.*;
import java.util.*;

/* 녹색 옷 입은 애가 젤다지?
 * https://www.acmicpc.net/problem/4485
 */

public class Main {
    static int[][] dp, map;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (N != 0) {
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cost = travel(new Coord(0, 0, map[0][0]), new Coord(N - 1, N - 1));
            sb.append("Problem " + (T++) + ": ").append(cost).append("\n");
            N = Integer.parseInt(bf.readLine());
        }
        System.out.print(sb);
    }

    static int travel(Coord from, Coord to) {
        Queue<Coord> q = new ArrayDeque<>();
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[from.y][from.x] = 0;
        q.add(from);

        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (dp[ny][nx] > dp[c.y][c.x] + map[c.y][c.x]) {
                    dp[ny][nx] = dp[c.y][c.x] + map[c.y][c.x];
                    q.add(new Coord(ny, nx));
                }
            }
        }
        return dp[N - 1][N - 1] + map[N - 1][N - 1];
    }

    static class Coord {
        int y, x;

        public Coord(int y, int x, int cost) {
            this.y = y;
            this.x = x;
        }

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ")";
        }
    }

    static int[] dx = { 0, 1, -1, 0 };
    static int[] dy = { 1, 0, 0, -1 };
}
