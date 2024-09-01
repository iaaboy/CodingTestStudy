package acmicpc2805;

import java.io.*;
import java.util.*;

/* 나무 자르기
 * https://www.acmicpc.net/problem/2805
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int maxLength = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, arr[i]);
        }
        long result = maxHeight(arr, M, maxLength);
        System.out.println(result);
    }

    private static long maxHeight(int[] arr, long M, long maxLength) {
        // N개를 만들 수 있는 최대 길이
        long left = 1;
        long right = maxLength + 1;
        while (left < right) {
            long center = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += Math.max(0, arr[i] - center);
            }
            if (count >= M) { // 크거나 같은 최대.
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left - 1;
    }
}
