package acmicpc6858;

import java.io.*;
import java.util.*;

/* It’s tough being a teen!
 * https://www.acmicpc.net/problem/6858
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = -1;
        int b = -1;

        int[][] preVal = { { 1, 7 }, // 0 <- 1 //0 parent, 1 son
                { 1, 4 },
                { 2, 1 },
                { 3, 4 },
                { 3, 5 } }; // 5, 2 arr

        Vertex[] v = new Vertex[7 + 1];
        for (int i = 0; i < v.length; i++) {
            v[i] = new Vertex();
        }

        for (int i = 0; i < preVal.length; i++) {
            v[preVal[i][1]].pCount++;
            v[preVal[i][0]].s.add(preVal[i][1]);
        }

        while (true) {
            a = Integer.parseInt(bf.readLine());
            b = Integer.parseInt(bf.readLine());
            if (a == 0 && b == 0) {
                break;
            }
            v[a].s.add(b);
            v[b].pCount++;
        }

        // for (int i = 1; i <= 7; i++) {
        // System.out.println(i + ": " + v[i]);
        // }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < v.length; i++) {
            if (v[i].pCount <= 0) {
                q.add(i);
            }
        }

        Queue<Integer> tasks = new LinkedList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            tasks.add(cur);
            // System.out.println("cur:" + cur);
            for (Integer son : v[cur].s) {
                v[son].pCount--;
                if (v[son].pCount == 0) {
                    q.add(son);
                }
            }
        }
        if (tasks.size() != 7) {
            System.out.println("Cannot complete these tasks. Going to bed.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Integer t : tasks) {
                sb.append(t).append(" ");
            }
            System.out.println(sb);
        }
    }

    static class Vertex {
        int pCount;

        ArrayList<Integer> s = new ArrayList<>();

        @Override
        public String toString() {
            return pCount + ", " + s.toString();
        }
    }
}
