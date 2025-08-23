package acmicpc23317;

import java.io.*;
import java.util.*;

/* 구슬 굴리기
 * https://www.acmicpc.net/problem/23317
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N + 1][N + 1];
        boolean[][] visit = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            visit[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        arr[0][0] = 1;
        for (int i = 0; i < N; i++) {
            boolean hasVisit = visit[i + 1][0];
            for (int j = 0; j <= i; j++) {
                arr[i + 1][j] += arr[i][j];
                arr[i + 1][j + 1] += arr[i][j];
                if (visit[i + 1][j + 1]) {
                    hasVisit = true;
                }
            }
            if (hasVisit) {
                for (int j = 0; j <= i + 1; j++) {
                    if (!visit[i + 1][j]) {
                        arr[i + 1][j] = 0;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += arr[N - 1][i];
        }
        System.out.println(count);
        // for (int i = 0; i < N + 1; i++) {
        // for (int j = 0; j < N + 1; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
    }
}