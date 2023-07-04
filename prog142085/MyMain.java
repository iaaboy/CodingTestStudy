package prog142085;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = { 4, 2, 4, 5, 3, 3, 1 };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, k, enemy));
    }
}

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> myQ = new PriorityQueue<>();

        if (k > enemy.length) {
            return enemy.length;
        }

        int i = 0;
        for (; i < k; i++) {
            myQ.add(enemy[i]);
        }

        // System.out.println(myQ);

        int beaten = 0;
        for (; i < enemy.length; i++) {
            myQ.add(enemy[i]);
            beaten = myQ.poll();
            n -= beaten;
            // System.out.println("beaton: "+ beaten + "n: "+ n);
            if (n < 0) {
                break;
            }
        }

        // System.out.println(myQ);
        // System.out.println(i);
        answer = i;

        return answer;
    }
}