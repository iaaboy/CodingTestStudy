package acmicpc2512;

import java.io.*;
import java.util.*;

/* 예산
 * https://www.acmicpc.net/problem/2512
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        long K = Integer.parseInt(bf.readLine());
        System.out.println(upperBound(arr, K, max));

    }

    private static long upperBound(long[] arr, long K, long max) {
        long left = 0;
        long right = max + 1;
        while (left < right) {
            long center = (left + right) / 2;
            long gotSum = getSum(arr, center);
            // System.out.println(center + ":" + gotSum);
            if (gotSum <= K) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left - 1;
    }

    private static long getSum(long[] arr, long key) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) {
                sum += key;
            } else {
                sum += arr[i];
            }
        }
        return sum;
    }
}
