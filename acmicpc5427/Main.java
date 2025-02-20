package acmicpc5427;

import java.io.*;
import java.util.*;

/* 불
 * https://www.acmicpc.net/problem/5427
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int[][] map = new int[R][C];
            Coord jh = null;
            Queue<Coord> q = new ArrayDeque<>();
            for (int i = 0; i < R; i++) {
                char[] m = bf.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (m[j] == '*') {
                        q.add(new Coord(i, j));
                        map[i][j] = -2;
                    } else if (m[j] == '@') {
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

            int result = travel(map, q, C, R);
            if (result > 0) {
                sb.append(result).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }

            printMap(map);
        }
        System.out.print(sb);
    }

    private static int travel(int[][] map, Queue<Coord> q, int C, int R) {
        while (!q.isEmpty()) {
            Coord c = q.poll();
            // System.out.println(c);
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + offX[i];
                int nextY = c.y + offY[i];
                if (nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) {
                    if (map[c.y][c.x] > 0) {
                        printMap(map);
                        return map[c.y][c.x];
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
        return -1;
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
