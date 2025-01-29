package acmicpc1182;


import java.io.*;
import java.util.*;

/* 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            combination(index, visited, 0, i);
        }
        // System.out.print(sb);
        System.out.println(sumCount);
    }

    static int sumCount = 0;
    static void combination(int[] index, boolean[] visited, int at, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < index.length; i++) {
                if (visited[i]) {
                    // sb.append(arr[index[i]] + " ");
                    sum += arr[index[i]];
                }
            }
            // sb.append(" : " + sum + "\n");
            if (sum == S) {
                sumCount++;
            }
            return;
        }

        for (int i = at; i < index.length; i++) {
            visited[i] = true;
            combination(index, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }
}
