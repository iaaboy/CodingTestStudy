package acmicpc24444;

import java.io.*;
import java.util.*;

/* 알고리즘 수업 - 너비 우선 탐색 1
 * https://www.acmicpc.net/problem/24444
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int [] visited = new int[N + 1];
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        nodes.forEach((a -> a.sort(null)));
        Queue<Integer> q = new ArrayDeque<>();
        q.add(R);
        
        int index = 1;
        visited[R] = index++;
        while (!q.isEmpty()) {
            Integer c = q.poll();
            for (Integer n : nodes.get(c)) {
                if (visited[n] == 0) {
                    visited[n] = index++;
                    q.add(n);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v < visited.length; v++) {
            sb.append(visited[v]).append("\n");
        }
        System.out.print(sb);
    }
}
