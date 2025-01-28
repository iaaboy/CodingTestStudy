package acmicpc15652;

import java.io.*;
import java.util.*;

/* N과 M (4)
 * https://www.acmicpc.net/problem/15652
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        dfs(arr, 1, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(int arr[], int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(arr, i, depth + 1);
        }
    }
}
