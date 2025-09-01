package acmicpc20002;

import java.io.*;
import java.util.*;

/* 사과나무
 * https://www.acmicpc.net/problem/20002
 */

public class Main {
    static int [][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int smallSum = 0;
            for (int j = 1; j < N + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                smallSum += num;
                arr[i][j] = smallSum + arr[i - 1][j];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int size = 0; size <= N; size++) {
            for (int y = 1; y <= N - size; y++) {
                for (int x = 1; x <= N - size; x++) {
                    int sum = getSum(y, x, y + size, x + size);
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        System.out.println(maxSum);

    }

    static int getSum (int y1, int x1, int y2, int x2) {
        // System.out.println(y1 + "," + x1 + ".." + y2 + "," + x2);
        y1--;x1--;
        return arr[y2][x2] - arr[y2][x1] - arr[y1][x2] + arr[y1][x1];
    }
}
