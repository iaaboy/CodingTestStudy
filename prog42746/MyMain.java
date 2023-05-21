package prog42746;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[][] inArr = {
                { 104, 1 }
        };

        Solution mSol = new Solution();
        for (int[] inA : inArr) {
            System.out.println("answer : " + mSol.solution(inA));
        }
    }
}

class Solution {
    public String solution(int[] num) {
        String answer = "";
        String[] nString = new String[num.length];
        int idx = 0;
        int count = 0;

        for (int n : num) {
            nString[idx++] = Integer.toString(n);
            if (n == 0) {
                count++;
            }
        }

        if (count == num.length) {
            return "0";
        }

        Arrays.sort(nString, (aStr, bStr) -> {
            return Integer.parseInt(aStr + bStr) < Integer.parseInt(bStr + aStr) ? 1 : -1;
        });

        for (String aa : nString) {
            System.out.println(aa);
            answer += aa;
        }

        return answer;
    }
}