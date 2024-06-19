package acmicpc22856;

import java.io.*;
import java.util.*;

/*
6
1 2 3
2 4 5
3 6 -1
4 -1 -1
5 -1 -1
6 -1 -1
*/

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Vertex[] v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex(0, 0, 0);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            v[me].left = left;
            v[me].right = right;
            if (left > 0)
                v[left].parent = me;
            if (right > 0)
                v[right].parent = me;
        }

        visitNext(v, 1, false);

        System.out.println();

        // System.out.println(Arrays.toString(p));
        // System.out.println(Arrays.toString(l));
        // System.out.println(Arrays.toString(r));

    }

    private static void visitNext(Vertex[] v, int c, boolean needBack) {
        System.out.println("moved" + c);
        if (v[c].left > 0) {
            int next = v[c].left;
            v[c].left = 0;
            visitNext(v, next, true);
        }
        System.out.println(c);
        // check Me
        if (v[c].right > 0) {
            int next = v[c].right;
            v[c].right = 0;
            visitNext(v, next, false);
        }
        // if (needBack) {
        //     visitNext(v, v[c].parent, false);
        // }
    }

    static class Vertex {
        int left;
        int right;
        int parent;

        public Vertex(int left, int right, int parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
