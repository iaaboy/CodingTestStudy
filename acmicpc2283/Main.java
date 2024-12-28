package acmicpc2283;

import java.io.*;
import java.util.*;

/* 구간 자르기
 * https://www.acmicpc.net/problem/2283
 */

public class Main {
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int M = 0;
        int[] arr = new int[1000000 + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start]++;
            arr[end]--;
            M = Math.max(M, Math.max(start, end));
        }
        int s = 0;
        for (int i = 0; i < M + 1; i++) {
            s += arr[i];
            arr[i] = s;
            if (i != 0) {
                arr[i] += arr[i - 1];
            }
        }

        findAnswerSequencial(arr, M, K);

        // printArr(arr, M + 1);
    }

    private static int getSum(int[] arr, int start, int end) {
        int st = start - 1;
        int ed = end - 1;
        if (ed < 0) {
            return 0;
        }
        if (st < 0) {
            return arr[ed];
        }
        return arr[ed] - arr[st];
    }

    private static void findAnswerSequencial(int[] arr, int m, int k) {
        for (int i = 0; i < m; i++) {
            int right = checkSum(arr, i, m);
            if (getSum(arr, i, right) == K) {
                System.out.println(i + " " + right);
                return;
            }
            ;
        }
        System.out.println("0 0");
    }

    private static int checkSum(int[] arr, int start, int m) {
        int left = start;
        int right = m;
        while (left < right) {
            int center = (left + right) / 2;
            int sum = getSum(arr, start, center);
            // System.out.println(start + "-" + center + " : " + sum);
            if (sum < K) {
                left = center + 1;
            } else {
                right = center;
            }
        }

        return right;
    }

    private static void printArr(int[] arr, int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
