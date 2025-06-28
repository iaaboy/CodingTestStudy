package acmicpc23563;

/* 벽 타기
 * https://www.acmicpc.net/problem/23563
 */

import java.io.*;
import java.util.*;

public class Main {
    static int [] dx = {0, 1, -1,0};

    static int [] dy = {1, 0, 0, -1};    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        int[][] dp = new int[H][W];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Coord E = null;
        ArrayDeque<Coord> adq = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            map[i] = bf.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'S') {
                    dp[i][j] = 0;
                    adq.add(new Coord(i, j));
                } else if (map[i][j] == 'E') {
                    E = new Coord(i, j);
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                        continue;
                    }
                    if (map[ny][nx] == '#' && map[i][j] != '#') {
                        map[i][j] = 'W';
                    }
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        int cost = 1;
        while (!adq.isEmpty()) {
            Coord c = adq.poll();
            if (c.equals(E)) {
                minDistance = Math.min(minDistance, c.d);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                    continue;
                }
                if (map[ny][nx] == '#') {
                    continue;
                }
                if (map[ny][nx] == 'W' && map[c.y][c.x] == 'W') {
                    cost = 0;
                } else {
                    cost = 1;
                }
                if (dp[ny][nx] > c.d + cost) {
                    dp[ny][nx] = c.d + cost;
                    adq.add(new Coord(ny, nx, c.d + cost));
                }
            }
        }
        // for (int i = 0; i < H; i++) {
        //     System.out.println();
        //     for (int j = 0; j < W; j++) {
        //         if (map[i][j] != '.') {
        //             System.out.print(map[i][j] + " ");
        //         } else {
        //             System.out.print(dp[i][j] + " ");
        //         }
                
        //     }
        // }
        // System.out.println();
        System.out.println(dp[E.y][E.x]);

    }
    static class Coord {
        int y, x;
        int d;
        public Coord(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
        @Override
        public boolean equals(Object obj) {
            Coord o = (Coord) obj;
            return x == o.x && y == o.y;
        }
        // @Override
        // public int hashCode() {
        // return 31 * x + y;
        // }
    }
}