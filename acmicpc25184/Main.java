package acmicpc25184;

import java.io.*;
import java.util.ArrayDeque;

/* 동가수열 구하기
https://www.acmicpc.net/problem/25184
해 구성하기 .. 애드혹..
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        int index = N / 2;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                arr[i] = index;
            } else {
                arr[i] = index + N / 2;
                index--;
            }
        }
        if (N % 2 == 1) {
            arr[N - 1] = N;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

        // for (int i = 1; i < arr.length; i++) {
        // System.out.print(arr[i] - arr[i-1] + " ");
        // }
        // System.out.println();
    }
}
