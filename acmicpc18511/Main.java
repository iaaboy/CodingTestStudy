package acmicpc18511;

import java.io.*;
import java.util.*;

/* 큰 수 구성하기
 * https://www.acmicpc.net/problem/18511
 */

public class Main {
    static int N, K, result;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Integer[K];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        findMax(0);
        System.out.println(result);
    }

    private static void findMax(int current) {
        if (N < current)
            return;
        result = Math.max(result, current);

        for (int i = 0; i < K; i++) {
            findMax((current * 10) + arr[i]);
        }
    }
}
