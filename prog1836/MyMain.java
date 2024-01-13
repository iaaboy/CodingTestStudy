package prog1836;

import java.util.*;

/* 리틀 프렌즈 사천성
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3, 2, 4, 2 };
        int[] n = { 3, 3, 4, 4, 2 };
        String[][] board = {
                {"AZA", "BZB", "***"},
                { "DBA", "C*A", "CDB" }, // "ABCD"
                { "NRYN", "ARYA" }, // "RYAN"
                { ".ZI.", "M.**", "MZU.", ".IU." }, // "MUZI"
                { "AB", "BA" } // "IMPOSSIBLE"
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(m[i], n[i], board[i]));
        }
    }
}

class Solution {
    StringBuilder[] board;
    HashMap<Character, Vertex> chMap;

    public String solution(int m, int n, String[] board) { // m 세로, n 가로
        chMap = new HashMap<>();
        this.board = new StringBuilder[board.length];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = new StringBuilder();
            this.board[i].append(board[i]);
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y].charAt(x) > 'Z' || board[y].charAt(x) < 'A')
                    continue;
                if (!chMap.containsKey(board[y].charAt(x))) {
                    chMap.put(board[y].charAt(x), new Vertex(y, x));
                } else {
                    chMap.get(board[y].charAt(x)).m2 = y;
                    chMap.get(board[y].charAt(x)).n2 = x;
                }
            }
        }

        // System.out.println(chMap);

        answer = new StringBuilder();
        isFinish = false;

        Character[] chList = new Character[chMap.size()];
        chMap.keySet().toArray(chList);
        Arrays.sort(chList);
        // System.out.println(Arrays.toString(chList));
        journey(chList, 0);
        return !isFinish ? "IMPOSSIBLE" : answer.toString();
    }

    boolean isFinish;
    StringBuilder answer;

    boolean journey(Character[] inChar, int depth) {
        // System.out.println("journey<" + depth + ">:" + Arrays.toString(inChar));
        // for(int i = 0; i< board.length ; i ++) {
        //     System.out.println(board[i].toString());
        // }
        if (depth == inChar.length - 1 || isFinish) {
            if (checkPath(inChar[depth])) {
                // System.out.println("Succeed : " + Arrays.toString(inChar));
                for (char ch : inChar) {
                    answer.append(ch);
                }
                isFinish = true;
                return true;
            } else {
                return false;
            }
        }

        ArrayList<Character> inCpdChar = new ArrayList<>();
        for (int i = depth; i < inChar.length; i++) {
            inCpdChar.add(inChar[i]);
        }
        inCpdChar.sort(null);
        for (int i = depth; i < inChar.length; i++) {
            inChar[i] = inCpdChar.get(i-depth);
        }
        for (int i = depth; i < inChar.length; i++) {
            char curCh = inChar[i];
            if (checkPath(curCh)) {
                // update path val
                board[chMap.get(curCh).m1].setCharAt(chMap.get(curCh).n1, '.');
                board[chMap.get(curCh).m2].setCharAt(chMap.get(curCh).n2, '.');
                // switch
                switchVal(inChar, depth, i);
                if (journey(inChar, depth + 1)) {
                    return true;
                }
                switchVal(inChar, i, depth);
                // restore path val
                board[chMap.get(curCh).m1].setCharAt(chMap.get(curCh).n1, curCh);
                board[chMap.get(curCh).m2].setCharAt(chMap.get(curCh).n2, curCh);
            } else {
                // System.out.println("fail:" + inChar[depth]);
            }
            // revert
        }

        return false;
    }

    boolean isMeOrRoute(int y, int x, char me) {
        return (board[y].charAt(x) == '.' || board[y].charAt(x) == me);
    }

    boolean checkPath(Character ch) {
        int y1 = chMap.get(ch).m1;
        int y2 = chMap.get(ch).m2;
        int x1 = chMap.get(ch).n1;
        int x2 = chMap.get(ch).n2;

        if (x1 == x2) { // n2 == n1;
            // check m1 -> m2
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                if (!isMeOrRoute(y, x1, ch)) {
                    return false;
                }
            }
            return true;
        } else if (y1 == y2) { // m2 == m1
            // check n1 -> n2
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                if (!isMeOrRoute(y1, x, ch)) {
                    return false;
                }
            }
            return true;
        } else {
            boolean isPassed = true;

            //y1 고정 x1 - x2
            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2) ; x++) {
                if (!isMeOrRoute(y1, x, ch)) {
                    isPassed = false;
                    break;
                }
            }
            //x2 고정 y1 - y2
            for(int y = Math.min(y1, y2) ; y <= Math.max(y1, y2) ; y++) {
                if (isPassed == false || !isMeOrRoute(y, x2, ch)) {
                    isPassed = false;
                    break;
                }
            }
            if(isPassed) {
                return true;
            }
            isPassed = true;
            //y2 고정 x1 - x2
            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2) ; x++) {
                if (!isMeOrRoute(y2, x, ch)) {
                    isPassed = false;
                    break;
                }
            }
            //x1 고정 y1 - y2
            for(int y = Math.min(y1, y2) ; y <= Math.max(y1, y2) ; y++) {
                if (isPassed == false || !isMeOrRoute(y, x1, ch)) {
                    isPassed = false;
                    break;
                }
            }
            if(isPassed) {
                return true;
            }
            return false;
        }
    };

    void switchVal(Character[] inChar, int from, int to) {
        char temp = inChar[from];
        inChar[from] = inChar[to];
        inChar[to] = temp;
    }

    class Vertex {
        int m1, n1;
        int m2, n2;

        public Vertex(int m1, int n1) {
            this.m1 = m1;
            this.n1 = n1;
        }

        @Override
        public String toString() {
            return "<" + +m1 + "," + n1 + "~" + m2 + "," + n2 + ">";
        }
    }
}