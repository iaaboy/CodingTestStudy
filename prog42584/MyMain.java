package prog42584;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(prices)));
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        PriorityQueue<Integer> q = new PriorityQueue<>((me, you) -> {
            return prices[me] < prices[you] ? 1 : -1;
        });

        int i = 0;
        for (; i < prices.length; i++) {
            if (!q.isEmpty() && prices[q.peek()] > prices[i]) {
                while (!q.isEmpty() && prices[q.peek()] > prices[i]) {
                    // System.out.print(prices[q.peek()] + " ");
                    answer[q.peek()] = i - q.poll();
                }
            }
            q.add(i);
        }
        i--;
        while (q.size() > 0) {
            answer[q.peek()] = i - q.poll();
        }

        // System.out.println(Arrays.toString(answer));

        return answer;
    }
}