package prog17679;

import java.util.*;

/* [1차] 프렌즈4블록
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */

public class MyMain {
    public static void main(String[] args) {
        String[] board = {
                "CCBDE", "AAADE", "AAABF", "CCBBF"
                // "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
        };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(0, 0, board));
    }
}

class Solution {
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        char[][] chBd = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            chBd[i] = board[i].toCharArray();
        }

        answer = 0;

        printArr(chBd);

        boolean hasSquare = true;
        while (hasSquare) {
            hasSquare = checkBoard(chBd);
        }

        return answer;
    }

    private void printArr(char[][] chBd) {
        // System.out.println();
        // for (int y = 0; y < chBd.length; y++) {
        // for (int x = 0; x < chBd[y].length; x++) {
        // System.out.print(chBd[y][x]);
        // }
        // System.out.println();
        // }
    }

    private boolean checkBoard(char[][] board) {
        ArrayList<Pair> removeCandi = new ArrayList<>();
        for (int y = 0; y < board.length - 1; y++) {
            for (int x = 0; x < board[y].length - 1; x++) {
                if (board[y][x] != 'z' && board[y][x] == board[y][x + 1] && board[y][x] == board[y + 1][x]
                        && board[y][x] == board[y + 1][x + 1]) {
                    // add candi
                    removeCandi.add(new Pair(y, x));
                }
            }
        }
        // System.out.println(removeCandi);
        if (removeCandi.size() > 0) {
            updateString(board, removeCandi);
        }

        printArr(board);

        return removeCandi.size() != 0;
    }

    private void updateString(char[][] board, ArrayList<Pair> removeCandi) {
        for (Pair pair : removeCandi) {
            board[pair.y][pair.x] = '0';
            board[pair.y][pair.x + 1] = '0';
            board[pair.y + 1][pair.x] = '0';
            board[pair.y + 1][pair.x + 1] = '0';
        }
        printArr(board);

        for (int i = 0; i < board[0].length; i++) {
            char[] temp = new char[board.length];
            int dummyCount = 0;
            int idx = 0;
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] == '0') {
                    dummyCount++;
                } else {
                    temp[idx++] = board[j][i];
                }
            }
            if (dummyCount == 0)
                continue;
            answer += dummyCount;
            idx = 0;
            for (int j = board.length - 1; j >= 0; j--) {
                if (j < dummyCount) {
                    board[j][i] = 'z';
                } else {
                    board[j][i] = temp[idx++];
                }
            }
        }
    }

    class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x;
        }
    }
}