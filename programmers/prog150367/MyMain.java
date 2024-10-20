package prog150367;

import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */

public class MyMain {
    public static void main(String[] args) {
        long[] numbers = { 129 };
        Solution mSolution = new Solution();
        System.out.println(Arrays.toString(mSolution.solution(numbers)));
    }
}

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = checkNumber(numbers[i]);
        }
        return answer;
    }

    boolean isValid = true;

    int checkNumber(long num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        String binNum = makeBin(num);
        isValid = true;
        if (isNodeValid(binNum)) {
            return 1;
        } else {
            return 0;
        }
    }

    boolean isNodeValid(String node) {
        System.out.println("check: " + node);
        if (node.length() == 1) {
            return true;
        }

        int midIdx = node.length() / 2;
        if (node.charAt(midIdx) == '0') {
            if ((node.charAt(midIdx / 2) == '1') || (node.charAt(midIdx + midIdx / 2 + 1) == '1')) {
                isValid = false;
                return false;
            }
        }

        if (isValid && node.length() > 3) {
            if (!isNodeValid(node.substring(0, midIdx))) {
                isValid = false;
                return false;
            }
            if (!isNodeValid(node.substring(midIdx + 1, node.length()))) {
                isValid = false;
                return false;
            }
        }

        return true;
    }

    String makeBin(long num) {
        String result = "";
        while (num != 0) {
            result = (num % 2) + result;
            num = num / 2;
        }
        int sz = result.length();
        if (sz >= 64) {
            sz = 127 - sz;
        } else if (sz >= 32) {
            sz = 63 - sz;
        } else if (sz >= 16) {
            sz = 31 - sz;
        } else if (sz >= 8) {
            sz = 15 - sz;
        } else if (sz >= 4) {
            sz = 7 - sz;
        } else if (sz >= 2) {
            sz = 3 - sz;
        } else { // sz == 1
        }

        for (int i = sz; i > 0; i--) {
            result = "0" + result;
        }

        return result;
    }
}