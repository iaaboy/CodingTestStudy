package prog17687;

import java.util.Arrays;

/* [3차] n진수 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        // System.out.println("result: " + mSol.solution(2, 4, 2, 1));
        System.out.println("result: " + mSol.solution(16, 100, 3, 1));
    }
}

class Solution {
    char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public String solution(int n, int t, int m, int p) {
        int maxIndex = (t) * m + (p);// 아웃풋으로 낼 마지막 글자

        // n진수 수를 maxIndex 까지 구한다.
        char[] nNum = generateNum(n, maxIndex);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            sb.append(nNum[p - 1 + m * i]);
        }
        return sb.toString();
    }

    private char[] generateNum(int n, int maxCount) {
        char[] nNum = new char[maxCount + 2];
        nNum[0] = '0';
        int curIdx = 1;
        int num = 1;
        while (curIdx < maxCount) {
            char[] numCh = getNumChar(n, num);
            for (int i = 0; i < numCh.length; i++) {
                nNum[curIdx++] = numCh[i];
                if (curIdx >= maxCount)
                    break;
            }
            // System.out.println(num + "," + Arrays.toString(numCh) + " :: nNum" +
            // Arrays.toString(nNum));
            num++;
        }
        return nNum;
    }

    private char[] getNumChar(int n, int num) {
        int count = (int) ((Math.log(num) / Math.log(n)) + 1) / 1;
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            int index = num % n;
            result[count - 1 - i] = ch[index];
            num /= n;
        }
        return result;
    }
}