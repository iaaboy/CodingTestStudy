package acmicpc2559;

import java.io.*;
import java.util.*;

/* 수열
 * https://www.acmicpc.net/problem/2559
슬라이딩 위도우 형식으로 풀이
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int kSum = getKsum(arr, K);
        int sumMax = kSum;
        for (int i = 1; i < N - K + 1; i++) {
            kSum -= arr[i - 1];
            kSum += arr[i + K - 1];
            sumMax = Math.max(sumMax, kSum);
        }
        System.out.println(sumMax);
    }

    private static int getKsum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
