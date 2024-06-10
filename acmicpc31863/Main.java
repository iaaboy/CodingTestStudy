package acmicpc31863;

import java.io.*;
import java.util.*;

/* 내진 설계
 * https://www.acmicpc.net/problem/31863
 */

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int[][] mapUpdated = new int[N][M];
        int stX = 0;
        int stY = 0;

        int totalCount = 0;
        for (int i = 0; i < N; i++) {
            char[] input = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (input[j] == '*') {
                    totalCount++;
                    mapUpdated[i][j] = map[i][j] = 1;
                } else if (input[j] == '#') {
                    totalCount++;
                    mapUpdated[i][j] = map[i][j] = 2;
                } else if (input[j] == '|') {
                    mapUpdated[i][j] = map[i][j] = -1;
                } else if (input[j] == '@') {
                    map[i][j] = 9;
                    stX = j;
                    stY = i;
                }
            }
        }

        // printArr(map, "before");
        eq(mapUpdated, stY, stX, 2);
        // printArr(mapUpdated, "after");

        int leftCount = 0;
        for (int i = 0; i < mapUpdated.length; i++) {
            for (int j = 0; j < mapUpdated[0].length; j++) {
                if (mapUpdated[i][j] > 0) {
                    leftCount++;
                }
            }
        }

        System.out.println(totalCount - leftCount + " " + leftCount);
    }

    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, 1, 0, -1 };

    private static void eq(int[][] curMap, int stY, int stX, int power) {
        for (int i = 0; i < 4; i++) {
            for (int p = 1; p <= power; p++) {
                int x = stX + p * offX[i];
                int y = stY + p * offY[i];
                if (x < 0 || y < 0 || x >= curMap[0].length || y >= curMap.length)
                    continue;
                if (curMap[y][x] < 0) {
                    break;
                }
                if (curMap[y][x] > 0) {
                    // 현재 Power 값 전달 필요.
                    curMap[y][x] = Math.max(0, curMap[y][x] - 1);
                    if (curMap[y][x] == 0)
                        eq(curMap, y, x, 1);
                }
            }
        }
    }

    private static void printArr(int[][] map, String msg) {
        System.out.println(msg);
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}