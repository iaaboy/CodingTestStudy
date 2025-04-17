package acmicpc2533;

import java.io.*;
import java.util.*;

/* 사회망 서비스(SNS)
 * https://www.acmicpc.net/problem/2533
재귀 + dp
dp[n][1] : 내가 얼리 어답터
dp[n][0] : 내가 일반인

dp[n][1] = 자식노드들의 (얼리 / 일반 중 작은값) 을 모두 더한값 + 1(나자신)
dp[n][0] = 자식노드중 얼리의 값을 모두 더한값 .. 내가 얼리이니까 내 자식은 모두 일반.
bottom에서부터 값을 채워 올라간다.
 */

public class Main {
    static Vertex[] v;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        v = new Vertex[N];
        for (int i = 0; i < N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int me = Integer.parseInt(st.nextToken()) - 1;
            int you = Integer.parseInt(st.nextToken()) - 1;
            v[me].trees.add(new Node(you, i));
            v[you].trees.add(new Node(me, i));
        }
        dp = new int[N][2]; // 1. i am early adapter 0. i am normal
        visited = new boolean[N];

        int[] result = getSubSet(0);
        System.out.println(Math.min(result[0], result[1]));
    }

    private static int[] getSubSet(Integer me) {
        if (v[me].visited) {
        } else {
            int sum1 = 0;
            int sum0 = 0;
            for (Node son : v[me].trees) {
                if (!visited[son.id]) {
                    visited[son.id] = true;
                    int[] subResult = getSubSet(son.to);
                    sum1 += subResult[1];
                    sum0 += Math.min(subResult[0], subResult[1]);
                }
            }

            dp[me][0] = sum1;
            dp[me][1] = sum0 + 1;
            v[me].visited = true;
        }
        return dp[me];
    }

    static class Vertex {
        boolean visited = false;
        ArrayList<Node> trees = new ArrayList<>();
    }

    static class Node {
        int to;
        int id;

        public Node(int to, int id) {
            this.to = to;
            this.id = id;
        }
    }
}
