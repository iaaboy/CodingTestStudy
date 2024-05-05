package progLevel1;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */

public class MyMain {
    public static void main(String[] args) {
        int k = 4;
        int[] score = { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 };
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(k, score)));
    }
}

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> topkScore = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            if (k > 0) {
                topkScore.add(score[i]);
                k--;
            } else {
                if (topkScore.peek() >= score[i]) {
                    // skip
                } else {
                    topkScore.poll();
                    topkScore.add(score[i]);
                }
            }
            answer[i] = topkScore.peek();
        }

        return answer;
    }
}