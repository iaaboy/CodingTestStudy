package acmicpc16931;

import java.io.*;
import java.util.*;

/* 겉넓이 구하기
 * https://www.acmicpc.net/problem/16931
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int space = 0;
        for (int i = 1; i < N + 2; i++) {
            for (int j = 1; j < M + 2; j++) {
                space += Math.abs(arr[i][j] - arr[i][j - 1]);
                space += Math.abs(arr[i][j] - arr[i - 1][j]);
            }
        }
        space += 2 * N * M;
        System.out.println(space);
    }
}
