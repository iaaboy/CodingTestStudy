package acmicpc16995;

import java.io.*;
import java.util.*;

/* 오목, 이길 수 있을까?
 * https://www.acmicpc.net/problem/16955
 */

public class Main {
    static char[][] board;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int d = 0; d < 8; d++) {
                    if (board[i][j] == 'X' && checkBoard(i, j, d)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    private static boolean checkBoard(int y, int x, int d) {
        int countLimit = 1;
        for (int i = 0; i < 4; i++) {
            x += dx[d];
            y += dy[d];
            if (x < 0 || y < 0 || x >= 10 || y >= 10) {
                return false;
            }
            if (board[y][x] == 'O') {
                return false;
            }
            if (board[y][x] == '.') {
                countLimit--;
                if (countLimit < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}