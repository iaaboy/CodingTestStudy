package acmicpc17492;

import java.io.*;
import java.util.*;

/* 바둑알 점프
 * https://www.acmicpc.net/problem/17492
 */

public class Main {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    count++;
                }
            }
        }

        if (travel(count)) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }

    }

    private static boolean travel(int count) {
        System.out.println(count);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        if (count == 1) {

            return true;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int d = 0; d < 8; d++) {
                    int jumpX = x + dx[d];
                    int jumpY = y + dy[d];
                    int arriveX = x + 2 * dx[d];
                    int arriveY = y + 2 * dy[d];
                    if (!isSafe(jumpY, jumpX) || !isSafe(arriveY, arriveX)) {
                        continue;
                    }
                    if (map[jumpY][jumpX] != 2) {
                        continue;
                    }
                    if (map[arriveY][arriveX] != 0) {
                        continue;
                    }
                    if (map[y][x] != 2) {
                        continue;
                    }

                    // 조건이 맞으면!
                    map[y][x] = 0;
                    map[jumpY][jumpX] = 0;
                    map[arriveY][arriveX] = 2;
                    if (travel(count - 1)) {
                        return true;
                    }
                    map[y][x] = 2;
                    map[jumpY][jumpX] = 2;
                    map[arriveY][arriveX] = 0;
                }
            }
        }

        return false;
    }

    static boolean isSafe(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    static int[] dx = { 1, 0, 0, -1, 1, 1, -1, -1 };
    static int[] dy = { 0, 1, -1, 0, -1, 1, -1, 1 };

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
