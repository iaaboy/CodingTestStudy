package acmicpc14940;

import java.io.*;
import java.util.*;

/* 쉬운 최단거리
 * https://www.acmicpc.net/problem/14940
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] map = new int[N][M];
        Queue<Coord> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    q.add(new Coord(i, j));
                } else if (arr[i][j] != 0) {
                    map[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = c.x + xOffset[i];
                int nY = c.y + yOffset[i];
                if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                    continue;
                }
                if (arr[nY][nX] == 0 || map[nY][nX] != -1 && map[c.y][c.x] + 1 >= map[nY][nX]) {
                    continue;
                }
                map[nY][nX] = map[c.y][c.x] + 1;
                q.add(new Coord(nY, nX));
            }

            // printMap(map);
        }
        printMap(map);
    }

    private static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] xOffset = { 1, -1, 0, 0 };
    static int[] yOffset = { 0, 0, 1, -1 };

    static class Coord {
        int x, y;

        public Coord(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}

/*

5 3
2 1 1
1 1 1
1 1 1
0 0 0
1 1 1

 */