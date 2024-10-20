package prog42626;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int sco : scoville) {
            q.add(sco);
        }

        while (q.size() > 1 && q.peek() < K) {
            int a = q.poll();
            int b = q.poll();

            q.add(a + 2 * b);
            answer++;
        }
        if (q.peek() < K) {
            return -1;
        }

        return answer;
    }
}