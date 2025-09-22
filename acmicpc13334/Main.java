package acmicpc13334;

import java.io.*;
import java.util.*;

/* 철로
 * https://www.acmicpc.net/problem/13334
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Commute> endQ = new PriorityQueue<>((a, b) -> {
            if (a.e == b.e) {
                return a.s - b.s;
            }
            return a.e - b.e;
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Commute c = new Commute(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            endQ.add(c);
        }

        // System.out.println(endQ);

        int d = Integer.parseInt(bf.readLine());

        PriorityQueue<Commute> runningQ = new PriorityQueue<>((a, b) -> a.s - b.s);
        int maxCount = 0;
        while (!endQ.isEmpty()) {
            Commute c = endQ.peek();

            // start에서 running으로 넣는다.
            int endTime = c.e;
            while (!endQ.isEmpty()) {
                if (endQ.peek().e <= endTime) {
                    runningQ.add(endQ.poll());
                } else {
                    break;
                }
            }

            // running에서 뺀다
            int pastTime = endTime - d;
            while (!runningQ.isEmpty()) {
                if (runningQ.peek().s < pastTime) {
                    runningQ.poll();
                } else {
                    break;
                }
            }
            // running개수 센다.
            // System.out.println(c + ":" + runningQ.size() + " .." + pastTime + ".." + runningQ );
            maxCount = Math.max(maxCount, runningQ.size());
        }
        System.out.println(maxCount);
    }

    static class Commute {
        int s, e;

        public Commute(int h, int o) {
            this.s = Math.min(h,o);
            this.e = Math.max(h,o);
        }

        @Override
        public String toString() {
            return s + "," + e;
        }
    }
}
