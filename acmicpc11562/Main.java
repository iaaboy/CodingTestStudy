package acmicpc11562;
import java.io.*;
import java.util.*;

/* 백양로 브레이크
 * https://www.acmicpc.net/problem/11562
 */

public class Main {
    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            if (b == 0) { // 한방
                arr[u][v] = 0;
                arr[v][u] = 1;
            } else { // 양방향
                arr[u][v] = 0;
                arr[v][u] = 0;
            }
        }

        printAll(N, arr);

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
                }
            }
        }

        printAll(N, arr);

        int K = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(arr[s][e]).append("\n");
        }
        System.out.print(sb);
    }

    private static void printAll(int N, int[][] arr) {
        // for (int i = 0; i < N; i++) {
        // System.out.println();
        // for (int j = 0; j < N; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // }
        // System.out.println();
    }
}
