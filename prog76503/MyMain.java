package prog76503;

import java.util.*;

/* 모두 0으로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76503
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] a = { { -3, 2, -2, 1, 2 }, { 0, 1, 0 }, { -1, 0, 1, 1, -1 } };
        int[][][] edges = { { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } },
                { { 0, 1 }, { 1, 2 } },
                { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 4 } } };
        Solution mSol = new Solution();
        for (int i = 2; i < 3; i++) {
            System.out.println(mSol.solution(a[i], edges[i]));
        }
    }
}

class Solution {
    int n;

    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        this.n = a.length;
        long[] weight = new long[n];
        List<Integer>[] nodes = new ArrayList[n];

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            weight[i] = a[i];
            nodes[i] = new ArrayList<Integer>();
        }
        if (sum != 0)
            return -1;

        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0]].add(edges[i][1]);
            nodes[edges[i][1]].add(edges[i][0]);
        }

        return dfs(nodes, weight, 0, -1);
    }

    private static long dfs(List<Integer>[] nodes, long[] weight, int me, int parent) {
        long result = 0;
        for (int i = 0; i < nodes[me].size(); i++) {
            int next = nodes[me].get(i);
            if (next != parent) {
                result += dfs(nodes, weight, next, me);
            }
        }
        if (parent != -1) {
            weight[parent] += weight[me];
        }
        return result + Math.abs(weight[me]);
    }
}