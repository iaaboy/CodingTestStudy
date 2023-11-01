package prog12923;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(begin, end)));
    }
}

class Solution {
    public int[] solution(long begin, long end) {
        int arrSize = (int) (end - begin + 1);
        int[] answer = new int[arrSize];
        int answerIdx = 0;

        if (arrSize == 1) {
            if (begin == 1) {
                answer[answerIdx++] = 0;
            } else {
                int minP = getMinPrime(begin);
                // System.out.println("minPrime: " + i + " -> " + minP);
                if (minP == -1) {
                    answer[0] = 1;
                } else {
                    answer[0] = (int) begin / minP;
                }
            }
            return answer;
        }

        for (int i = (int) begin; i <= begin + arrSize - 1; i++) {
            if (i == 1) {
                answer[answerIdx++] = 0;
                continue;
            }
            int minP = getMinPrime(i);
            // System.out.println("minPrime: " + i + " -> " + minP);
            if (minP == -1) {
                answer[answerIdx++] = 1;
            } else {
                answer[answerIdx++] = minP;
            }
        }

        return answer;
    }

    int getMinPrime(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                int result = (int) number / i;
                if (result > 10000000) {
                    continue;
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}