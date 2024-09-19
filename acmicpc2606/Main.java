package acmicpc2606;

import java.io.*;
import java.util.*;

/* 바이러스
 * https://www.acmicpc.net/problem/2606
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Vertex[] v = new Vertex[N + 1];
        for (int i = 0; i < v.length; i++) {
            v[i] = new Vertex(new ArrayList<>());
        }
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            v[n1].nodes.add(n2);
            v[n2].nodes.add(n1);
        }
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        int result = traverse(v, visited, 1);
        if (result != 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(result);
        }
    }

    private static int traverse(Vertex[] v, boolean[] visited, int cur) {
        int result = 1;
        for (Integer n : v[cur].nodes) {
            if (!visited[n]) {
                visited[n] = true;
                result += traverse(v, visited, n);
            }
        }
        return result;
    }

    static class Vertex {
        ArrayList<Integer> nodes;

        public Vertex(ArrayList<Integer> nodes) {
            this.nodes = nodes;
        }
    }
}
