package acmicpc7453;

import java.io.*;
import java.util.*;

/* 합이 0인 네 정수
 * https://www.acmicpc.net/problem/7453
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // TODO
        // Arrays 를 따로 저장해서 해야함.
        int[][] arr = new int[N][4];
        int[][] sum = new int[2][N * N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 4; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[0][idx] = arr[i][0] + arr[j][1];
                sum[1][idx++] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);

        // System.out.println(Arrays.toString(sum[0]));
        // System.out.println(Arrays.toString(sum[1]));

        long count = 0;
        for (int i = 0; i < N * N; i++) {
            int a = upperBound(sum[1], -sum[0][i]);
            int b = lowerBound(sum[1], -sum[0][i]);
            // System.out.println(sum[0][i] + " : " + (a-b) + " .. " + a + "," + b);
            count += (long)a-b;
        }
        System.out.println(count);
    }

    private static int upperBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] <= key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left;
    }

    private static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right;
    }
}
