package prog12927;

import java.util.*;

/* 야근 지수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] work = {
                { 18, 10, 10, 2, 1, 1 },
                { 8, 7, 5, 4, 1 },
                { 4, 3, 3, }, // {5,3,3},
                { 2, 2, 1 },
                { 1, 1 }
        };
        int[] n = {
                10, 12, 4, 1, 3
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 5; i++)
            System.out.println(mSol.solution(n[i], work[i]));
    }
}

class Solution {
    public long solution(int n, int[] works) {
        Integer work[] = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(work, Collections.reverseOrder());

        int diffAccum = 0;
        int indexToWork = 1;
        int remainedN = n;
        for (; indexToWork < work.length; indexToWork++) {
            int diff = work[indexToWork - 1] - work[indexToWork];
            diffAccum += indexToWork * diff;
            // System.out.println(i + ": diff<" + diff + "> diffAccum<" + diffAccum + ">");
            if (n <= diffAccum) {
                break;
            } else {
                remainedN = n - diffAccum;
            }
        }

        // System.out.println(Arrays.toString(work));
        if (n <= diffAccum) {
            // System.out.println(n + " break at " + i + ", remainedN: " + remainedN);
            int disWork = remainedN / indexToWork;
            int rest = remainedN % indexToWork;
            for (int index = 0; index < indexToWork; index++) {
                if (rest > 0) {
                    work[index] = work[indexToWork - 1] - (disWork + 1);
                    rest--;
                } else {
                    work[index] = work[indexToWork - 1] - disWork;
                }
            }
        } else {
            // System.out.println(n + " finish" + i + ", remainedN: " + remainedN);
            int disWork = remainedN / indexToWork;
            int rest = remainedN % indexToWork;
            for (int index = 0; index < indexToWork; index++) {
                if (rest > 0) {
                    work[index] = work[indexToWork - 1] - (disWork + 1);
                    rest--;
                } else {
                    work[index] = work[indexToWork - 1] - disWork;
                }
            }
        }
        // System.out.println(Arrays.toString(work));

        long answer = 0;
        for (int w : work) {
            answer += w > 0 ? Math.pow(w, 2) : 0;
        }

        return answer;
    }
}