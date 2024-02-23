package prog12907;

/* 거스름돈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12907
 */

class MyMain {
    public static void main(String[] args) {
        int n = 6;
        int[] money = { 1, 2, 3 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, money));
    }
}

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] += dp[i - m];
            }
        }
        return dp[n];
    }
}