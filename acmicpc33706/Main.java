package acmicpc33706;

import java.io.*;
import java.util.*;

/* 오름차순 최단 경로
 * https://www.acmicpc.net/problem/33706
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int to = Integer.parseInt(st.nextToken());
            visited[to] = true;
        }

        for (int i = 2; i <= N; i++) {
            if (!visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}