package prog131703;

import java.util.*;

/**
 * 2차원 동전 뒤집기
 * https://school.programmers.co.kr/learn/courses/30/lessons/131703
 */

public class MyMain {
    public static void main(String[] args) {
        // int[][] beginning = { { 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 1 }, { 0, 1, 1, 1, 0
        // }, { 1, 0, 1, 1, 0 },
        // { 0, 1, 0, 1, 0 } };
        // int[][] target = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 1 }, {
        // 0, 0, 0, 1, 0 },
        // { 0, 0, 0, 0, 1 } };
        int[][] beginning = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 } };
        int[][] target = {
                { 1, 0, 1, 0, },
                { 0, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 0, 1, 0, 1 }, };
        // int[][] beginning = {
        // { 0, 0, 1, 0, 0 },
        // { 1, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0 },
        // };
        // int[][] target = {
        // { 0, 1, 0, 1, 1 },
        // { 0, 0, 0, 0, 0 },
        // { 1, 0, 0, 0, 0 },
        // { 1, 0, 0, 0, 0 },
        // { 1, 0, 0, 0, 0 }
        // };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(beginning, target));
    }
}

class Solution {
    boolean[][] diff;
    int xMax;
    int yMax;
    int flipCount = 0;
    int flipCountV = 0;

    public int solution(int[][] beginning, int[][] target) {
        xMax = beginning[0].length;
        yMax = beginning.length;
        diff = new boolean[yMax][xMax];

        for (int y = 0; y < yMax; y++)
            for (int x = 0; x < xMax; x++)
                diff[y][x] = (beginning[y][x] != target[y][x]) ? true : false;

        printCurrent("Initial");

        for (int x = 0; x < xMax; x++) {
            if (diff[0][x]) {
                flip(x, true);
                printCurrent("v flip:" + x);
            }
        }
        for (int y = 0; y < yMax; y++) {
            if (diff[y][0]) {
                flip(y, false);
                printCurrent("h flip; " + y);
            }
            if (!checkLine(y, true)) {
                return -1;
            }
        }

        /////
        flipCountV = flipCount;
        flipCount = 0;
        for (int y = 0; y < yMax; y++)
            for (int x = 0; x < xMax; x++)
                diff[y][x] = (beginning[y][x] != target[y][x]) ? true : false;

        printCurrent("Initial");

        for (int y = 0; y < yMax; y++) {
            if (diff[y][0]) {
                flip(y, false);
                printCurrent("h flip; " + y);
            }
        }
        for (int x = 0; x < xMax; x++) {
            if (diff[0][x]) {
                flip(x, true);
                printCurrent("v flip:" + x);
            }
            if (!checkLine(x, false)) {
                return -1;
            }
        }

        return Math.min(flipCountV, flipCount);
    }

    private boolean checkLine(int n, boolean isVertical) {
        if (isVertical) {
            for (int x = 0; x < xMax; x++) {
                if (diff[n][x]) {
                    return false;
                }
            }
        } else {
            for (int y = 0; y < yMax; y++) {
                if (diff[y][n]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void flip(int n, boolean isVertical) {
        flipCount++;
        if (isVertical) {
            for (int y = 0; y < yMax; y++)
                diff[y][n] = !diff[y][n];
        } else {
            for (int x = 0; x < xMax; x++)
                diff[n][x] = !diff[n][x];
        }
    }

    private void printCurrent(String msg) {
        System.out.println(msg);
        for (int y = 0; y < yMax; y++)
            System.out.println(Arrays.toString(diff[y]));
    }
}