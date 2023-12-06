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
        for (int i = 0; i < 2; i++) {
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

        index = new Integer [skill.length];

        for(int i = 0; i<skill.length ; i++) {
            index[i] = i;
        }

        // System.out.println(Arrays.toString(index));

        // printBoard();

        Arrays.sort(index, (Integer a, Integer b) -> {
            if (skill[a][0] == skill[b][0]) {
                if (skill[a][0] == 1) {// 1이면 파괴, //2면 회복
                    return skill[b][5] - skill[a][5];
                } else {
                    return skill[a][5] - skill[b][5];
                }
            } else {
                return skill[a][0] - skill[b][0];
            }
        });

        // System.out.println(Arrays.toString(index));

        // printSkill();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (calculate(board[y][x], y, x))
                    count++;
            }
        }
        return count;
    }

    // 1 y1, 2 x1 3 y2, 4 x2
    boolean calculate(int num, int y, int x) {
        for (int i = 0; i < skill.length; i++) {
            int currentIdx = index[i];
            if (skill[currentIdx][0] != 1)
                break;
            
            if (skill[currentIdx][1] > y || skill[currentIdx][3] < y || skill[currentIdx][2] > x || skill[currentIdx][4] < x)
                continue;

            num -= skill[currentIdx][5];
        }

        if (num >= 1) {
            return true;
        }

        for (int i = skill.length - 1; i >= 0; i--) {
            int currentIdx = index[i];
            if (skill[currentIdx][0] != 2)
                break;

            if (skill[currentIdx][1] > y || skill[currentIdx][3] < y || skill[currentIdx][2] > x || skill[currentIdx][4] < x)
                continue;

            num += skill[currentIdx][5];
            if (num >= 1)
                break;
        }
        return num >= 1 ? true : false;
    }

    void printBoard() {
        for (int[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }

    void printSkill() {
        System.out.println(Arrays.toString(index));
        for (int[] s : skill) {
            System.out.println(Arrays.toString(s));
        }
    }
}