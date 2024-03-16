package prog17687;

/* [3차] n진수 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        // System.out.println("result: " + mSol.solution(2, 4, 2, 1));
        System.out.println("result: " + mSol.solution(16, 16, 3, 1));
    }
}

class Solution {
    char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public String solution(int n, int t, int m, int p) {
        int maxIndex = (t) * m + (p + 1);// 아웃풋으로 낼 마지막 글자

        StringBuilder numSb = new StringBuilder();
        int num = 0;
        while (numSb.length() < maxIndex) {
            numSb.append(Integer.toString(num++, n));
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            sb.append(numSb.charAt(p - 1 + m * i));
        }

        return sb.toString().toUpperCase();
    }
}