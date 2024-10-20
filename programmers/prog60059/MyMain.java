package prog60059;

import java.util.Arrays;

/* 멀쩡한 사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] key = {
                { 0, 0, 0 },
                { 1, 0, 0 },
                { 0, 1, 1 }
        };
        int[][] lock = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(key, lock));
    }
}

class Solution {
    int kMax;
    int lMax;

    public boolean solution(int[][] key, int[][] lock) {
        lMax = lock.length;
        kMax = key.length;
        int[][] keyExpand = new int[kMax + 2 * (lMax - 1)][kMax + 2 * (lMax - 1)];

        for (int i = 0; i <= 3; i++) {
            int[][] keyRotated = rotate(key, i);
            for (int j = 0; j < keyExpand.length; j++) {
                Arrays.fill(keyExpand[j], -1);
            }
            for (int y = lMax - 1; y < keyExpand.length - (lMax - 1); y++) {
                for (int x = (lMax - 1); x < keyExpand.length - (lMax - 1); x++) {
                    keyExpand[y][x] = keyRotated[y - (lMax - 1)][x - (lMax - 1)];
                }
            }
            printArray(i + ":", keyExpand);
            if (matchAllKey(keyExpand, lock)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchAllKey(int[][] keyExpand, int[][] lock) {
        for (int y = 0; y <= keyExpand.length - lock.length; y++) {
            for (int x = 0; x <= keyExpand[0].length - lock[0].length; x++) {
                if (checklock(keyExpand, y, x, lock)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checklock(int[][] keyExpand, int sY, int sX, int[][] lock) {
        for (int y = sY; y < lock.length + sY; y++) {
            for (int x = sX; x < lock.length + sX; x++) {
                if (keyExpand[y][x] == -1 && lock[y - sY][x - sX] == 1) {

                } else if (keyExpand[y][x] != -1 && lock[y - sY][x - sX] != keyExpand[y][x]) {

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private void printArray(String string, int[][] keyExpand) {
        System.out.println(string);
        for (int i = 0; i < keyExpand.length; i++) {
            System.out.println(Arrays.toString(keyExpand[i]));
        }
    }

    private int[][] rotate(int[][] from, int rCount) {
        if (rCount == 0)
            return from;
        int[][] rotated = new int[kMax][kMax];
        for (int i = 0; i < rCount; i++) {
            rotated = new int[kMax][kMax];
            for (int y = 0; y < kMax; y++) {
                for (int x = 0; x < kMax; x++) {
                    rotated[x][kMax - y - 1] = from[y][x];
                }
            }
            from = rotated;
        }
        return rotated;
    }
}