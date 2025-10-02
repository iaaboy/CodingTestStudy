package acmicpc1325;

import java.io.*;
import java.util.*;

/* 효율적인 해킹
 * https://www.acmicpc.net/problem/1325
 */

public class Main {
    static Vertex[] v;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        v = new Vertex[N];
        for (int i = 0; i < N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            v[from].node.add(to);
        }

        // int count = 0;
        
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            addCount(i);
        }
        System.out.println(Arrays.toString(v));

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            maxCount = Math.max(maxCount, v[i].count);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (v[i].count == maxCount) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void addCount(int c) {
        v[c].count++;
        for (Integer node : v[c].node) {
            if (!visited[node]) {
                addCount(node);
            }
        }
    }

    static class Vertex {
        int count = 0;
        ArrayList<Integer> node = new ArrayList<>();

        @Override
        public String toString() {
            return count + "," + node;
        }
    }
}
