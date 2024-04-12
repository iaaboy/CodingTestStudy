package prog12900;

/* 2 x n 타일링
 https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 1; i < 6; i++) {
            System.out.println(mSol.solution(i));
        }

    }
}

class Solution {
    public int solution(int n) {
        int[] memo = new int[n + 2];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n + 2; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }
}