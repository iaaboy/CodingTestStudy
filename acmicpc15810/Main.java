package acmicpc15810;

import java.io.*;
import java.util.*;

/* 풍선 공장
 * https://www.acmicpc.net/problem/15810
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long minLength = Integer.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            minLength = Math.min(minLength, arr[i]);
        }
        long result = minTime(arr, (long)N, (long)minLength * (long)N);
        System.out.println(result);
    }

    private static long minTime(long[] arr, long N, long minLength) {
        // N개를 만들 수 있는 최소 시간
        long left = 0;
        long right = minLength * 2;
        while (left < right) {
            long center = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += center / arr[i];
            }
            if (count < N) { // 크거나 같은 최소
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right;
    }
}
