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
        dfs(1, 0, visited);
        // System.out.println(Arrays.toString(distance));

        int maxDist = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > maxDist) {
                maxDist = distance[i];
                answer = 1;
            } else if (distance[i] == maxDist) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int v, int d, boolean[] visited) {
        System.out.println("visit: " + v);
        if (distance[v] > d) {
            distance[v] = d;
        }
        for (int node : map[v].nodes) {
            if (!visited[node] && distance[v] <= d) {
                visited[node] = true;
                dfs(node, d + 1, visited);
                visited[node] = false;
            }
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