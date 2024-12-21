package acmicpc7795;

import java.io.*;
import java.util.*;

/* 먹을 것인가 먹힐 것인가
 * https://www.acmicpc.net/problem/7795
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arrA = new int[N];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            int aWin = 0;
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                int bIdx = upperBound(arrA, Integer.parseInt(st.nextToken()));
                aWin += N - bIdx;
            }
            sb.append(aWin + "\n");
        }
        System.out.print(sb);
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
}
