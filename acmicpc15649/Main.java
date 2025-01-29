package acmicpc15649;

import java.io.*;
import java.util.*;

/* N과 M (1)
 * https://www.acmicpc.net/problem/15649
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] index = new int[M];
        boolean[] visited = new boolean[N];
        dfs(visited, index, 0);
        System.out.print(sb);
    }

    private static void dfs(boolean [] visited , int[] index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(index[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            index[depth] = i + 1;
            dfs(visited, index, depth + 1);
            visited[i] = false;
        }
    }
}