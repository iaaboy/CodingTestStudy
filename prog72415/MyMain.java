package prog72415;

import java.util.*;

/* 카드 짝 맞추기
 * https://school.programmers.co.kr/learn/courses/30/lessons/72415
 */

public class MyMain {
    public static void main(String[] args) {
        int[][][] board = {
                { { 1, 0, 0, 3 },
                        { 2, 0, 0, 0 },
                        { 0, 0, 0, 2 },
                        { 3, 0, 1, 0 } }, // 14
                { { 3, 0, 0, 2 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 3 } } // 16
        };
        int[] r = { 1, 0 };
        int[] c = { 0, 1 };
        Solution mSol = new Solution();

        for (int i = 0; i < 2; i++) {
            System.out.println(mSol.solution(board[i], r[i], c[i]));
        }
    }
}

class Solution {
    public int solution(int[][] board, int r, int c) {
        mCount = Integer.MAX_VALUE;
        HashMap<Integer, Card> card = new HashMap<>();
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] != 0) {
                    if (!card.containsKey(board[j][i])) {
                        card.put(board[j][i], new Card());
                    }
                    card.get(board[j][i]).put(j, i);
                }
            }
        }

        dfs(board, card, r, c, 0);
        int answer = 0;
        return answer;
    }

    int mCount = 0;

    private void dfs(int[][] board, HashMap<Integer, Card> card, int r, int c, int curCount) {
        if (checkAll(board)) {
            mCount = Math.max(mCount, curCount);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] > 1 && board[j][i] < 7) {
                    if (card.get(board[j][i]).isClear) {
                        // 1 이동
                        int moveCount = move(r, c, j, i, 0);

                        // check clear
                        Card cCard = card.get(board[j][i] - 10);
                        int savedCard1 = board[cCard.r1][cCard.c1];
                        int savedCard2 = board[cCard.r2][cCard.c2];

                        // 2 뒤집기
                        board[j][i] = 10 + board[j][i];
                        if (board[cCard.r1][cCard.c1] > 10 && board[cCard.r2][cCard.c2] > 10) {
                            board[cCard.r1][cCard.c1] = 0;
                            board[cCard.r2][cCard.c2] = 0;
                            cCard.isClear = true;
                        }

                        // 3 콜 dfs
                        dfs(board, card, j, i, curCount + moveCount);

                        // 4 원복
                        board[cCard.r1][cCard.c1] = savedCard1;
                        board[cCard.r2][cCard.c2] = savedCard2;
                        cCard.isClear = true;
                    }
                }
            }
        }
    }

    private int move(int r, int c, int targetR, int targetC, int curCount) {
        
        return -1;
    }

    private boolean checkAll(int[][] board) {
        // TODO map 확인하는거로 수정
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    class Card {
        int c1 = -1;
        int r1 = -1;
        int c2 = -1;
        int r2 = -1;
        boolean isClear = false;

        void put(int r, int c) {
            if (c1 == -1) {
                r1 = r;
                c1 = c;
            } else {
                r1 = r;
                c2 = c;
            }
        }

        @Override
        public String toString() {
            return r1 + "," + c1 + ",," + r2 + "," + c2 + "," + isClear;
        }
    }
}