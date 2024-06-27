package acmicpc21773;

import java.io.*;
import java.util.*;

/* 가희와 프로세스 1
 * https://www.acmicpc.net/problem/21773
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Cpu> prs = new PriorityQueue<>((a, b) -> {
            if (a.priority == b.priority) {
                return a.id - b.id;
            } else {
                return b.priority > a.priority ? 1 : -1;
            }
        });
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            prs.add(new Cpu(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        // System.out.println(prs);
        StringBuilder sb = new StringBuilder();
        while (N != 0 && !prs.isEmpty()) {
            // System.out.print(prs + "\n");
            Cpu cur = prs.poll();
            sb.append(cur.id + "\n");
            // sb.append(prs + "\n");
            // System.out.println(cur.id + "\n");
            cur.priority--;
            cur.remained--;
            if (cur.remained > 0) {
                prs.add(cur);
            }
            N--;

        }
        System.out.println(sb);
    }

    static class Cpu {
        int id;
        int remained;
        int priority;

        public Cpu(int id, int remained, int priority) {
            this.id = id;
            this.remained = remained;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return id + ": " + remained + "," + priority;
        }
    }
}