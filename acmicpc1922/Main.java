package acmicpc1922;

import java.io.*;
import java.util.*;

/* 네트워크 연결
 * https://www.acmicpc.net/problem/1922
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(bf.readLine());
        int E = Integer.parseInt(bf.readLine());
        ids = new int[V + 1];
        for (int i = 1; i < ids.length; i++) {
            ids[i] = i;
        }
        Node[] n = new Node[E];
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
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
                totalCost += n[i].c;
                if (++handledCount == V - 1) {
                    System.out.println(totalCost);
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
}
