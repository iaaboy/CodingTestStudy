package acmicpc23827;

import java.io.*;
import java.util.*;

/* 수열 (Easy)
 * https://www.acmicpc.net/problem/23827
 */

public class Main {
    static long MOD = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        long[] sumArr = new long[N];
        sumArr[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sumArr[i] = arr[i] + sumArr[i - 1];
            sumArr[i] = sumArr[i] % MOD;
        }
        // System.out.println(Arrays.toString(sumArr));
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += arr[i] * getSum(sumArr, i + 1, N - 1);
            sum %= MOD;
        }
        System.out.println(sum);
    }

    private static long getSum(long[] sumArr, int i, int j) {
        return (sumArr[j] - sumArr[i - 1]) % MOD;
    }
}
