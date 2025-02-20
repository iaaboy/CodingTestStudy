package acmicpc7569;

import java.io.*;
import java.util.*;

/* 토마토
 * https://www.acmicpc.net/problem/7569
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로 h
        int N = Integer.parseInt(st.nextToken()); // 세로 y
        int H = Integer.parseInt(st.nextToken()); // 높이 x

        int[][][] map = new int[H][N][M];
        Queue<Coord> q = new ArrayDeque<>();
        int zeroCount = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q.add(new Coord(i, j, k));
                    } else if (map[i][j][k] == 0) {
                        zeroCount++;
                    }
                }
            }
        }

        int maxDay = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = c.x + offsetX[i];
                int nextY = c.y + offsetY[i];
                int nextH = c.h + offsetH[i];
                if (nextH < 0 || nextX < 0 || nextY < 0) {
                    continue;
                }
                if (nextH >= H || nextX >= M || nextY >= N) {
                    continue;
                }
                if (map[nextH][nextY][nextX] == 0) {
                    map[nextH][nextY][nextX] = map[c.h][c.y][c.x] + 1;
                    zeroCount--;
                    maxDay = Math.max(maxDay, map[nextH][nextY][nextX]);
                    q.add(new Coord(nextH, nextY, nextX));
                }
            }
        }
        if (zeroCount <= 0) {
            maxDay = maxDay == Integer.MIN_VALUE ? 1 : maxDay;
            System.out.println(maxDay - 1);
        } else {
            System.out.println(-1);
        }
    }

    static int[] offsetX = { 1, -1, 0, 0, 0, 0 };
    static int[] offsetY = { 0, 0, 1, -1, 0, 0 };
    static int[] offsetH = { 0, 0, 0, 0, 1, -1 };

    static class Coord {
        int x, y, h;

        public Coord(int h, int y, int x) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
