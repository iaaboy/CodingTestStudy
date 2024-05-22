package acmicpc1012;

import java.io.*;
import java.util.*;

/* https://www.acmicpc.net/problem/1012
 * 유기농 배추
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] farm = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                farm[y][x] = -1;
            }
            int index = 0;
            printFarm(farm);
            for (int y = 0; y < M; y++) {
                for (int x = 0; x < N; x++) {
                    if (farm[y][x] == -1) {
                        farm[y][x] = ++index;
                        checkNeighbor(farm, index, y, x, 5);
                        printFarm(farm);
                    }
                }
            }
            System.out.println(index);
        }
    }

    private static void printFarm(int[][] farm) {
        // for (int i = 0; i < farm.length; i++) {
        // for (int j = 0; j < farm[0].length; j++) {
        // System.out.print(farm[i][j] + " ");
        // }
        // System.out.println();
        // }
    }

    static int[] xOffset = { 1, -1, 0, 0 };
    static int[] yOffset = { 0, 0, 1, -1 };

    private static void checkNeighbor(int[][] farm, int index, int y, int x, int from) {
        for (int i = 0; i < 4; i++) {
            // if(i == from)
            // continue;
            int nextX = x + xOffset[i];
            int nextY = y + yOffset[i];
            if (nextX < 0 || nextX > farm[0].length - 1 || nextY < 0 || nextY > farm.length - 1)
                continue;
            if (farm[nextY][nextX] == -1) {
                farm[nextY][nextX] = index;
                checkNeighbor(farm, index, nextY, nextX, i);
            }
        }
    }
}
