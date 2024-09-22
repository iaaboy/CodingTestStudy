package acmicpc2056;

import java.io.*;
import java.util.*;

/* 작업
 * https://www.acmicpc.net/problem/2056
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Vertex[] v = new Vertex[N + 1];
        for (int i = 1; i < N + 1; i++) {
            v[i] = new Vertex();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            v[i].task = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            v[i].pCount = K;
            for (int j = 0; j < K; j++) {
                int me = i;
                int you = Integer.parseInt(st.nextToken());
                v[you].s.add(me);
            }
        }

        // for (int i = 1; i <= N; i++) {
        // System.out.println(i + ":" + v[i]);
        // }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < v.length; i++) {
            if (v[i].pCount <= 0) {
                v[i].start = 0;
                q.add(i);
            }
        }
        int finishTime = 0;
        while (!q.isEmpty()) {
            int handleCount = q.size();
            int maxTask = 0;
            for (int i = 0; i < handleCount; i++) {
                int cur = q.poll();
                // System.out.println("handled: " + cur);
                maxTask = Math.max(maxTask, v[cur].task);
                for (Integer son : v[cur].s) {
                    v[son].pCount--;
                    v[son].start = Math.max(v[son].start, v[cur].start + v[cur].task);
                    if (v[son].pCount == 0) {
                        q.add(son);
                    }
                }
                v[cur].pCount = Integer.MAX_VALUE;
                finishTime = Math.max(finishTime, v[cur].start + v[cur].task);
            }
        }
        System.out.println(finishTime);
    }

    static class Vertex {
        int start = -1;
        int task;
        int pCount;

        ArrayList<Integer> s = new ArrayList<>();

        @Override
        public String toString() {
            return task + "," + s;
        }
    }
}
