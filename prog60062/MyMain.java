package prog60062;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 12, 12 };
        int[][] weaks = {
                { 1, 5, 6, 10 },
                { 1, 3, 4, 9, 10 }
        };
        int[][] dist = {
                { 1, 2, 3, 4 }, // 2
                { 3, 5, 7 } // 1
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(n[i], weaks[i], dist[i]));
    }
}

class Solution {
    public int solution(int n, int[] weak, int[] dist) {

        // 1. dist 의 조합을 구한다.
        // 2. 각 조합에서 커버 가능한지 확인한다.
        int[] chosen = new int[dist.length];
        combi(chosen, dist, 0, 0, 3);

        int answer = 0;
        return answer;
    }

    private void combi(int[] chosen, int[] dist, int index, int count, int targetCunt) {
        if (count == targetCunt) {
            for (int i = 0; i < count; i++)
                System.out.print(chosen[i] + " ");
            System.out.println();
            return;
        }
        for (int i = index; i < dist.length; i++) {
            chosen[count] = dist[i];
            combi(chosen, dist, i + 1, count + 1, targetCunt);
        }
    }
}