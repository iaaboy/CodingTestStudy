package acmicpc1260;

import java.io.*;
import java.util.*;

/* DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */

public class Main {
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes.get(s).add(e);
            nodes.get(e).add(s);
        }
        for (int i = 1; i <= N; i++) {
            nodes.get(i).sort(null);
            // System.out.println(nodes.get(i));
        }
        boolean[] visited = new boolean[N + 1];

        dfs(visited, V);
        visited = new boolean[N + 1];
        bfs(visited, V);

    }

    private static void bfs(boolean[] visited, int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            System.out.print(cur + " ");
            for (Integer child : nodes.get(cur)) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                q.add(child);
            }
        }
        System.out.println();
    }

    private static void dfs(boolean[] visited, int v) {
        Stack<Integer> q = new Stack<>();
        q.add(v);
        while (!q.isEmpty()) {
            Integer cur = q.pop();
            if (visited[cur]) {
                continue;
            }
            System.out.print(cur + " ");
            visited[cur] = true;
            for (int i = nodes.get(cur).size() -1; i >= 0; i--) {
                int child = nodes.get(cur).get(i);
                if (visited[child]) {
                    continue;
                }
                q.add(child);
            }
            // for (Integer child : ) {
            //     if (visited[child]) {
            //         continue;
            //     }
            //     q.add(child);
            // }
        }
        System.out.println();
    }
}
