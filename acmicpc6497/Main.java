package acmicpc6497;

import java.io.*;
import java.util.*;

/* 전력난
 * https://www.acmicpc.net/problem/6497
최소 신장트리 문제
 */

public class Main {
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                System.out.print(sb);
                break;
            }
            Node[] n = new Node[M];
            Integer[] nodeIndex = new Integer[M];
            ids = new int[N];
            for (int i = 0; i < N; i++) {
                ids[i] = i;
            }
            long costSum = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                n[i] = new Node(from, to, cost);
                costSum += cost;
                nodeIndex[i] = i;
            }

            Arrays.sort(nodeIndex, (a, b) -> n[a].cost - n[b].cost);

            long sum = 0;
            for (int i = 0; i < nodeIndex.length; i++) {
                int from = n[nodeIndex[i]].from;
                int to = n[nodeIndex[i]].to;
                if (getUnion(from) != getUnion(to)) {
                    sum += n[nodeIndex[i]].cost;
                    setUnion(from, to);
                }
            }
            sb.append(costSum - sum).append("\n");
        }

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
