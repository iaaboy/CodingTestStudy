package acmicpc20010;

import java.io.*;
import java.util.*;

/*
 * 풀이중
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ids = new int[V];
        Vertex[] v = new Vertex[V];
        for (int i = 0; i < V; i++) {
            ids[i] = i;
            v[i] = new Vertex();
        }
        Node[] n = new Node[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            n[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(n, (a, b) -> a.c - b.c);

        int totalCost = 0;
        int handledCount = 0;
        for (int i = 0; i < E; i++) {
            int s = n[i].s;
            int e = n[i].e;
            if (getUnion(s) != getUnion(e)) {
                System.out.println(s + " - " + e + " (" + n[i].c + ")");
                v[s].son.add(e);
                v[e].son.add(s);
                totalCost += n[i].c;
                if (++handledCount == V - 1) {
                    System.out.println(totalCost);
                    System.out.println(Arrays.toString(v));
                    return;
                }
                setUnion(s, e);
            }
        }
        System.out.println("fiish");
    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
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

    static class Vertex {
        ArrayList<Integer> son = new ArrayList<>();

        @Override
        public String toString() {
            return son.toString();
        }
    }
}
