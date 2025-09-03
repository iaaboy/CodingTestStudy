package acmicpc2115;

import java.io.*;
import java.util.*;

/* 갤러리
 * https://www.acmicpc.net/problem/2115
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N <= 2 || M <= 2) {
            System.out.println(0);
            return;
        }
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        int[][][] wallUpDown = new int[N][M][2];
        int[][][] wallLeftRight = new int[N][M][2];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                char up = map[i - 1][j];
                char down = map[i][j];
                if (up == 'X' && down == '.') {
                    wallUpDown[i][j][0] = 1;
                } else if (up == '.' && down == 'X') {
                    wallUpDown[i][j][1] = 1;
                }

                char left = map[i][j - 1];
                char right = map[i][j];
                if (left == 'X' && right == '.') {
                    wallLeftRight[i][j][0] = 1;
                } else if (left == '.' && right == 'X') {
                    wallLeftRight[i][j][1] = 1;
                }
            }
        }

        for (int type = 0; type < 2; type++) {
            for (int y = 0; y < N; y++) {
                for (int x = 1; x < M; x++) {
                    if (wallUpDown[y][x - 1][type] > 0 && wallUpDown[y][x][type] > 0) {
                        wallUpDown[y][x][type] += wallUpDown[y][x - 1][type];
                        wallUpDown[y][x - 1][type] = 0;
                    }
                }
            }
        }

        // for (int type = 0; type < 2; type++) {
        //     System.out.println("type: " + type);
        //     for (int y = 0; y < N; y++) {
        //         for (int x = 0; x < M; x++) {
        //             System.out.print(wallUpDown[y][x][type] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        for (int type = 0; type < 2; type++) {
            for (int y = 1; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (wallLeftRight[y - 1][x][type] > 0 && wallLeftRight[y][x][type] > 0) {
                        wallLeftRight[y][x][type] += wallLeftRight[y - 1][x][type];
                        wallLeftRight[y - 1][x][type] = 0;
                    }
                }
            }
        }

        // for (int type = 0; type < 2; type++) {
        //     System.out.println("type: " + type);
        //     for (int y = 0; y < N; y++) {
        //         for (int x = 0; x < M; x++) {
        //             System.out.print(wallLeftRight[y][x][type] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        int totalCount = 0;
        for (int type = 0; type < 2; type++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    totalCount += wallUpDown[y][x][type] / 2;
                    totalCount += wallLeftRight[y][x][type] / 2;
                }
            }
        }
        System.out.println(totalCount);
    }
}
