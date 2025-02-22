package acmicpc7562;

import java.io.*;
import java.util.*;

/* 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int getNum = travel(y1, x1, y2, x2, N);
            sb.append(getNum).append("\n");
        }
        System.out.print(sb);
    }

    private static int travel(int y1, int x1, int y2, int x2, int n) {
        if (y1==y2 && x1 == x2) {
            return 0;
        }
        int [][] map = new int[n][n];
        Queue<Coord> q = new ArrayDeque<>();
        map[y1][x1] = 1;
        q.add(new Coord(y1, x1));
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 8; i++) {
                int nX = c.x + dx[i];
                int nY = c.y + dy[i];
                if (nY < 0 || nX < 0 || nY >= n || nX >= n) {
                    continue;
                }
                if (map[nY][nX] == 0) {
                    map[nY][nX] = map[c.y][c.x] + 1;
                    if (nY == y2 && nX == x2) {
                        return map[c.y][c.x];
                    }
                    q.add(new Coord(nY, nX));
                }
            }
        }
        return -1;
    }
    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
}
