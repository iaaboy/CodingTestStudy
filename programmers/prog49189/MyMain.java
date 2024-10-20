package prog49189;
/* 가장 먼 노드
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(n, vertex));
    }
}

class Solution {
    int[] distance;
    Vertex[] map;

    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        map = new Vertex[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new Vertex();
        }
        for (int[] e : edge) {
            map[e[0]].nodes.add(e[1]);
            map[e[1]].nodes.add(e[0]);
        }

        // System.out.println(Arrays.toString(map));

        int answer = 0;
        int maxDist = 0;
        Queue<Next> nextVisit = new LinkedList<>();
        nextVisit.add(new Next(1, 0));
        visited[1] = true;
        while (!nextVisit.isEmpty()) {
            Next v = nextVisit.poll();
            // System.out.println("visit <" + v.vertex + "," + v.distance+ "> " +
            // map[v.vertex]);
            for (int node : map[v.vertex].nodes) {
                if (!visited[node]) {
                    visited[node] = true;
                    nextVisit.add(new Next(node, v.distance + 1));
                    if (maxDist < v.distance + 1) {
                        maxDist = v.distance + 1;
                        answer = 1;
                    } else if (maxDist == v.distance + 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    class Next {
        int vertex;
        int distance;

        public Next(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    class Vertex {
        Vector<Integer> nodes = new Vector<>();

        @Override
        public String toString() {
            return nodes.toString();
        }
    }
}