package acmicpc1654;

import java.io.*;
import java.util.*;

/* 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int maxLength = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            maxLength = Math.max(maxLength, arr[i]);
        }
        long result = minLength(arr, N, maxLength);
        System.out.println(result);
    }

    private static long minLength(int[] arr, long N, long maxLength) {
        // N개를 만들 수 있는 최대 길이
        long left = 1;
        long right = maxLength + 1;
        while (left < right) {
            long center = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / center;
            }
            if (count >= N) { // 크거나 같은 최대.
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left - 1;
    }
}
