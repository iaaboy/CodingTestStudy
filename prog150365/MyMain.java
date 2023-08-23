package prog150365;

/* 미로 탈출 명령어
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 */

public class MyMain {
    public static void main(String[] args) {
        // n m x y r c k result
        // 3 4 2 3 3 1 5 "dllrl"
        // 2 2 1 1 2 2 2 "dr"
        // 3 3 1 2 3 3 4 "impossible"

        int[] n = { 3, 2, 3 };
        int[] m = { 4, 2, 3 };
        int[] x = { 2, 1, 1 };
        int[] y = { 3, 1, 2 };
        int[] r = { 3, 2, 3 };
        int[] c = { 1, 2, 3 };
        int[] k = { 5, 2, 4 };

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++)
            System.out.println(mSol.solution(n[i], m[i], x[i], y[i], r[i], c[i], k[i]));
    }
}

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        if (x == 0 && r == 0) {
            // 좌로 못 감.
        }
        if (x == m && r == m) {
            // 우로 못 감.
        }
        if (y == 0 && c == 0) {
            // 위로 못 감.
        }
        if (y == n && c == n) {
            // 아래로 못 감
        }

        // char lr;
        if (x > r) {

        } else if (x < r) {

        }

        // char ud;
        if (y > c) {

        } else {

        }

        return answer;
    }
}