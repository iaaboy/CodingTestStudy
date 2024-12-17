package acmicpc6236;

import java.io.*;
import java.util.*;

/* 용돈 관리
 * https://www.acmicpc.net/problem/6236
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        Long max = 0L;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(bf.readLine());
            max = Math.max(arr[i], max);
        }

        long start = max;
        long end = 10000000000L; // TODO Max설정
        long mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (getCount(arr, mid) > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }

    private static long getCount(long[] arr, long bank) {
        long count = 0;
        long remained = 0;
        for (int i = 0; i < arr.length; i++) {
            long money = arr[i];
            if (remained >= money) {
                remained -= money;
            } else {
                long bankCount = (money / bank);
                bankCount += money % bank > 0 ? 1 : 0;
                count += bankCount;
                remained = bank * bankCount;
                remained -= money;
            }
            // System.out.pr longln(arr[i] + ":" + remained + "," + count);
        }
        return count;
    }
}
