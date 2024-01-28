package prog12938;

import java.util.Arrays;

/* 최고의 집합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */

public class MyMain {
    public static void main(String[] args) {
        int[] ns = { 2, 2, 2 };
        int[] ss = { 9, 1, 8 };

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(mSol.solution(ns[i], ss[i])));
        }
    }
}

class Solution {
    public int[] solution(int n, int s) {
        int share = s / n;
        int[] answer = new int[n];
        if (share == 0) {
            return new int[] { -1 };
        }

        for (int i = 0; i < n; i++) {
            answer[i] = share;
            if (i > n - 1 - s % n) {
                answer[i]++;
            }
        }

        return answer;
    }
}