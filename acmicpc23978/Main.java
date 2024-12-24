package acmicpc23978;

import java.io.*;
import java.util.*;

/* 급상승
 * https://www.acmicpc.net/problem/23978
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        long[] arr = new long[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        arr[N] = arr[N - 1] + K;
        long left = 0;
        long right = 1500000000;
        while (left < right) {
            long center = (left + right) / 2;
            if (getTotal(arr, center) < K) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        System.out.println(right);
    }

    private static long getTotal(long[] arr, long k) {
        long total = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            long day = arr[i + 1] - arr[i];
            day = Math.min(day, k);
            long subTotal = getCount(k) - getCount(k - day);
            total += subTotal;
            // System.out.println(k + "," + day + " -> " + subTotal);
        }
        // System.out.println(k + ":" + total);
        return total;
    }

    private static long getCount(long k) {
        long sum = (k + 1) * (k / 2);
        if (k % 2 != 0) {
            sum += k / 2 + 1;
        }
        return sum;
    }
}
