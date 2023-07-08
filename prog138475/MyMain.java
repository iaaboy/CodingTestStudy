package prog138475;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int e = 10;
        int[] starts = { 1, 3, 7 };
        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(e, starts)));
    }
}

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] submultiCounts = new int[e + 1];
        int[] maxIndex = new int[e + 1];
        int[] answer = new int[starts.length];

        int minST = Integer.MAX_VALUE;
        for (int st : starts) {
            if (minST > st) {
                minST = st;
            }
        }

        // 조금 빠른 약수 counting
        // for (int i = minST; i <= e; i++) {
        // submultiCounts[i] = submulti(i);
        // }

        // 가장 빠른 약수 counting
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                submultiCounts[i * j]++;
            }
        }

        // System.out.println(Arrays.toString(submultiCounts));

        int curMax = Integer.MIN_VALUE;
        int curMaxIndex = submultiCounts.length - 1;
        for (int m = submultiCounts.length - 1; m >= minST; m--) {
            if (submultiCounts[m] >= curMax) {
                curMax = submultiCounts[m];
                curMaxIndex = m;
            }
            maxIndex[m] = curMaxIndex;
        }
        // System.out.println(Arrays.toString(maxIndex));

        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxIndex[starts[i]];
        }

        return answer;
    }

    int submulti(int num) {

        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) {
                count++;
            } else if (num % i == 0) {
                count += 2;
            }
        }

        // System.out.println("num:" + num + ", count" + count);

        return count;
    }
}