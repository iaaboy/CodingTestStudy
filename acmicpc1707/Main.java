package acmicpc1707;

import java.io.*;
import java.util.*;

/*
이분 그래프
https://www.acmicpc.net/problem/1707
먼저 이분그래프를 이해하고,
https://ko.wikipedia.org/wiki/%EC%9D%B4%EB%B6%84_%EA%B7%B8%EB%9E%98%ED%94%84
이분 그래프 판별 방법
나와 이웃한 그래프를 다른색으로 칠한다. 이 때 나와 같은 색이 이미 칠해진 그래프가 있다면 이분 그래프가 아님.
입력이 하나의 트리가 아닐 수 있으므로, 전체 정점 모두 탐색
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        boolean isBinGraph = true;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            isBinGraph = true;
            Vertex[] v = new Vertex[V + 1];
            for (int i = 1; i <= V; i++) {
                v[i] = new Vertex();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(bf.readLine());
                int me = Integer.parseInt(st.nextToken());
                int you = Integer.parseInt(st.nextToken());
                v[me].neighbors.add(you);
                v[you].neighbors.add(me);
            }
            MainLoop: for (int i = 1; i <= V; i++) {
                if (v[i].color == 0) {
                    if (!setColor(v, i)) {
                        isBinGraph = false;
                        continue MainLoop;
                    }
                }
            }
            // System.out.println(Arrays.toString(v));
            sb.append(isBinGraph ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    private static boolean setColor(Vertex[] v, int root) {
        Queue<State> q = new ArrayDeque<>();
        v[root].color = 1;
        q.add(new State(root, 1));
        while (!q.isEmpty()) {
            State c = q.poll();
            for (Integer n : v[c.id].neighbors) {
                if (v[n].color == c.color) {
                    return false;
                }
                if (v[n].color == 0) {
                    if (c.color == 1) {
                        v[n].color = 2;
                    } else {
                        v[n].color = 1;
                    }

                    q.add(new State(n, v[n].color));
                }
            }
        }
        return true;
    }

    static class State {
        int id, color;

        public State(int id, int color) {
            this.id = id;
            this.color = color;
        }
    }

    static class Vertex {
        int color;
        ArrayList<Integer> neighbors = new ArrayList<>();

        @Override
        public String toString() {
            return color + " " + neighbors;
        }
    }
}
