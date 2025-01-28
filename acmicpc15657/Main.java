package acmicpc15657;

import java.io.*;
import java.util.*;

/* N과 M (8)
 * https://www.acmicpc.net/problem/15657
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

        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] index = new int[M];
        dfs(index, 0, 0);
        System.out.print(sb.toString());
    }

    public static void dfs(int index[], int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[index[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {
            index[depth] = i;
            dfs(index, i, depth + 1);
        }
    }
}
