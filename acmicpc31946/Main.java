package acmicpc31946;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static boolean isArrvied = false;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        arr = new int[N][M];
        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] visited = new int[N][M];
        X = Integer.parseInt(bf.readLine());
        visited[0][0] = 1;
        if (arr[N - 1][M - 1] != 1 && arr[0][0] != 1)
            visitNext(visited, 0, 0, 2);
        System.out.println(isArrvied ? "ALIVE" : "DEAD");
    }

    public static void visitNext(int[][] visited, int n, int m, int depth) {
        // System.out.println("visit: " + n + "," + m);
        if (n == N - 1 && m == M - 1) {
            isArrvied = true;
            // System.out.println("arrvied");
            // for (int i = 0; i < visited.length; i++) {
            // System.out.println(Arrays.toString(visited[i]));
            // }
            return;
        }
        if (isArrvied) {
            return;
        }
        for (int j = 0; j <= X; j++) {
            for (int i = 0; i <= X; i++) {
                if (i + j > X)
                    break;
                int nextN = n + i;
                int nextM = m + j;
                if (nextM < 0 || nextN < 0 || nextN >= N || nextM >= M)
                    continue;
                if (visited[nextN][nextM] == 0 && arr[nextN][nextM] != 1) {
                    visited[nextN][nextM] = depth;
                    visitNext(visited, nextN, nextM, depth + 1);
                    visited[nextN][nextM] = 0;
                }
            }
        }
    }
}
