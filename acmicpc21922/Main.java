package acmicpc21922;

import java.io.*;
import java.util.*;

/* 학부 연구생 민상
 * https://www.acmicpc.net/problem/21922
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][M];
        boolean[][][] visit = new boolean[4][N][M];
        ArrayList<Coord> ac = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 9) {
                    ac.add(new Coord(5, i, j));
                }
            }
        }
        int[][] map = new int[N][M];
        int visitIdx = 0;
        Queue<Coord> q = new ArrayDeque<>();
        for (Coord c : ac) {
            if (map[c.y][c.x] == 0) {
                map[c.y][c.x] = ++visitIdx;
                for (int i = 0; i < 4; i++) {
                    int nextX = c.x + offX[i];
                    int nextY = c.y + offY[i];
                    if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                        continue;
                    }
                    if (!visit[i][nextY][nextX]) {
                        visit[i][nextY][nextX] = true;
                        q.add(new Coord(i, nextY, nextX));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Coord c = q.poll();
            if (map[c.y][c.x] == 0) {
                map[c.y][c.x] = ++visitIdx;
            }
            int nextDir = c.dir;
            if ((c.dir == 0 || c.dir == 2) && lab[c.y][c.x] == 1) {
                continue;
            }
            if ((c.dir == 1 || c.dir == 3) && lab[c.y][c.x] == 2) {
                continue;
            }
            if (lab[c.y][c.x] == 3) {
                nextDir = flip3[nextDir];
            }
            if (lab[c.y][c.x] == 4) {
                nextDir = flip4[nextDir];
            }
            int nextX = c.x + offX[nextDir];
            int nextY = c.y + offY[nextDir];
            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                continue;
            }
            if (!visit[nextDir][nextY][nextX]) {
                visit[nextDir][nextY][nextX] = true;
                q.add(new Coord(nextDir, nextY, nextX));
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }
        System.out.println(visitIdx);
    }

    // right, down, left, up
    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, 1, 0, -1 };
    static int[] flip3 = { 3, 2, 1, 0 };
    static int[] flip4 = { 1, 0, 3, 2 };

    static class Coord {
        int dir;
        int x, y;

        public Coord(int dir, int y, int x) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }
}