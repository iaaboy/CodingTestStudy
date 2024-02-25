package prog86053;

import java.util.PriorityQueue;

/* 금과 은 운반하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86053
 */

public class MyMain {
    public static void main(String[] args) {
        int[] a = { 90 };
        int[] b = { 70 };
        int[][] g = { { 70, 20, 0 } };
        int[][] s = { { 40, 9, 0 } };
        int[][] w = { { 34, 30, 2 } };
        int[][] t = { { 4, 20, 1 } };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(a[i], b[i], g[i], s[i], w[i], t[i]));
        }
    }
}

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        PriorityQueue<Work> workQ = new PriorityQueue<>((me, you) -> {
            if (me.e == you.e) {
                return t[me.id] - t[you.id];
            } else {
                if (me.e - you.e > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < w.length; i++) {
            if (s[i] > 0 || g[i] > 0) {
                workQ.add(new Work(t[i], i));
            }
        }

        long latestHandled = 0;
        while (!workQ.isEmpty()) {
            Work cWork = workQ.poll();
            System.out.println(a + ", " + b + " .. " + cWork);
            // update loads
            int load = w[cWork.id];
            latestHandled = cWork.e;

            if (g[cWork.id] > 0) {
                int goldLoad = Math.min(Math.min(g[cWork.id], load), a);
                load -= goldLoad;
                g[cWork.id] -= goldLoad;
                a -= goldLoad;
            }

            if (s[cWork.id] > 0) {
                int silverLoad = Math.min(Math.min(s[cWork.id], load), b);
                s[cWork.id] -= silverLoad;
                load -= silverLoad;
                b -= silverLoad;
            }

            // check finish condition
            if (a <= 0 && b <= 0) {
                return cWork.e;
            }

            // enqueue
            if (s[cWork.id] > 0 || g[cWork.id] > 0) {
                workQ.add(new Work(cWork.e + t[cWork.id] + t[cWork.id], cWork.id));
            }
        }

        return latestHandled;
    }

    class Work {
        long e;
        int id;

        public Work(long e, int id) {
            this.e = e;
            this.id = id;
        }

        @Override
        public String toString() {
            return id + ":" + e;
        }
    }
}