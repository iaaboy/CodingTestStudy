package acmicpc7576;

import java.io.*;
import java.util.*;

/* 토마토
 * https://www.acmicpc.net/problem/7576
 */

public class Main {
    static int[][] paint;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        boolean hasNItem = true;
        paint = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
                if (hasNItem && paint[i][j] == 0) {
                    hasNItem = false;
                }
            }
        }
        if (hasNItem) {
            System.out.println(0);
            return;
        }
        Queue <Coord> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paint[i][j] == 1) {
                    q.add(new Coord(i, j, 0));
                }
            }
        }

        
        
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + xOffset[i];
                int nextY = c.y + yOffset[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (paint[nextY][nextX] == 0) {
                    paint[nextY][nextX] = c.depth + 1;
                    q.add(new Coord(nextY, nextX, c.depth + 1));
                }
            }
        }

        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxNum = Math.max(maxNum, paint[i][j]);
                if (paint[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxNum);
    }

    static int[] xOffset = { 1, -1, 0, 0 };
    static int[] yOffset = { 0, 0, 1, -1 };

    static class Coord{
        int x, y;
        int depth;
        public Coord(int y, int x, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
