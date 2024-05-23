package acmicpc2738;

import java.io.*;
import java.util.*;

/* 행렬 덧셈
 * https://www.acmicpc.net/problem/2738
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // Y
        int M = Integer.parseInt(st.nextToken()); // X

        int[][] arr = new int[N][M];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}