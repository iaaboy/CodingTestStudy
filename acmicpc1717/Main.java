package acmicpc1717;

import java.io.*;
import java.util.*;

/* 집합의 표현
 * https://www.acmicpc.net/problem/1717
 */

public class Main {
    static int[] g;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        g = new int[N + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                int rootB = getRoot(b);
                int rootA = getRoot(a);
                if (rootA > rootB) {
                    g[rootA] = rootB;
                } else {
                    g[rootB] = rootA;
                }

            } else {
                if (getRoot(a) == getRoot(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static int getRoot(int me) {
        int i = me;
        while (g[i] != i) {
            i = g[i];
        }
        if (me != i) { // key !!! Union find 의 while loop를 줄임
            g[me] = i;
        }
        return i;
    }
}