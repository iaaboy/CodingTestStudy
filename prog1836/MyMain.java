package prog1836;

import java.util.*;

/* 리틀 프렌즈 사천성
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 2, 4, 2 };
        int[] n = { 3, 4, 4, 2 };
        String[][] board = {
                { ".ZI.", "M.**", "MZU.", ".IU." }, // "MUZI"
                { "DBA", "C*A", "CDB" }, // "ABCD"
                { "NRYN", "ARYA" }, // "RYAN"
                { "AB", "BA" } // "IMPOSSIBLE"
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(m[i], n[i], board[i]));
        }
    }
}

class Solution {
    String[] board;
    HashMap<Character, Vertex> chMap;

    public String solution(int m, int n, String[] board) { // m 세로, n 가로
        this.board = board;
        chMap = new HashMap<>();

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

        Character[] chList = new Character[chMap.size()];
        chMap.keySet().toArray(chList);
        journey(chList, 0);

        String answer = "";
        return answer;
    }

    boolean isFinish = false;

    void journey(Character[] inChar, int depth) {
        if (!checkPath(inChar[depth])) {
            // 안풀리면 다음 안가고 리턴,
            return;
        }
        if (depth == inChar.length - 1 || isFinish) {
            System.out.println("Success: " + Arrays.toString(inChar));
            return;
        }

        // update path val
        for (int i = depth; i < inChar.length; i++) {
            // switch
            switchVal(inChar, depth, i);
            journey(inChar, depth + 1);
            switchVal(inChar, i, depth);
            // revert
        }
        // restore path val
    }

    boolean checkPath(Character ch) {
        int stepY = (chMap.get(ch).m2 - chMap.get(ch).m1);
        stepY = stepY == 0 ? 0 : stepY / Math.abs(stepY);
        int stepX = (chMap.get(ch).n2 - chMap.get(ch).n1);
        stepX = stepX == 0 ? 0 : stepY / Math.abs(stepX);

        boolean xHasObst = false;
        boolean yHasObst = false;
        if (stepX != 0) {
            for (int x = chMap.get(ch).n1; x != chMap.get(ch).n2; x += stepX) {

            }
        }
        if (stepY != 0) {
            for (int y = chMap.get(ch).m2; y != chMap.get(ch).m2; y += stepY) {

            }
        }

        return false;
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
    }
}
