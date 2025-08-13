package acmicpc2615;

import java.io.*;
import java.util.*;

/* 오목
 * https://www.acmicpc.net/problem/2615
 */

public class Main {
    static int N = 19;
    static int[][][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        board = new int[N][N][8];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 8; k++) {
                    board[i][j][k] = num;
                }
            }
        }

        if (setOmok(1)) {
            return;
        }
        if (setOmok(2)) {
            // printBoard(3);
            return;
        }
        System.out.println(0);

        // System.out.println();
        // printBoard(1);
    }

    private static void printBoard(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j][num] != 0 ? board[i][j][num] : "00").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean setOmok(int num) {
        int offset = num == 1 ? 10 : 20;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    if (board[i][j][k] == num) {
                        int sum = 1;
                        board[i][j][k] = offset + sum;
                        int y = i + dy[k];
                        int x = j + dx[k];
                        while (isInrange(y, x) && board[y][x][k] == num) {
                            sum += 1;
                            if (sum == 6) {
                                board[y - dy[k]][x - dx[k]][k] = 0;
                            }
                            board[y][x][k] = offset + sum;
                            y = y + dy[k];
                            x = x + dx[k];
                        }
                        if (sum == 5) {
                            System.out.println(num);
                            if (k == 3) {
                                System.out.println((y - dy[k] + 1) + " " + (x-dx[k] + 1));
                            } else {
                                System.out.println((i + 1) + " " + (j + 1));
                            }
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    static int dx[] = new int[] { 1, 1, 0, -1, 0, -1, 0, 1 };
    static int dy[] = new int[] { 0, 1, 1, 1, -1, -1, -1, -1 };

    private static boolean isInrange(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}
/*
0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */