package prog72413;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 6, 7, 6 };
        int[] s = { 4, 3, 4 };
        int[] a = { 6, 4, 5 };
        int[] b = { 2, 1, 6 };
        int[][][] fares = {
                { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 },
                        { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                        { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } },
                { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } },
                { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 },
                        { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 }, { 4, 3, 9 } }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println("ans: " + mSol.solution(n[i], s[i], a[i], b[i], fares[i]));
        }
    }
}

class Solution {
    int a, b;
    int[][] minCost;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        Vertex[] ver = new Vertex[n + 1];
        boolean[] visited = new boolean[n + 1]; // n은 1부터..
        minCost = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        this.a = a;
        this.b = b;
        for (int i = 0; i < n + 1; i++) {
            ver[i] = new Vertex(i);
        }

        for (int[] fare : fares) {
            ver[fare[0]].nodes.add(new Node(fare[1], fare[2]));
            ver[fare[1]].nodes.add(new Node(fare[0], fare[2]));
        }

        visited[s] = true;
        PriorityQueue<Next> pQ = new PriorityQueue<>((me, you) -> me.cost - you.cost);
        pQ.add(new Next(s, s, 0, visited));

        while (!pQ.isEmpty()) {
            Next current = pQ.poll();
            printNext("handle", current);
            if (current.nowA == a && current.nowB == b) {
                return current.cost;
            }

            if (current.nowA == current.nowB) { // 다음도 합승
                for (Node nd : ver[current.nowA].nodes) {
                    if (!current.visited[nd.to] && (minCost[nd.to][nd.to] > nd.cost + current.cost)) {
                        current.visited[nd.to] = true;
                        minCost[nd.to][nd.to] = nd.cost + current.cost;
                        Next nst1 = new Next(nd.to, nd.to, nd.cost + current.cost, current.visited.clone());
                        printNext("addNext", nst1);
                        pQ.add(nst1);
                        current.visited[nd.to] = false;
                    }
                }
                for (Node nd : ver[current.nowA].nodes) {
                    if (!current.visited[nd.to]) {
                        current.visited[nd.to] = true;
                        if (minCost[current.nowA][nd.to] > nd.cost + current.cost) {
                            minCost[current.nowA][nd.to] = nd.cost + current.cost;
                            Next nst = new Next(current.nowA, nd.to, nd.cost + current.cost, current.visited.clone());
                            printNext("addNext", nst);
                            pQ.add(nst);
                        }

                        if (minCost[nd.to][current.nowB] > nd.cost + current.cost) {
                            minCost[nd.to][current.nowB] = nd.cost + current.cost;
                            Next nst2 = new Next(nd.to, current.nowB, nd.cost + current.cost, current.visited.clone());
                            printNext("addNext", nst2);
                            pQ.add(nst2);
                        }

                        current.visited[nd.to] = false;
                    }
                }
            } else { // 따로 가는 경우
                for (Node nd : ver[current.nowA].nodes) {
                    if (!current.visited[nd.to] && (minCost[nd.to][current.nowB] > nd.cost + current.cost)) {
                        current.visited[nd.to] = true;
                        minCost[nd.to][current.nowB] = nd.cost + current.cost;
                        Next nst3 = new Next(nd.to, current.nowB, nd.cost + current.cost, current.visited.clone());
                        printNext("addNext", nst3);
                        pQ.add(nst3);
                        current.visited[nd.to] = false;
                    }
                }
                for (Node nd : ver[current.nowB].nodes) {
                    if (!current.visited[nd.to] && (minCost[current.nowA][nd.to] > nd.cost + current.cost)) {
                        current.visited[nd.to] = true;
                        minCost[current.nowA][nd.to] = nd.cost + current.cost;
                        Next nst4 = new Next(current.nowA, nd.to, nd.cost + current.cost, current.visited.clone());
                        printNext("addNext", nst4);
                        pQ.add(nst4);
                        current.visited[nd.to] = false;
                    }
                }
            }
        }

        return 0;
    }

    void printNext(String add , Next n) {
        if(add.contains("hand"))
            System.out.println(add + n);
    }

    class Next {
        int nowA;
        int nowB;
        int cost;
        boolean[] visited;

        public Next(int nowA, int nowB, int cost, boolean[] visited) {
            this.nowA = nowA;
            this.nowB = nowB;
            this.cost = cost;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return nowA + "," + nowB + "," + cost + ": " + Arrays.toString(visited);
        }
    }

    class Vertex {
        int id;

        public Vertex(int id) {
            this.id = id;
        }

        ArrayList<Node> nodes = new ArrayList<Node>();
    }

    class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}