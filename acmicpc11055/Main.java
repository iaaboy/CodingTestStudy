package acmicpc11055;

import java.io.*;
import java.util.*;

/* 가장 큰 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11055
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            sum[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j] && sum[i] < sum[j] + arr[i]) {
                    sum[i] = sum[j] + arr[i];
                }
            }
        }

        // System.out.println(Arrays.toString(sum));
        int max = 0;
        for (int i = 0; i < sum.length; i++) {
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
    }
}