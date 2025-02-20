package acmicpc4179;

import java.io.*;
import java.util.*;

/* 불!
 * https://www.acmicpc.net/problem/4179
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        Coord jh = null;
        Queue<Coord> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            char[] m = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (m[j] == 'F') {
                    q.add(new Coord(i, j));
                    map[i][j] = -2;
                } else if (m[j] == 'J') {
                    jh = new Coord(i, j);
                    map[i][j] = 1;
                } else if (m[j] == '#') {
                    map[i][j] = -1;
                }
            }
        }
        if (jh != null) {
            q.add(jh);
        }

        while (!q.isEmpty()) {
            Coord c = q.poll();
            // System.out.println(c);
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + offX[i];
                int nextY = c.y + offY[i];
                if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) {
                    if (map[c.y][c.x] > 0) {
                        printMap(map);
                        System.out.println(map[c.y][c.x]);
                        return;
                    }
                    continue;
                }
                if (map[nextY][nextX] == 0) {
                    if (map[c.y][c.x] > 0) {
                        map[nextY][nextX] = map[c.y][c.x] + 1;
                    } else {
                        map[nextY][nextX] = map[c.y][c.x] - 1;
                    }
                    q.add(new Coord(nextY, nextX));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
        printMap(map);
    }

    private static void printMap(int[][] map) {
        // for (int i = 0; i < map.length; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }
    }

    static int[] offX = { 1, 0, 0, -1 };
    static int[] offY = { 0, 1, -1, 0 };

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x;
        }
    }
}
