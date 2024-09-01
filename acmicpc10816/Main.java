package acmicpc10816;

import java.io.*;
import java.util.*;

/* 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int count = getNumCount(arr, Integer.parseInt(st.nextToken()));
            sb.append(count + " ");
        }
        System.out.println(sb);
    }

    private static int getNumCount(int[] arr, int key) {
        int ub = upperBound(arr, key);
        int lb = lowerBound(arr, key);

        return ub - lb;
    }

    private static int upperBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] <= key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left;
    }

    private static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right;
    }
}