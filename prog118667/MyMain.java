package prog118667;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] queue1 = { 3, 2, 7, 2 }; int[] queue2 = { 4, 6, 5, 1 };
        // int [] queue1 = {1, 2, 1, 2}; int []queue2 = {1, 10, 1, 2};
        // int [] queue1 = {1,1}; int [] queue2 = {1, 1};

        Solution mSol = new Solution();
        System.out.println(mSol.solution(queue1, queue2));
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;

        for (int q : queue1) {
            q1Sum += q;
            q1.add(q);
        }
        for (int q : queue2) {
            q2Sum += q;
            q2.add(q);
        }

        int maxCount = (q1.size() + q2.size());

        if (maxCount % 2 != 0) { // 홀수 // 필요 없음.
            return answer;
        }
        maxCount *= 2;

        int count = 0;
        while (!q1.isEmpty() && !q2.isEmpty() && count < maxCount) {

            if (q1Sum == q2Sum) {
                answer = count;
                break;
            } else if (q1Sum > q2Sum) {
                int q1peek = q1.poll();
                q2Sum += q1peek;
                q1Sum -= q1peek;
                q2.add(q1peek);
            } else {
                int q2peek = q2.poll();
                q1Sum += q2peek;
                q2Sum -= q2peek;
                q1.add(q2peek);
            }
            count++;

            System.out.println("q1: " + q1);
            System.out.println("q2: " + q2);
        }

        return answer;
    }
}