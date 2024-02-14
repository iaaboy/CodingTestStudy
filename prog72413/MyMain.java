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
                    { 2, 4, 66 },{ 2, 3, 22 }, { 1, 6, 25 } },
                { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } },
                { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 }, 
                    { 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 },{ 4, 3, 9 } }
        };
        Solution mSol = new Solution();
        for(int i = 0; i < 3 ; i++) {
            System.out.println("ans: " + mSol.solution(n[i], s[i], a[i], b[i], fares[i]));
        }
    }
}

class Solution {
    int a, b;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Vertex [] ver = new Vertex[n + 1];
        boolean [] visited = new boolean[n + 1]; //n은 1부터..
        this.a = a;
        this.b = b;
        for(int i = 0; i < n + 1 ; i++) {
            ver[i] = new Vertex(i);
        }

        for(int[] fare : fares) {
            ver[fare[0]].nodes.add(new Node(fare[1], fare[2]));
            ver[fare[1]].nodes.add(new Node(fare[0], fare[2]));
        }

        visited[s] = true;
        PriorityQueue <Next> pQ = new PriorityQueue<>((me, you) -> me.cost - you.cost);
        pQ.add(new Next(s, s, 0, visited));

        while(!pQ.isEmpty()) {
            Next current = pQ.poll();
            System.out.println("cur :" + current);
            if(current.nowA == a && current.nowB == b) {
                return current.cost;
            }

            visited[current.nowA] = true;
            visited[current.nowB] = true;

            if(current.nowA == current.nowB) { // 다음도 합승
                for(Node nd : ver[current.nowA].nodes) {
                    if(!visited[nd.to]) {
                        visited[nd.to] = true;
                        pQ.add(new Next(nd.to, nd.to, nd.cost + current.cost, visited.clone()));
                        visited[nd.to] = false;
                    }
                }
                for(Node nd : ver[current.nowA].nodes) {
                    if(!visited[nd.to]) {
                        visited[nd.to] = true;
                        pQ.add(new Next(current.nowA, nd.to, nd.cost + current.cost, visited.clone()));
                        pQ.add(new Next(nd.to, current.nowB, nd.cost + current.cost, visited.clone()));
                        visited[nd.to] = false;
                    }
                }
            } else { //따로 가는 경우
                for(Node nd : ver[current.nowA].nodes) {
                    if(!visited[nd.to]) {
                        visited[nd.to] = true;
                        pQ.add(new Next(nd.to, current.nowB, nd.cost + current.cost, visited.clone()));
                        visited[nd.to] = false;
                    }
                }
                for(Node nd : ver[current.nowB].nodes) {
                    if(!visited[nd.to]) {
                        visited[nd.to] = true;
                        pQ.add(new Next(current.nowA, nd.to, nd.cost + current.cost, visited.clone()));
                        visited[nd.to] = false;
                    }
                }
            }
            //따로
        }

        return 0;
    }
    class Next{
        int nowA;
        int nowB;
        int cost;
        boolean [] visited;
        public Next(int nowA, int nowB, int cost, boolean[] visited) {
            this.nowA = nowA;
            this.nowB = nowB;
            this.cost = cost;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return nowA +"," + nowB + "," + cost + ": " + Arrays.toString(visited);
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