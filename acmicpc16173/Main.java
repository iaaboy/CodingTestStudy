package acmicpc16173;

import java.io.*;
import java.util.*;

/* 점프왕 쩰리 (Small)
 * https://www.acmicpc.net/problem/16173
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Coord> q = new ArrayDeque<>();
        q.add(new Coord(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Coord c = q.poll();
            // System.out.println(c);
            if (c.x == N - 1 && c.y == N - 1) {
                System.out.println("HaruHaru");
                return;
            }

            int offset = map[c.y][c.x];
            if (offset == 0)
                continue;

            int nx = c.x + offset;
            if (nx < N && !visit[c.y][nx]) {
                visit[c.y][nx] = true;
                q.add(new Coord(nx, c.y));
            }

            int ny = c.y + offset;
            if (ny < N && !visit[ny][c.x]) {
                visit[ny][c.x] = true;
                q.add(new Coord(c.x, ny));
            }
        }

        System.out.println("Hing");
    }

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return y + "," + x;
        }
    }
}
