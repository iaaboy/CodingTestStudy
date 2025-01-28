package acmicpc15656;

import java.io.*;
import java.util.*;

/* N과 M (7)
 * https://www.acmicpc.net/problem/15656
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] index = new int[M];
        dfs(index, 0);
        System.out.print(sb);
    }

    private static void dfs(int[] index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[index[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            index[depth] = i;
            dfs(index, depth + 1);
        }
    }
}
