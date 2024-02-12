package prog1836;

import java.util.*;

/* 리틀 프렌즈 사천성
 * https://school.programmers.co.kr/learn/courses/30/lessons/1836
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3, 2, 4, 2, 5};
        int[] n = { 3, 3, 4, 4, 2, 5};
        String[][] thisboard = {
                { "AZA", "BZB", "***" },
                { "DBA", "C*A", "CDB" }, // "ABCD"
                { "NRYN", "ARYA" }, // "RYAN"
                { ".ZI.", "M.**", "MZU.", ".IU." }, // "MUZI"
                { "AB", "BA" }, // "IMPOSSIBLE",
                { "FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"}
        };
        Solution mSol = new Solution();
        for (int i = 1; i < 5; i++) {
            System.out.println(mSol.solution(m[i], n[i], thisboard[i]));
        }
    }
}

class Solution {

    public String solution(int m, int n, String[] board) {

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                
            }
        }

        return "IMPOSSIBLE";
    }
}