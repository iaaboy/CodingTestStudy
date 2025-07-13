package acmicpc11437;

import java.io.*;
import java.util.*;

/* LCA
 * https://www.acmicpc.net/problem/11437
 */

public class Main {
    static Vector<Vector<Integer>> tree;
    static int[] depth;
    static int kMax;
    static int[][] parent;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        depth = new int[N + 1];
        parent = new int[21][N + 1];
        visited = new boolean[N + 1];
        tree = new Vector<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            tree.add(new Vector<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }

        int temp = 1;
        kMax = 0;
        while (temp <= N) {
            temp <<= 1;
            kMax++;
        }

        BFS(1);

        for (int k = 1; k <= kMax; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = executeLCA(a, b);
            sb.append(lca).append("\n");
        }
        System.out.print(sb);
    }

    private static int executeLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        //깊이 맞추기
        for (int k = kMax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                b = parent[k][b];
            }
        }

        //공통조상 찾기
        for (int k = kMax; k >= 0; k--) {
            if (parent[k][b] != parent[k][a]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }
        return lca;
    }

    private static void BFS(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!q.isEmpty()) {
            int now_node = q.poll();
            for (Integer next : tree.get(now_node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[0][next] = now_node;
                    depth[next] = level;
                }
            }

            count++;
            if (count == now_size) {
                count = 0;
                now_size = q.size();
                level++;
            }
        }
    }
}
