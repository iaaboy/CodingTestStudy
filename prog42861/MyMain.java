package prog42861;

import java.util.*;

//최소 비용으로 모든 섬을 도달시 비용을 구함.

public class MyMain {
    public static void main(String[] args) {
        // int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3,
        // 8 } };
        // int n = 4;
        int[][] costs = { { 0, 1, 1 }, { 3, 1, 1 }, { 0, 2, 2 }, { 0, 3, 2 }, { 0, 4, 100 } };
        int n = 5;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, costs));
    }
}

class Solution {
    int[][] links;
    int n;
    boolean[][] initialR;

    public int solution(int n, int[][] costs) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        initialR = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                initialR[i][k] = true;
            }
        }

        links = new int[n][n];
        for (int[] c : costs) {
            links[c[0]][c[1]] = c[2];
            links[c[1]][c[0]] = c[2];

            initialR[c[0]][c[1]] = false;
            initialR[c[1]][c[0]] = false;
        }

        answer = searchRoute(0);
        return answer;
    }

    private int searchRoute(int start) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<VisitLog> qNext = new PriorityQueue<>();

        qNext.add(new VisitLog(start, 0, initialR, new HashSet<Integer>()));

        while (!qNext.isEmpty()) {
            VisitLog cur = qNext.poll();

            System.out.println("cur: " + cur);
            //System.out.println("q: " + qNext.size());

            if (cur.route.size() >= n) {
                System.out.println("total : " + cur.totalCost);
                if (cur.totalCost < result) {
                    result = cur.totalCost;
                }
                return cur.totalCost;
            }

            cur.route.add(cur.id);
            for (int i = 0; i < n; i++) {
                if (links[cur.id][i] != 0 && cur.id != i) {
                    if (!cur.isVisit[cur.id][i]) {
                        VisitLog newPoint;
                        cur.isVisit[cur.id][i] = true;
                        boolean[][] isVisitCp = new boolean[n][n];
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < n; b++) {
                                isVisitCp[a][b] = cur.isVisit[a][b];
                            }
                        }
                        if (cur.isVisit[i][cur.id]) {
                            newPoint = new VisitLog(i, cur.totalCost, isVisitCp, new HashSet<>(cur.route));
                        } else {
                            newPoint = new VisitLog(i, cur.totalCost + links[cur.id][i], isVisitCp,
                                    new HashSet<>(cur.route));
                        }
                        // System.out.println("add to q:" + newPoint);
                        qNext.add(newPoint);
                        cur.isVisit[cur.id][i] = false;
                    }
                }
            }
        }

        return result;
    }
}

class VisitLog implements Comparable<VisitLog> {
    int id;
    int totalCost;
    boolean[][] isVisit;
    Set<Integer> route;

    public VisitLog(int id, int totalCost, boolean[][] isVisit, Set<Integer> route) {
        this.id = id;
        this.totalCost = totalCost;
        this.isVisit = isVisit;
        this.route = route;
    }

    @Override
    public int compareTo(VisitLog o) {
        return totalCost > o.totalCost ? 1: -1;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();

        for (int i = 0; i < isVisit.length; i++) {
            for (int k = 0; k < isVisit.length; k++) {
                a.append(isVisit[i][k] + " ");
            }
            a.append(" | ");
        }

        return "id: " + id + " ,cost:" + totalCost + ",r:" + route;
    }
}