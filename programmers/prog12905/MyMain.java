package prog12905;

import java.util.Arrays;

/* 가장 큰 정사각형 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12905
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] board = {
                {
                        { 0, 1, 1, 1 },
                        { 1, 1, 1, 1 },
                        { 1, 1, 1, 1 },
                        { 0, 0, 1, 0 } }, // 9
                { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } }, // 4
                { { 1, 0, },
                        { 0, 0, },
                }
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 3; i++)
            System.out.println("answer: " + mSol.solution(board[i]));
    }
}

class Solution {
    public int solution(int[][] board) {
        int answer = 1;

        boolean isAll0 = true;
        for (int[] bd : board) {
            for (int b : bd) {
                if (b != 0) {
                    isAll0 = false;
                    break;
                }
            }
        }
        if (isAll0) {
            return 0;
        }

        for (int j = 1; j < board.length; j++) {
            for (int i = 1; i < board[0].length; i++) {
                if (board[j][i] != 0) {
                    int linePre = Math.min(board[j - 1][i], board[j][i - 1]);
                    board[j][i] = Math.min(linePre, board[j - 1][i - 1]) + 1;
                    answer = Math.max(answer, board[j][i]);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        return answer * answer;
    }
}