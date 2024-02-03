package prog12911;

/* 다음 큰 숫자 풀이
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 1; i < 100; i += 1)
            System.out.println(mSol.solution(i));
    }
}

class Solution {
    public int solution(int n) {
        int countIn = 0;
        for (char val : Integer.toBinaryString(n).toCharArray()) {
            if (val == '1') {
                countIn++;
            }
        }

        int i = n + 1;
        for (; i < n * 2; i++) {
            int countNext = 0;
            for (char val : Integer.toBinaryString(i).toCharArray()) {
                if (val == '1') {
                    countNext++;
                }
            }
            if (countIn == countNext) {
                break;
            }
        }
        return i;
    }
}