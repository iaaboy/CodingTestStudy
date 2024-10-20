package prog43162;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int n = 3;

        Solution mSol = new Solution();

        System.out.println(mSol.solution(n, computers));
    }
}

class Solution {
    int[] parent;

    public int solution(int n, int[][] computers) {
        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (i != k && computers[i][k] != 0) {
                    // i와 k를 union
                    union(i, k);
                    // System.out.println(Arrays.toString(parent));
                }
            }
        }

        Set<Integer> root = new HashSet<>();
        for (int i = 0; i < n; i++) {
            root.add(find(i));
        }

        return root.size();
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            // 각 노드의 부모 노드를 찾아 올라간다.
            return find(parent[x]);
        }
    }

    private void union(int a, int b) {
        // System.out.println("a: " + a + ", b: " + b);
        int aRoot = find(a);
        int bRoot = find(b);

        parent[aRoot] = bRoot;
    }
}