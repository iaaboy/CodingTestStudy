package acmicpc15650;

import java.io.*;
import java.util.*;

/* N과 M (2)
 * https://www.acmicpc.net/problem/15650
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        combination(arr, visited, 0, M);
        System.out.print(sb);
    }

    static void combination(int[] arr, boolean[] visited, int m, int r) {
        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = m; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
