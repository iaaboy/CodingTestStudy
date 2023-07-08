package prog138475;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int e = 20;
        int[] starts = { 1, 3, 7 };

        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(e, starts)));
    }
}

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for (int x = 1; x <= e; x++) {
            for (int y = 1; y <= e; y++) {
                int multy = x * y;
                if (multy > e) {
                    break;
                }
                System.out.print(x + "," + y + "->" + multy + "   ");
                if (numCount.containsKey(multy)) {
                    numCount.put(multy, numCount.get(multy) + 1);
                } else {
                    numCount.put(multy, 1);
                }
            }
            System.out.println();
        }

        System.out.println(numCount);
        for (int i = 0; i < starts.length; i++) {
            int curMax = Integer.MIN_VALUE;
            for (int m = starts[i]; m <= e; m++) {
                if (numCount.get(m) != null && numCount.get(m) > curMax) {
                    curMax = numCount.get(m);
                    answer[i] = m;
                }
            }
        }
        return answer;
    }
}