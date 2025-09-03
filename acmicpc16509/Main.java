package acmicpc16509;

import java.io.*;
import java.util.*;

/* 장군
 * https://www.acmicpc.net/problem/16509
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Coord sang = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
        st = new StringTokenizer(bf.readLine());
        Coord king = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        final int YMAX = 10;
        final int XMAX = 9;
        int[][] map = new int[YMAX][XMAX];
        map[sang.y][sang.x] = 1;
        map[king.y][king.x] = -2;

        int[][] dx = { { 0, 1, 2 }, { 0, -1, -2 }, { 1, 2, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 }, { -1, -2, -3 },
                { -1, -2, -3 } };
        int[][] dy = { { 1, 2, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, -1, -2 }, { -1, -2, -3 }, { -1, -2, -3 },
                { 0, 1, 2 }, { 0, -1, -2 } };
        Queue<Coord> q = new ArrayDeque<>();
        q.add(sang);
        while (!q.isEmpty()) {
            Coord c = q.poll();
            // System.out.println(c);
            for (int d = 0; d < 8; d++) {
                int nx = c.x + dx[d][0];
                int ny = c.y + dy[d][0];
                if (ny < 0 || nx < 0 || ny >= YMAX || nx >= XMAX) {
                    continue;
                }
                if (map[ny][nx] == -2) {
                    continue;
                }
                nx = c.x + dx[d][1];
                ny = c.y + dy[d][1];
                if (ny < 0 || nx < 0 || ny >= YMAX || nx >= XMAX) {
                    continue;
                }
                if (map[ny][nx] == -2) {
                    continue;
                }
                nx = c.x + dx[d][2];
                ny = c.y + dy[d][2];
                if (ny < 0 || nx < 0 || ny >= YMAX || nx >= XMAX) {
                    continue;
                }
                if (map[ny][nx] == -2) {
                    System.out.println((c.count));
                    // for (int i = 0; i < map.length; i++) {
                    //     System.out.println(Arrays.toString(map[i]));
                    // }
                    return;
                }
                if (map[ny][nx] > 0) {
                    continue;
                }
                map[ny][nx] = c.count;
                q.add(new Coord(ny, nx, c.count + 1));
            }
        }
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        System.out.println(-1);
    }

    static class Coord {
        int y, x;
        int count;

        public Coord(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ".." + count + ")";
        }
    }
}
