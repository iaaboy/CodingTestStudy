package acmicpc4803;

import java.io.*;
import java.util.*;

/* 트리
 * https://www.acmicpc.net/problem/4803
 */

public class Main {
    static boolean[] visited;
    static Vertex[] v;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("acmicpc4803/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 0;
        v = new Vertex[500];
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            t++;

            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                v[i] = new Vertex();
            }
            visited = new boolean[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                v[from].nodes.add(to);
                v[to].nodes.add(from);
            }

            int treeCount = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    if (checkTree(i)) {
                        treeCount++;
                    }
                }
            }

            sb.append("Case ");
            if (treeCount == 0) {
                sb.append(t + ": No trees.\n");
            } else if (treeCount == 1) {
                sb.append(t + ": There is one tree.\n");
            } else {
                sb.append(t + ": A forest of ");
                sb.append(treeCount + " trees.\n");
            }

        }
        System.out.print(sb);
    }

    private static boolean checkTree(int r) {
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        int nodeCount = 0;
        int edgeCount = 0;

        while (!q.isEmpty()) {
            int c = q.poll();
            if (visited[c])
                continue;
            visited[c] = true;
            nodeCount++;

            for (Integer n : v[c].nodes) {
                edgeCount++;
                if (!visited[n]) {
                    q.add(n);
                }
            }
        }
        // dege / 2 .. 양방향
        // edge == node + 1
        return (edgeCount / 2) + 1 == nodeCount ? true : false;
    }

    static class Vertex {
        ArrayList<Integer> nodes = new ArrayList<>();
    }
}
