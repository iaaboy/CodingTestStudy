package acmicpc7571;

import java.io.*;
import java.util.*;

/* 점 모으기
 * https://www.acmicpc.net/problem/7571
 */

public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] countY = new int[N + 1];
        int[] countX = new int[N + 1];
        long sumX = 0;
        long sumY = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            countX[x]++;
            sumX += x;
            int y = Integer.parseInt(st.nextToken());
            countY[y]++;
            sumY += y;
        }

        sumX = getSum(sumX, countX);
        sumY = getSum(sumY, countY);

        System.out.println(sumX + sumY);
    }

    static long getSum(long sumX, int[] count) {
        int left = 0;
        int right = M;
        long rightSum = sumX;
        long leftSum = 0;
        // System.out.println(Arrays.toString(count));
        // System.out.println(sumX);
        long tempSum = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            rightSum -= right;
            if (i != 0) {
                left += count[i - 1];
            }
            right -= count[i];

            leftSum += left;
            tempSum = Math.min(tempSum, rightSum + leftSum);
            // System.out.println(i + ":" + left + "," + count[i] + "," + right);
            // System.out.println(tempSum + "," + leftSum + ".." + rightSum);
            // System.out.println();
        }
        return tempSum;
    }
}

/*
7 11
6 7
4 7
1 7
5 3
6 2
7 1
6 1
5 4
3 6
1 6
6 6
 */