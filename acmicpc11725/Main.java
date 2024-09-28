package acmicpc11725;

import java.io.*;
import java.util.*;

/* 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Vertex[] v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a].son.add(b);
            v[b].son.add(a);
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        visit(v, visited, 0, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < v.length; i++) {
            sb.append(v[i].parent + "\n");
            // System.out.println(i + ":" + v[i]);
        }
        System.out.print(sb);
    }

    private static void visit(Vertex[] v, boolean[] visited, int parent, int current) {
        v[current].parent = parent;
        for (Integer s : v[current].son) {
            if (!visited[s]) {
                visited[s] = true;
                visit(v, visited, current, s);
            }
        }
    }

    static class Vertex {
        ArrayList<Integer> son = new ArrayList<>();
        int parent = -1;

        @Override
        public String toString() {
            return parent + ", " + son;
        }
    }
}
