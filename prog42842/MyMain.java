package prog42842;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(10, 2)));
        System.out.println(Arrays.toString(mSol.solution(8, 1)));
        System.out.println(Arrays.toString(mSol.solution(24, 24)));
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 1. 나눠지는 수 조합 찾기
        int sum = brown + yellow;

        for (int i = sum / 2 + 1; i > 0; i--) {
            if (sum % i == 0) {
                System.out.println("i: " + i + ", j:" + sum / i);
                if (2 * (i + sum / i) == brown + 4) {
                    answer[0] = i;
                    answer[1] = sum / i;
                    System.out.println("answer");
                    return answer;
                }
            }
        }

        return answer;
    }
}