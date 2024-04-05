package prog81302;

import java.util.Arrays;

/* 거리두기 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */

public class MyMain {
    public static void main(String[] args) {
        String[][] places = { {
                "POO0X",
                "OXX00",
                "P0XPX",
                "OOXOX",
                "POX00" },
                { 
                    "POOPX", 
                    "OXPXP", 
                    "PXXXO", 
                    "OXXXO", 
                    "OOOPP" },
                { 
                    "PXOPX", 
                    "OXOXP", 
                    "OXPOX", 
                    "OXXOP", 
                    "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        Solution mSol = new Solution();
        System.out.println("answer: " + Arrays.toString(mSol.solution(places)));
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    private boolean checkPlace(String[] place) {
        char[][] p = new char[place.length][place[0].length()];
        for (int i = 0; i < p.length; i++) {
            p[i] = place[i].toCharArray();
        }

        for (int j = 0; j < place.length; j++) {
            for (int i = 0; i < place[j].length(); i++) {
                if (p[j][i] == 'P') {
                    if (!checkDist(p, j, i)) {
                        // System.out.println("false at: " + j + "," + i);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkDist(char[][] place, int y, int x) {
        // up
        if (!check(place, y + 1, x, y + 2, x))
            return false;
        // down
        if (!check(place, y - 1, x, y - 2, x))
            return false;
        // left
        if (!check(place, y, x - 1, y, x - 2))
            return false;
        // rignt
        if (!check(place, y, x + 1, y, x + 2))
            return false;

        // opposite angle left up
        if (!check(place, y, x - 1, y + 1, x - 1))
            return false;
        if (!check(place, y + 1, x, y + 1, x - 1))
            return false;

        // left down
        if (!check(place, y, x - 1, y - 1, x - 1))
            return false;
        if (!check(place, y - 1, x, y - 1, x - 1))
            return false;

        // right up
        if (!check(place, y, x + 1, y + 1, x + 1))
            return false;
        if (!check(place, y + 1, x, y + 1, x + 1))
            return false;

        // right down
        if (!check(place, y, x + 1, y - 1, x + 1))
            return false;
        if (!check(place, y - 1, x, y - 1, x + 1))
            return false;

        return true;
    }

    // pass : true
    // fail : false, 거리두기 실패
    private boolean check(char[][] place, int y1, int x1, int y2, int x2) {
        if (y1 < 0 || y1 >= place.length || x1 < 0 || x1 >= place[0].length) {
            return true;
        }
        if (place[y1][x1] == 'P') {
            return false;
        }
        if (y2 < 0 || y2 >= place.length || x2 < 0 || x2 >= place[0].length) {
            return true;
        }
        if (place[y1][x1] == 'O' && place[y2][x2] == 'P') {
            return false;
        }
        return true;
    }
}