package acmicpc1743;

import java.io.*;
import java.util.*;

/* 음식물 피하기
 * https://www.acmicpc.net/problem/1743
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] farm = new int[N][M];
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            farm[r][c] = -1;
        }
        int index = 0;
        printFarm(farm);
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (farm[y][x] == -1) {
                    index++;
                    counts.put(index, 1);
                    farm[y][x] = index;
                    checkNeighbor(counts, farm, index, y, x, 5);
                    printFarm(farm);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int c : counts.values()) {
            max = Math.max(max, c);
        }
        System.out.println(max);
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

    private static void checkNeighbor(HashMap<Integer, Integer> counts, int[][] farm, int index, int y, int x,
            int from) {
        for (int i = 0; i < 4; i++) {
            // if(i == from)
            // continue;
            int nextX = x + xOffset[i];
            int nextY = y + yOffset[i];
            if (nextX < 0 || nextX > farm[0].length - 1 || nextY < 0 || nextY > farm.length - 1)
                continue;
            if (farm[nextY][nextX] == -1) {
                farm[nextY][nextX] = index;
                counts.put(index, counts.get(index) + 1);
                checkNeighbor(counts, farm, index, nextY, nextX, i);
            }
        }
    }
}
