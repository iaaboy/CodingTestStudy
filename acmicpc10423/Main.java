package acmicpc10423;

import java.io.*;
import java.util.*;

/* 전기가 부족해
 * https://www.acmicpc.net/problem/10423
최소 스패닝 트리
grouping 하되, 발전소 두개를 한 그룹에 넣지 않음.
 */

public class Main {
    static int[] ids;
    static boolean[] powerPlant;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        powerPlant = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            powerPlant[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        Node[] n = new Node[M];
        Integer[] nodeIndex = new Integer[M];
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            n[i] = new Node(from, to, cost);
            nodeIndex[i] = i;
        }

        Arrays.sort(nodeIndex, (a, b) -> n[a].cost - n[b].cost);
        // for (int i = 0; i < nodeIndex.length; i++) {
        // System.out.print(n[nodeIndex[i]].cost + " ");
        // }
        // System.out.println();

        long sum = 0;
        for (int i = 0; i < nodeIndex.length; i++) {
            int from = n[nodeIndex[i]].from;
            int to = n[nodeIndex[i]].to;
            int rootFrom = getUnion(from);
            int rootTo = getUnion(to);
            if (rootFrom != rootTo && !(powerPlant[rootFrom] && powerPlant[rootTo])) {
                sum += n[nodeIndex[i]].cost;
                // System.out.println("union" + (from + 1) + "," + (to + 1) + ":" +
                // n[nodeIndex[i]].cost);
                setUnion(from, to);
                if (powerPlant[rootFrom]) {
                    powerPlant[rootTo] = true;
                }
                if (powerPlant[rootTo]) {
                    powerPlant[rootFrom] = true;
                }

            }
        }
        sb.append(sum).append("\n");
        System.out.print(sb);
        // System.out.println(Arrays.toString(powerPlant));
        // System.out.println(Arrays.toString(ids));
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
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
