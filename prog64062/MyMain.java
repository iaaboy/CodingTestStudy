package prog64062;

import java.util.PriorityQueue;

/* 징검다리 건너기
 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
 */

public class MyMain {
    public static void main(String[] args) {
        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        int k = 3;
        Solution mSol = new Solution();
        System.out.println(mSol.solution(stones, k));
    }
}

class Solution {
    public int solution(int[] stones, int k) {
        int minNumber = Integer.MAX_VALUE;
        PriorityQueue<Integer> mQ = new PriorityQueue<>((a, b) -> {
            return stones[b] - stones[a];
        });
        for (int i = 0; i < k - 1; i++) {
            mQ.add(i);
        }
        for (int i = k - 1; i < stones.length; i++) {
            mQ.add(i);
            while (mQ.peek() < i - k + 1) {
                // System.out.println("*** " + i + ": expire.. " + mQ.peek());
                mQ.poll();
            }
            // System.out.println(i + ": curpeek, " + mQ.peek() + " ->" +
            // stones[mQ.peek()]);
            if (stones[mQ.peek()] < minNumber) {
                minNumber = stones[mQ.peek()];
            }
        }
        return minNumber;
    }
}