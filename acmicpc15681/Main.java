package acmicpc15681;

import java.io.*;
import java.util.*;

/* 트리와 쿼리
 * https://www.acmicpc.net/problem/15681
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Vertex[] v = new Vertex[N + 1];
        for (int i = 1; i < v.length; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            v[p].nodes.add(c);
            v[c].nodes.add(p);
        }
        v[R].counted = true;
        v[R].childCount = getCount(v, R);
        // System.out.println(Arrays.toString(v));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(bf.readLine());
            sb.append(v[q].childCount).append("\n");
        }
        System.out.print(sb);
    }

    private static int getCount(Vertex[] v, int n) {
        if (v[n].childCount != 0) {
            return v[n].childCount;
        }

        int nCount = 1;
        for (Integer c : v[n].nodes) {
            if (v[c].counted) {
                continue;
            }
            v[c].counted = true;
            nCount += getCount(v, c);
        }
        // System.out.println(n + ":" + nCount);
        v[n].childCount = nCount;
        return nCount;
    }

    static class Vertex {
        int childCount = 0;
        boolean counted = false;
        ArrayList<Integer> nodes = new ArrayList<>();
        @Override
        public String toString() {
            return childCount + ":" + nodes;
        }
    }
}
