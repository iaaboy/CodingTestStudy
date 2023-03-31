package prog0331;

//160585

import java.util.*;

class MyMain {
    public static void main(String[] args) {
        String[][] board = {
            {"OOO", "XX.", "X.."}, //1
            {"OOO", "XOX", "XXO"} //1 << 중요 case
        };

        for(String[] str : board)
            System.out.println(new Solution().solution(str));
    }
}

class Solution {
    HashMap<String, Integer> lineHash = new HashMap<String, Integer>();
    int totalOLine = 0;
    int totalXLine = 0;
    int countO = 0;
    int countX = 0;
    public int solution(String[] board) {

        lineHash.put("OOO", 1);
        lineHash.put("XXX", 2);

        //가로줄
        for(String bd : board) {
            checkLine(bd);
        }

        //세로줄
        for(int i = 0; i< board[0].length() ; i++) {
            String ab = new String();
            ab += board[0].charAt(i);
            ab += board[1].charAt(i);
            ab += board[2].charAt(i);
            checkLine(ab);
        }

        String a = new String();
        a += board[0].charAt(0);
        a += board[1].charAt(1);
        a += board[2].charAt(2);
        checkLine(a);
        String b = new String();
        b += board[0].charAt(2);
        b += board[1].charAt(1);
        b += board[2].charAt(0);
        checkLine(b);

        countOX(board);

        if(countX > countO) {
            return 0;
        }

        if((totalOLine == 1 || totalOLine == 2)  && totalXLine == 0) {
            //O가 하나 많아야 함
            if(countO-countX == 1) {
                return 1;
            }
        } else if (totalXLine == 1 && totalOLine == 0) {
            //O랑 X랑 같아야함
            if(countO == countX) {
                return 1;
            }
        } else if (totalXLine == 0 && totalOLine == 0) {
            if((countO==countX) || (countO-countX == 1)) {
                return 1;
            }
        }
        return 0;
    }

    private void countOX(String[] bd) {
        for(String str : bd) {
            for(char aa : str.toCharArray()) {
                if(aa == 'O') {
                    countO ++;
                } else if(aa == 'X') {
                    countX ++;
                }
            }
        }
    }

    private void checkLine (String inStr) {
        //System.out.println(inStr + " : " + lineHash.get(inStr));
        if(lineHash.containsKey(inStr)) {
            if(lineHash.get(inStr) == 1) {
                totalOLine++;
            } else {
                totalXLine++;
            }
        }
    }
}