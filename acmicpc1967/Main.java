package acmicpc1967;

import java.io.*;
import java.util.*;

/* 트리의 지름
 * https://www.acmicpc.net/problem/1967
 */

public class Main {
    static int maxSum;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Vertex[] tree = new Vertex[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (tree[from] == null) {
                tree[from] = new Vertex(from, new ArrayList<>());
            }
            if (tree[to] == null) {
                tree[to] = new Vertex(to, new ArrayList<>());
            }
            tree[from].nodes.add(new Node(from, to, cost));
        }
        if (N != 1)
            traversal(tree, 1);
        System.out.println(maxSum);
    }

    private static void traversal(Vertex[] tree, int cur) {
        if (tree[cur].nodes.size() == 0) {
            tree[cur].max = 0;
            // System.out.println(cur + " end");
        } else {
            // System.out.println(cur + " s");
            for (Node node : tree[cur].nodes) {
                if (tree[node.to] != null) {
                    traversal(tree, node.to);
                }
            }

            // 가지고 있는 node 중 최대2개
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < tree[cur].nodes.size(); i++) {
                Node node = tree[cur].nodes.get(i);
                int nodeSum = node.cost + tree[node.to].max;
                tree[cur].max = Math.max(tree[cur].max, nodeSum);
                if (nodeSum >= sum1) {
                    sum2 = Math.max(sum2, sum1);
                    sum1 = nodeSum;
                } else {
                    sum2 = Math.max(sum2, nodeSum);
                }
            }
            maxSum = Math.max(maxSum, sum1 + sum2);
        }
    }

    static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Vertex {
        int parent;
        int max;
        ArrayList<Node> nodes = new ArrayList<>();

        public Vertex(int parent, ArrayList<Node> nodes) {
            this.parent = parent;
            this.nodes = nodes;
            max = -1;
        }
    }
}
