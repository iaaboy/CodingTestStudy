package acmicpc1451;

import java.io.*;
import java.util.*;

/* 직사각형으로 나누기
 * https://www.acmicpc.net/problem/1451
 * 누적합
 */

public class Main {
    static int arr[][];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] nums = bf.readLine().toCharArray();
            int smallSum = 0;
            for (int j = 1; j <= M; j++) {
                int num = nums[j - 1] - '0';
                smallSum += num;
                arr[i][j] = smallSum;
                arr[i][j] += arr[i - 1][j];
            }
        }

        // for (int i = 0; i <= N; i++) {
        // System.out.println(Arrays.toString(arr[i]));
        // }
        // System.out.println(getSqareSum(1,3, 1, 3));

        // 가로로만
        maxSum = Math.max(maxSum, getHorizontal());

        // 세로로만
        maxSum = Math.max(maxSum, getVertical());

        // 가로 세로 복합
        maxSum = Math.max(maxSum, getMulti());

        System.out.println(maxSum);

    }

    private static long getMulti() {
        long max = 0;
        for (int y = 1; y < N; y++) {
            for (int x = 1; x < M; x++) {

                long d1 = getSqareSum(1, 1, y, x);
                long d2 = getSqareSum(1, x + 1, y, M);
                long d3 = getSqareSum(y + 1, 1, N, x);
                long d4 = getSqareSum(y + 1, x + 1, N, M);

                long upperHalf = getSqareSum(1, 1, y, M);
                long downHalf = getSqareSum(y + 1, 1, N, M);

                long leftHalf = getSqareSum(1, 1, N, x);
                long rightHalf = getSqareSum(1, x + 1, N, M);

                // System.out.println(y + "," + x);
                // System.out.println(d1 + " " + d2 + " " + d3 + " " + d4);
                // System.out.println(upperHalf + " " + downHalf + " " + leftHalf + " " + rightHalf);


                max = Math.max(max, upperHalf * d3 * d4);
                max = Math.max(max, downHalf * d1 * d2);
                max = Math.max(max, leftHalf * d2 * d4);
                max = Math.max(max, rightHalf * d1 * d3);

            }
        }
        return max;
    }

    private static long getVertical() {
        long verticalMax = 0;
        for (int up = 1; up < N - 1; up++) {
            for (int down = up + 1; down < N; down++) {
                long upSquare = getSqareSum(1, 1, up, M);
                long centerSquare = getSqareSum(up + 1, 1, down, M);
                long downSquare = getSqareSum(down + 1, 1, N, M);
                long sum = upSquare * centerSquare * downSquare;
                verticalMax = Math.max(verticalMax, sum);
                // System.out.println("Vertical " + up + "," + down + " : " + sum);
            }
        }
        return verticalMax;
    }

    private static long getHorizontal() {
        long verticalMax = 0;
        for (int left = 1; left < M - 1; left++) {
            for (int second = left + 1; second < M; second++) {
                long leftSquare = getSqareSum(1, 1, N, left);
                long centerSquare = getSqareSum(1, left + 1, N, second);
                long secondSquare = getSqareSum(1, second + 1, N, M);
                long sum = leftSquare * centerSquare * secondSquare;
                verticalMax = Math.max(verticalMax, sum);
                // System.out.println("horizontal: " + left + "," + second + " : " + sum);
            }
        }
        return verticalMax;
    }

    static long maxSum = 0;

    private static int getSqareSum(int y1, int x1, int y2, int x2) {
        y1--;
        x1--;
        int sum = arr[y2][x2] - arr[y2][x1] - arr[y1][x2] + arr[y1][x1];
        return sum;
    }
}
