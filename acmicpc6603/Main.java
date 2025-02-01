package acmicpc6603;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        while (N != 0) {
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            boolean[] visited = new boolean[N];
            dfs(arr, visited, 0, 0);

            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int arr[], boolean visited[], int at, int depth) {
        if (depth == 6) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append( " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, visited, i, depth + 1);
                visited[i] = false;
            }
        }
    }
}