package acmicpc1005;

import java.io.*;
import java.util.*;

/* ACM Craft >>> 풀이중
 * https://www.acmicpc.net/problem/1005
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // NG
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Vertex[] v = new Vertex[N];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                v[i] = new Vertex(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(bf.readLine());
                int front = Integer.parseInt(st.nextToken()) - 1;
                int rear = Integer.parseInt(st.nextToken()) - 1;

                v[front].s.add(rear);
                v[rear].pCount++;
            }
            int lastOne = Integer.parseInt(bf.readLine()) - 1;

            // for (int i = 0; i < N; i++) {
            // System.out.println(i + ":" + v[i]);
            // }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < v.length; i++) {
                if (v[i].pCount <= 0) {
                    v[i].start = 0;
                    q.add(i);
                }
            }
            boolean isDone = false;
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
                            if (lastOne == son) {
                                sb.append(v[son].start + v[son].task).append("\n");
                                isDone = true;
                                break;
                            }
                            q.add(son);
                        }
                    }
                    if (isDone) {
                        break;
                    }
                    v[cur].pCount = Integer.MAX_VALUE;
                }
                if (isDone) {
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static class Vertex {
        int start = -1;
        int task;

        public Vertex(int task) {
            this.task = task;
        }

        int pCount;

        ArrayList<Integer> s = new ArrayList<>();

        @Override
        public String toString() {
            return task + "," + pCount + "," + s;
        }
    }
}
