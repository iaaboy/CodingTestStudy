package acmicpc30960;

import java.io.*;
import java.util.*;

/* 조별 과제
 * https://www.acmicpc.net/problem/30960
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
        int[] diff2 = new int[N];
        int[] diff3 = new int[N];
        for (int i = 0; i < N - 1; i++) {
            diff2[i] = arr[i + 1] - arr[i];
            if (i == N - 2)
                continue;
            diff3[i] = arr[i + 2] - arr[i];
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(diff2));
        // System.out.println(Arrays.toString(diff3));

        // 32222 합
        int sum = diff3[0];
        for (int i = 3; i < N; i += 2) {
            sum += diff2[i];
        }

        int sumMax = sum;
        // 23222, 22322, 22232, 22223 합 중 max
        for (int i = 0; i < N - 4; i += 2) {
            sum -= diff3[i];
            sum -= diff2[i + 3];
            sum += diff2[i];
            sum += diff3[i + 2];
            sumMax = Math.min(sumMax, sum);
        }

        System.out.println(sumMax);
    }
}
