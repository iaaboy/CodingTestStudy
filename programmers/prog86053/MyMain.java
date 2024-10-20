package prog86053;

/* 금과 은 운반하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86053
 */

public class MyMain {
    public static void main(String[] args) {
        int[] a = { 90 };
        int[] b = { 500 };
        int[][] g = { { 70, 70, 0 } };
        int[][] s = { { 0, 0, 500 } };
        int[][] w = { { 100, 100, 2 } };
        int[][] t = { { 4, 8, 1 } };

        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(a[i], b[i], g[i], s[i], w[i], t[i]));
        }
    }
}

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 1000000000000001L;
        long time;
        while (true) {
            time = left + ((right - left) / (long)2);
            // System.out.println(time);
            if (checkT(time, a, b, g, s, w, t)) {
                right = time;
            } else {
                left = time;
            }
            if (left + 1 == right) {
                break;
            }
        }
        return right;
    }

    private boolean checkT(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length;
        long gMax = 0L;
        long sMax = 0L;
        long wSum = 0L;
        for (int i = 0; i < n; i++) {
            long wCount = (time + t[i]) / (t[i] * 2L);
            //해당 시간에 옮길 수 있는 무게
            long wPossible = Math.min(wCount * w[i], g[i] + s[i]);
            //최대 work
            wSum += wPossible;
            //i의 골드 최대
            long gPossible = Math.min(wPossible, g[i]);
             gMax += gPossible;// > 0 ? gPossible : 0;
            //i의 실버 최대
            long sPossible = Math.min(wPossible, s[i]);
            sMax += sPossible;// > 0 ? sPossible : 0;
        }
        if (wSum >= a + b && gMax >= a && sMax >= b) {
            return true;
        } else {
            return false;
        }
    }
}