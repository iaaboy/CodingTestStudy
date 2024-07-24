package acmicpc13900;

import java.io.*;
import java.util.*;

/* 순서쌍의 곱의 합
 * https://www.acmicpc.net/problem/13900
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] arr = new long[N];
        long[] acc = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        acc[0] = arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            acc[i] = acc[i - 1] + arr[i];
        }
        long sum = 0;
        for (int i = 1; i < N; i++) {
            sum += acc[i - 1] * arr[i];
        }
        System.out.println(sum);
    }
}