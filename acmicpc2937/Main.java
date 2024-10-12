package acmicpc2937;

import java.io.*;
import java.util.*;

/* 블록 정리
 * https://www.acmicpc.net/problem/2937
 */

public class Main {
    static int N, M;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // Total
        int[][] arr = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
        }
        sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            int total = 0;
            for (int j = 0; j < N; j++) {
                total += arr[i][j];
                int preSum = i == 0 ? 0 : sum[i - 1][j];
                sum[i][j] = preSum + total;
            }
        }

        // System.out.println("---");
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(arr[i]));
        // }
        // System.out.println("---");
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(sum[i]));
        // }
        // System.out.println("---");

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i * j == M) {
                    // System.out.println(i + "," + j);
                    // x가 i 차이, y가 j 차이
                    result = Math.max(countNum(j, i), result);
                }
            }
        }
        System.out.println(M - result);
    }

    private static int countNum(int xDiff, int yDiff) {
        int maxSqare = 0;
        for (int i = 0; i < N - yDiff + 1; i++) {
            for (int j = 0; j < N - xDiff + 1; j++) {
                int y1 = i;
                int y2 = i + yDiff - 1;
                int x1 = j;
                int x2 = j + xDiff - 1;
                int sq = getSqare(y1, x1, y2, x2);
                maxSqare = Math.max(maxSqare, sq);
            }
        }
        return maxSqare;
    }

    private static int getSqare(int y1, int x1, int y2, int x2) {
        int r = 0;
        if (x1 == 0 && y1 == 0) {
            r = sum[y2][x2];
        } else if (y1 == 0) {
            r = sum[y2][x2] - sum[y2][x1 - 1];
        } else if (x1 == 0) {
            r = sum[y2][x2] - sum[y1 - 1][x2];
        } else {
            r = sum[y2][x2] - sum[y1 - 1][x2] - sum[y2][x1 - 1] + sum[y1 - 1][x1 - 1];
        }
        // System.out.println("getSquare: " + x1 + "," + y1 + "," + x2 + "," + y2 + " : " + r);
        return r;
    }
}
