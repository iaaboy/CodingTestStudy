package acmicpc31462;

import java.io.*;

/* 삼각 초콜릿 포장 (Sweet) 
 * https://www.acmicpc.net/problem/31462
 */

public class Main {
    static char[][] box;
    static boolean[][] checked;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        box = new char[N][];
        checked = new boolean[N][];
        for (int i = 0; i < N; i++) {
            box[i] = bf.readLine().toCharArray();
            checked[i] = new boolean[box[i].length];
        }
        int isGood = 1;
        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (!checked[i][j]) {
                    if (!check(i, j)) {
                        isGood = 0;
                        break loop;
                    }
                }
            }
        }
        System.out.println(isGood);
    }

    static int[] bx = { 1, 1 };
    static int[] by = { 0, 1 };
    static int[] rx = { 0, 1 };
    static int[] ry = { 1, 1 };

    private static boolean check(int y, int x) {
        checked[y][x] = true;
        int ny, nx;
        for (int i = 0; i < 2; i++) {
            if (box[y][x] == 'R') {
                ny = y + ry[i];
                nx = x + rx[i];
            } else {
                ny = y + by[i];
                nx = x + bx[i];
            }
            if (ny >= N || nx >= checked[ny].length) {
                return false;
            }

            if (!checked[ny][nx] && box[ny][nx] == box[y][x]) {
                checked[ny][nx] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
