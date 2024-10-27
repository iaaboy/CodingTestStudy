package acmicpc11660;

import java.io.*;
import java.util.*;

/* 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long arr[][] = new long[N + 1][N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            long smallSum = 0;
            for (int j = 1; j < N + 1; j++) {
                long num = Long.parseLong(st.nextToken());
                smallSum += num;
                arr[i][j] = smallSum + arr[i - 1][j];
            }
        }
        // for (int i = 0; i < arr.length; i++) {
        // sb.append(Arrays.toString(arr[i])).append("\n");
        // }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            long sum = arr[y2][x2] - arr[y2][x1] - arr[y1][x2] + arr[y1][x1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}