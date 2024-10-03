package acmicpc1647;

import java.io.*;
import java.util.*;

/* 도시 분할 계획
 * https://www.acmicpc.net/problem/1647
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ids = new int[N + 1];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }

        Node[] nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(s, e, c);
        }
        long totalCost = 0;
        Arrays.sort(nodes, (a, b) -> a.c - b.c);
        if (N == 2) {
            System.out.println(0);
        }
        for (int i = 0; i < M; i++) {
            Node cNode = nodes[i];
            if (getRoot(cNode.s) == getRoot(cNode.e)) {
                continue;
            }
            // System.out
            // .println(
            // "handle: " + cNode.s + ", " + cNode.e + " : " + getRoot(cNode.s) + ", " +
            // getRoot(cNode.e));
            totalCost += cNode.c;
            if (--N == 2) {
                System.out.println(totalCost);
                return;
            }
            setRoot(cNode.s, cNode.e);
            // System.out.println(
            // "combined: " + getRoot(cNode.s) + ", " + getRoot(cNode.e));
        }
    }

    private static void setRoot(int s, int e) {
        int a = getRoot(s);
        int b = getRoot(e);
        ids[a] = a < b ? a : b;
        ids[b] = a < b ? a : b;
    }

    private static int getRoot(int id) {
        int r = id;
        while (r != ids[r]) {
            r = ids[r];
        }
        return r;
    }

    static class Node {
        int s;
        int e;
        int c;

        public Node(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}