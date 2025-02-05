package acmicpc15666;

import java.io.*;
import java.util.*;

/* N과 M (12)
 * https://www.acmicpc.net/problem/15666
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static ArrayList<Integer> arrSet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            if (!arrSet.contains(num)) {
                arrSet.add(num);
            }
        }

        arrSet.sort(null);

        int[] arr = new int[M];
        dfs(arr, 0, 0);

        System.out.print(sb.toString());
    }

    public static void dfs(int[] arr, int at,  int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < arrSet.size(); i++) {
            arr[depth] = arrSet.get(i);
            dfs(arr, i, depth + 1);
        }
    }
}