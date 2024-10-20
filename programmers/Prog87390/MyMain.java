package Prog87390;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 4;
        int left = 7;
        int right = 14;

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(n, left, right)));
    }
}

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int index = 0;
        for (long i = left; i <= right; i++) {
            answer[index++] = (int) getNum(i, n);
            // System.out.println(getNum(i, n));
        }
        return answer;
    }

    long getNum(long in, int n) {
        long line = (in + n) / n;
        long col = in % n + 1;
        // System.out.println(line +"," + col);
        return line > col - 1 ? line : col;
    }
}