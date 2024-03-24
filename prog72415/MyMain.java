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
    int[][] board;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        mCount = 0;
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

        System.out.println(card);

        dfs(card, r, c, 0);
        int answer = 0;
        return answer;
    }

    int mCount = 0;

    private void dfs(HashMap<Integer, Card> card, int r, int c, int curCount) {
        printAll(card, board);
        if (checkAll(board)) {
            mCount = Math.max(mCount, curCount);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[j][i] > 0 && board[j][i] < 7) {
                    if (!card.get(board[j][i]).isClear) {
                        // 1 이동
                        int moveCount = move(r, c, j, i);

                        // check clear
                        Card cCard = card.get(board[j][i]);
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
                        dfs(card, j, i, curCount + moveCount);

                        // 4 원복
                        board[cCard.r1][cCard.c1] = savedCard1;
                        board[cCard.r2][cCard.c2] = savedCard2;
                        cCard.isClear = false;
                    }
                }
            }
        }
    }

    private void printAll(HashMap<Integer, Card> card, int[][] bd) {
        if (card != null) {
            System.out.println(card);
        }
        for (int j = 0; j < bd.length; j++) {
            for (int i = 0; i < bd[0].length; i++) {
                System.out.print(bd[j][i] + " ");
            }
            System.out.println();
        }
    }

    private int move(int r, int c, int targetR, int targetC) {
        int[][] map = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[j][i] != 0) {
                    if (i == targetC && j == targetR) {
                        map[j][i] = Integer.MAX_VALUE;
                    } else {

                    }
                } else {
                    map[j][i] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<Location> mQ = new LinkedList<>();
        mQ.add(new Location(r, c, 0));

        printAll(null, map);

        while (!mQ.isEmpty()) {
            Location cL = mQ.poll();

            for(int i = 0 ; i < 4 ; i++) {
                int curR = cL.r + pR[i];
                int curC = cL.c + pC[i];

                //종점(-1, 4)일때

                //오버일 때

                //
            }
            
        }

        printAll(null, map);
        return map[targetR][targetC];
    }

    int [] pC = {1, 0, -1, 0};
    int [] pR = {0, 1, 0, -1};

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

    class Location {
        int c;
        int r;
        int horizon;// 1가로 2세로 0둘다

        public Location(int r, int c, int horizon) {
            this.c = c;
            this.r = r;
            this.horizon = horizon;
        }

        @Override
        public String toString() {
            return r + "," + c + "," + horizon;
        }
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
                r2 = r;
                c2 = c;
            }
        }

        @Override
        public String toString() {
            return r1 + "," + c1 + ":" + r2 + "," + c2 + "," + isClear;
        }
    }
}