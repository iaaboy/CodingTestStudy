package acmicpc1926;

import java.io.*;
import java.util.*;

/* 그림
 * https://www.acmicpc.net/problem/1926
 */

public class Main {
    static int[][] paint;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paint = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    paint[i][j] = -1;
                }
            }
        }
        int index = 1;
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paint[i][j] == -1) {
                    paint[i][j] = index;
                    int c = checkNeighbor(index, i, j) + 1;
                    maxNum = Math.max(maxNum, c);
                    index++;
                }
            }
        }

        // for (int i = 0; i < paint.length; i++) {
        //     System.out.println(Arrays.toString(paint[i]));
        // }
        System.out.println((index - 1) + "\n" + maxNum);

    }

    static int[] xOffset = { 1, -1, 0, 0 };
    static int[] yOffset = { 0, 0, 1, -1 };

    private static int checkNeighbor(int index, int y, int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            // if(i == from)
            // continue;
            int nextX = x + xOffset[i];
            int nextY = y + yOffset[i];
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
                continue;
            if (paint[nextY][nextX] == -1) {
                paint[nextY][nextX] = index;
                count ++;
                count += checkNeighbor(index, nextY, nextX);
            }
        }
        return count;
    }
}
