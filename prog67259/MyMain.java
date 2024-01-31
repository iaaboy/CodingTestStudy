package prog67259;

import java.util.*;

/* 경주로 건설
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] boards = {
                { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, // 900
                { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } }, // 3800
                { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } }, // 2100
                { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } }, // 3200
        };

        Solution mSol = new Solution();
        for (int[][] board : boards) {
            System.out.println(mSol.solution(board));
            // break;
        }
    }
}

class Solution {
    int n;
    int[] offsetX = { 1, 0, -1, 0 };
    int[] offsetY = { 0, 1, 0, -1 };

    public int solution(int[][] board) {
        n = board.length;
        int[][] sums = new int[n][n];
        Arrays.stream(sums).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        dp(sums, board, 0, 0, 0, 0);
        return sums[n - 1][n - 1];
    }

    public void dp(int[][] sums, int[][] board, int direction, int sum, int y, int x) {
        System.out.println("<" + y + "," + x + ">" + direction);
        if (x < 0 || y < 0 || x >= n || y >= n || board[y][x] == 1) // 좌표 범위 밖이면 방문 안함
            return;
        if (sums[y][x] != Integer.MAX_VALUE && sums[y][x] + 500 < sum) // 다음 좌표가 500보다 크면 방문 안함
            return;

        sums[y][x] = Math.min(sums[y][x], sum);

        for (int dir = 0; dir < 4; dir++) {
            if (y == 0 && x == 0) {
                dp(sums, board, dir, sum + 100, y + offsetY[dir], y + offsetX[dir]);
                continue;
            }
            if (direction == dir)
                dp(sums, board, dir, sum + 100, y + offsetY[dir], x + offsetX[dir]);
            else
                dp(sums, board, dir, sum + 600, y + offsetY[dir], x + offsetX[dir]);
        }
    }
}