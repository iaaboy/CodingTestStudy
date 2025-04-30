package acmicpc25682;

import java.io.*;
import java.util.*;

/* 체스판 다시 칠하기 2
 * https://www.acmicpc.net/problem/25682
 * 누적합
 * BWB..기준, WBW..기준으로 입력 받은 문자들과 다른 개수를 누적합 저장.
 * for loop으로 최소 개수 구하기.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] chess = new char[N][M];

        for (int i = 0; i < N; i++) {
            chess[i] = bf.readLine().toCharArray();
        }
        char[][] ref1 = new char[N][M];
        char[][] ref2 = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ref1[i][j] = ((i + j) % 2 == 0) ? 'B' : 'W';
                ref2[i][j] = ((i + j) % 2 == 0) ? 'W' : 'B';
            }
        }
        int[][] diffAccumul1 = new int[N][M];
        int[][] diffAccumul2 = new int[N][M];

        // // for debug
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         if (chess[i][j] != ref1[i][j]) {
        //             diffAccumul1[i][j]++;
        //             diffAccumul2[i][j]++;
        //         }
        //     }
        // }
        // printArr(N, diffAccumul1);
        // printArr(N, diffAccumul2);
        // // end debug

        for (int i = 0; i < N; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < M; j++) {
                if (chess[i][j] != ref1[i][j]) {
                    count1++;
                }
                diffAccumul1[i][j] = count1;
                if (i != 0) {
                    diffAccumul1[i][j] += diffAccumul1[i - 1][j];
                }

                if (chess[i][j] != ref2[i][j]) {
                    count2++;
                }
                diffAccumul2[i][j] = count2;
                if (i != 0) {
                    diffAccumul2[i][j] += diffAccumul2[i - 1][j];
                }
            }
        }

        // printArr(N, diffAccumul1);
        // printArr(N, diffAccumul2);

        K--;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < N - K; i++) {
            for (int j = 0; j < M - K; j++) {
                int count1 = getCount(i + K, j + K, i, j, diffAccumul1);
                // System.out.println((i + K) + "," + (j + K) + "->" + i + "," + j + ":" + count1);
                int count2 = getCount(i + K, j + K, i, j, diffAccumul2);
                // System.out.println((i + K) + "," + (j + K) + "->" + i + "," + j + ":" + count2);
                minCount = Math.min(minCount, count1);
                minCount = Math.min(minCount, count2);
            }
        }
        System.out.println(minCount);
    }

    static int getCount(int y2, int x2, int y1, int x1, int[][] arr) {
        int result = 0;
        if (y1 == 0 && x1 == 0) {
            result = arr[y2][x2];
        } else if (y1 == 0) {
            x1--;
            result = arr[y2][x2] - arr[y2][x1];
        } else if (x1 == 0) {
            y1--;
            result = arr[y2][x2] - arr[y1][x2];
        } else {
            x1--;
            y1--;
            result = arr[y2][x2] - arr[y2][x1] - arr[y1][x2] + arr[y1][x1];
        }
        return result;
    }

    static void printArr(int N, int[][] diffAccumul) {
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(diffAccumul[i]));
        }
    }
}
