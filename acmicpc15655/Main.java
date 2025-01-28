package acmicpc15655;

import java.io.*;
import java.util.*;

/* N과 M (6)
 * https://www.acmicpc.net/problem/15655
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] index = new int[N];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        combination(index, visited, 0, M);
        System.out.print(sb);
    }

    static void combination(int[] index, boolean[] visited, int m, int r) {
        if (r == 0) {
            for (int i = 0; i < index.length; i++) {
                if (visited[i]) {
                    sb.append(arr[index[i]] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = m; i < index.length; i++) {
            visited[i] = true;
            combination(index, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
