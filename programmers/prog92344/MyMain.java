package prog92344;

import java.util.*;

/* 파괴되지 않은 건물
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] boards = { { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } },
                { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } } };
        int[][][] skills = { {
                { 1, 0, 0, 3, 4, 4 },
                { 1, 2, 0, 2, 3, 2 },
                { 2, 1, 0, 3, 1, 2 },
                { 1, 0, 1, 3, 3, 1 } },

                { { 1, 1, 1, 2, 2, 4 },
                        { 1, 0, 0, 1, 1, 2 },
                        { 2, 2, 0, 2, 0, 100 } } };

        Solution mSol = new Solution();
        for (int i = 1; i < 2; i++) {
            System.out.println(mSol.solution(boards[i], skills[i]));
        }
    }
}

class Solution {
    int[][] board, skill;
    Integer [] index;

    public int solution(int[][] board, int[][] skill) {
        this.board = board;
        this.skill = skill;
        int count = 0;

        int[][] accumulated = new int[board.length+1][board[0].length+1];

        //skill들에 대해 누적합 적용
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = (type == 2) ? -s[5] : s[5];
            accumulated[r1][c1] -= degree;
            accumulated[r1][c2 + 1] += degree;
            accumulated[r2 + 1][c1] += degree;
            accumulated[r2 + 1][c2 + 1] -= degree;
        }

        for(int [] ac : accumulated)
            System.out.println(Arrays.toString(ac));

        //가로 누적합 계산
        for (int i = 0; i < accumulated.length - 1; i++) {
            for (int j = 0; j < accumulated[0].length - 1; j++) {
                accumulated[i][j + 1] += accumulated[i][j];
            }
        }
        System.out.println();
        for(int [] ac : accumulated)
            System.out.println(Arrays.toString(ac));

        //세로 누적합 계산
        for (int i = 0; i < accumulated.length - 1; i++) {
            for (int j = 0; j < accumulated[0].length - 1; j++) {
                accumulated[i + 1][j] += accumulated[i][j];
            }
        }
        
        System.out.println();
        for(int [] ac : accumulated)
            System.out.println(Arrays.toString(ac));

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += accumulated[i][j];
                if (board[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}