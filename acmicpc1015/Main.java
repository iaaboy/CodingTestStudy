package acmicpc1015;

import java.io.*;
import java.util.*;

/* 수열 정렬
 * https://www.acmicpc.net/problem/1015
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] index = new int[N + 1];
        int[] arr = new int[N + 1];
        Arrays.fill(index, -1);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        arr[N] = -1;
        int maxIdx = N;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (arr[j] >= arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            index[maxIdx] = i;
            arr[maxIdx] = -1;
            maxIdx = N;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) {
            sb.append(index[j]).append(" ");
        }
        System.out.println(sb);
    }
}
