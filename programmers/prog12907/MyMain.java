package prog12907;


/* 거스름돈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12907
 */

class MyMain {
    public static void main(String[] args) {
        int n = 5;
        int[] money = { 1, 2, 5 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, money));
    }
}

class Solution {
    public int solution(int n, int[] money) {
        int[][] dpCoinCount = new int[money.length + 1][n + 1];

        dpCoinCount[0][0] = 1;

        for (int j = 1; j <= money.length; j++) {
            for (int i = 0; i <= n; i++) {
                if (i >= money[j - 1]) {
                    dpCoinCount[j][i] = dpCoinCount[j - 1][i] + dpCoinCount[j][i - money[j - 1]];
                } else {
                    dpCoinCount[j][i] = dpCoinCount[j - 1][i];
                }
            }
        }

        return dpCoinCount[money.length][n];
    }
}