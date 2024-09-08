package acmic24426;

import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 행렬 경로 문제 3
 * https://www.acmicpc.net/problem/24426
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[][] arr = new long[N][N];
        long[][] sum1 = new long[N][N];
        long[][] sum2 = new long[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 첫행 k 번째 예외처리할 경우
                /*
                 * 5
                 * 1 10 10 10 10
                 * 1 1 1 1 1
                 * 1 1 1 1 1
                 * 1 1 1 1 1
                 * 1 1 1 1 1
                 * 1 2
                 */
                if (y == 0 && i == 0 && j >= x) {
                    continue;
                }
                // 첫열 k 번째 예외처리할 경우
                if (x == 0 && j == 0 && i >= y) {
                    continue;
                }

                if (y == i && x == j) {
                    continue;
                }
                long up = i == 0 ? 0 : sum1[i - 1][j];
                long left = j == 0 ? 0 : sum1[i][j - 1];
                sum1[i][j] = arr[i][j] + Math.max(up, left);
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(sum1[i]));
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i > y && j < x) {
                    continue;
                }
                if (i < y && j > x) {
                    continue;
                }
                long up = i == 0 ? 0 : sum2[i - 1][j];
                long left = j == 0 ? 0 : sum2[i][j - 1];

                sum2[i][j] = arr[i][j] + Math.max(up, left);
            }
        }
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(sum2[i]));
        // }
        System.out.println(sum2[N - 1][N - 1] + " " + sum1[N - 1][N - 1]);
    }
}
