package acmicpc15971;

import java.io.*;
import java.util.*;

/* 두 로봇
 * https://www.acmicpc.net/problem/15971
 * 다익스트라
 */

public class Main {
    static Vertex[] v;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        v = new Vertex[N + 1];
        for (int i = 0; i <= N; i++) {
            v[i] = new Vertex();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            v[start].nodes.add(new Node(end, cost));
            v[end].nodes.add(new Node(start, cost));
        }

        for (int i = 0; i < N; i++) {
            v[i].nodes.sort((a, b) -> a.cost - b.cost);
        }
        visit = new boolean[N + 1];
        Stack<Node> s = new Stack<>();
        visit[A] = true;
        travel(s, A, B);
        int sum = 0;
        int max = 0;
        while (!s.isEmpty()) {
            max = Math.max(max, s.peek().cost);
            sum += s.pop().cost;
        }
        System.out.println(sum - max);
    }

    private static boolean travel(Stack<Node> s, int current, int target) {
        if (current == target) {
            // System.out.println("arrived" + s);
            return true;
        }

        for (Node child : v[current].nodes) {
            if (!visit[child.to]) {
                s.push(child);
                visit[child.to] = true;
                if (travel(s, child.to, target)) {
                    return true;
                }
                s.pop();
                visit[child.to] = false;
            }
        }
        return false;
    }

    static class Vertex {
        ArrayList<Node> nodes = new ArrayList<>();
    }

    static class Node {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return to + "(" + cost + ")";
        }
    }
}
