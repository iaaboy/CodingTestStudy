package prog1836;

import java.util.*;

/* 리틀 프렌즈 사천성
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3, 2, 4, 2 };
        int[] n = { 3, 3, 4, 4, 2 };
        String[][] thisboard = {
                { "AZA", "BZB", "***" },
                { "DBA", "C*A", "CDB" }, // "ABCD"
                { "NRYN", "ARYA" }, // "RYAN"
                { ".ZI.", "M.**", "MZU.", ".IU." }, // "MUZI"
                { "AB", "BA" } // "IMPOSSIBLE"
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 5; i++) {
            System.out.println(mSol.solution(m[i], n[i], thisboard[i]));
        }
    }
}

class Solution {

    public String solution(int m, int n, String[] board) { // m 세로, n 가로
        StringBuilder[] thisboard;
        HashMap<Character, Vertex> chMap;
        chMap = new HashMap<>();
        thisboard = new StringBuilder[board.length];
        for (int i = 0; i < thisboard.length; i++) {
            thisboard[i] = new StringBuilder();
            thisboard[i].append(board[i]);
        }

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (thisboard[y].charAt(x) > 'Z' || thisboard[y].charAt(x) < 'A')
                    continue;
                if (!chMap.containsKey(thisboard[y].charAt(x))) {
                    chMap.put(thisboard[y].charAt(x), new Vertex(y, x));
                } else {
                    chMap.get(thisboard[y].charAt(x)).m2 = y;
                    chMap.get(thisboard[y].charAt(x)).n2 = x;
                }
            }
        }

        // System.out.println(chMap);

        answer = new StringBuilder();
        isFinish = false;

        TreeSet<Character> chList = new TreeSet<>(chMap.keySet());
        // System.out.println(chList);
        journey(thisboard, chMap, chList);
        return !isFinish ? "IMPOSSIBLE" : answer.toString();
    }

    boolean isFinish;
    StringBuilder answer;

    boolean journey(StringBuilder[] thisboard, HashMap<Character, Vertex> chMap, TreeSet<Character> inChar) {
        // System.out.println("journey<" + inChar);
        // for(int i = 0; i< thisboard.length ; i ++) {
        // System.out.println(thisboard[i].toString());
        // }
        if (inChar.size() == 1) {
            if (checkPath(thisboard, chMap, inChar.first())) {
                System.out.println("Succeed : " + inChar.first());
                for (char ch : inChar) {
                    answer.append(ch);
                }
                isFinish = true;
                return true;
            } else {
                return false;
            }
        }

        Iterator<Character> aa = inChar.iterator();
        while (aa.hasNext()) {
            char curCh = aa.next();
            if (checkPath(thisboard, chMap, curCh)) {
                // update path val
                // System.out.println("suceed: " + curCh);
                thisboard[chMap.get(curCh).m1].setCharAt(chMap.get(curCh).n1, '.');
                thisboard[chMap.get(curCh).m2].setCharAt(chMap.get(curCh).n2, '.');
                // switch
                TreeSet<Character> secondary = new TreeSet<>(inChar);
                answer.append(curCh);
                secondary.remove(curCh);
                if (journey(thisboard, chMap, secondary)) {
                    return true;
                }
                // restore path val
                // System.out.println("remove it?: " + curCh);
                thisboard[chMap.get(curCh).m1].setCharAt(chMap.get(curCh).n1, curCh);
                thisboard[chMap.get(curCh).m2].setCharAt(chMap.get(curCh).n2, curCh);
            }
        }
        return false;
    }

    boolean isMeOrRoute(StringBuilder[] thisboard, int y, int x, char me) {
        return (thisboard[y].charAt(x) == '.' || thisboard[y].charAt(x) == me);
    }

    boolean checkPath(StringBuilder[] thisboard, HashMap<Character, Vertex> chMap, Character ch) {
        int y1 = chMap.get(ch).m1;
        int y2 = chMap.get(ch).m2;
        int x1 = chMap.get(ch).n1;
        int x2 = chMap.get(ch).n2;

        if (x1 == x2) { // n2 == n1;
            // check m1 -> m2
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                if (!isMeOrRoute(thisboard, y, x1, ch)) {
                    return false;
                }
            }
            return true;
        } else if (y1 == y2) { // m2 == m1
            // check n1 -> n2
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                if (!isMeOrRoute(thisboard, y1, x, ch)) {
                    return false;
                }
            }
            return true;
        } else {
            boolean isPassed = true;

            // y1 고정 x1 - x2
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                if (!isMeOrRoute(thisboard, y1, x, ch)) {
                    isPassed = false;
                    break;
                }
            }
            // x2 고정 y1 - y2
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                if (isPassed == false || !isMeOrRoute(thisboard, y, x2, ch)) {
                    isPassed = false;
                    break;
                }
            }
            if (isPassed) {
                return true;
            }
            isPassed = true;
            // y2 고정 x1 - x2
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                if (!isMeOrRoute(thisboard, y2, x, ch)) {
                    isPassed = false;
                    break;
                }
            }
            // x1 고정 y1 - y2
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                if (isPassed == false || !isMeOrRoute(thisboard, y, x1, ch)) {
                    isPassed = false;
                    break;
                }
            }
            if (isPassed) {
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