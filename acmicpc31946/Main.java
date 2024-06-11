package acmicpc31946;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int X;
    static boolean isArrived = false;
    static boolean[][] myBoard;

    /*
5
5
1 0 1 1 1
1 0 1 0 1
1 0 1 0 1
1 0 1 0 1
1 1 1 0 1
1
2
3
1 0 0
0 0 1
3
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        myBoard = new boolean[N][M];
        int start = 0;
        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                if (i == 0 && j == 0) {
                    start = Integer.parseInt(st.nextToken());
                    myBoard[j][i] = true;
                } else
                    myBoard[j][i] = start == Integer.parseInt(st.nextToken());
            }
        }
        int[][] visited = new int[N][M];
        X = Integer.parseInt(bf.readLine());
        visited[0][0] = 1;
        myBoard[0][0] = false;
        if (myBoard[N - 1][M - 1])
            visitNext(visited, 0, 0, 2);
        System.out.println(isArrived ? "ALIVE" : "DEAD");
    }

    public static void visitNext(int[][] visited, int n, int m, int depth) {
        // System.out.println("visit: " + n + "," + m);
        if (n == N - 1 && m == M - 1) {
            isArrived = true;
            // System.out.println("arrvied");
            // for (int i = 0; i < visited.length; i++) {
            //     System.out.println(Arrays.toString(visited[i]));
            // }
            return;
        }
        if (isArrived) {
            return;
        }
        for (int j = 0; j <= X; j++) {
            for (int i = 0; i <= X; i++) {
                if (i + j > X)
                    break;
                int nextN = n + i;
                int nextM = m + j;
                if (nextM < 0 || nextN < 0 || nextN >= N || nextM >= M || i == 0 && j == 0)
                    continue;
                if (/* visited[nextN][nextM] == 0 && */ myBoard[nextN][nextM]) {
                    // visited[nextN][nextM] = depth;
                    myBoard[nextN][nextM] = false;
                    visitNext(visited, nextN, nextM, depth + 1);
                    myBoard[nextN][nextM] = true;
                    // visited[nextN][nextM] = 0;
                }
            }
        }
        for (int j = 0; j <= X; j++) {
            for (int i = 0; i <= X; i++) {
                if (i + j > X)
                    break;
                int nextN = n - i;
                int nextM = m - j;
                if (nextM < 0 || nextN < 0 || nextN >= N || nextM >= M || i == 0 && j == 0)
                    continue;
                if (/* visited[nextN][nextM] == 0 && */ myBoard[nextN][nextM]) {
                    // visited[nextN][nextM] = depth;
                    myBoard[nextN][nextM] = false;
                    visitNext(visited, nextN, nextM, depth + 1);
                    myBoard[nextN][nextM] = true;
                    // visited[nextN][nextM] = 0;
                }
            }
        }
    }
}
