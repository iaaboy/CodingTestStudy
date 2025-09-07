package acmicpc3095;

import java.io.*;
import java.util.*;

/* 플러스의 개수
 * https://www.acmicpc.net/problem/3095
 */

public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] str = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = str[j] - '0';
            }
        }

        int total = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) {
                    total += getCount(y, x);
                }
            }
        }
        System.out.println(total);
    }

    private static int getCount(int y, int x) {
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (isCross(y, x, i)) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    private static boolean isCross(int y, int x, int offset) {
        int xMin = x - offset, xMax = x + offset;
        int yMin = y - offset, yMax = y + offset;

        if (xMin < 0 || yMin < 0 || xMax >= N || yMax >= N) {
            return false;
        }

        if (map[yMax][x] != 1 || map[yMin][x] != 1 || map[y][xMin] != 1 || map[y][xMax] != 1) {
            return false;
        }

        for (int nx = xMin; nx <= xMax; nx++) {
            if (nx == x) {
                continue;
            }
            if (map[yMax][nx] != 0 || map[yMin][nx] != 0) {
                return false;
            }
        }

        for (int ny = yMin; ny <= yMax; ny++) {
            if (ny == y) {
                continue;
            }
            if (map[ny][xMax] != 0 || map[ny][xMin] != 0) {
                return false;
            }
        }

        return true;
    }
}
