package prog60059;

import java.util.Arrays;

/* 멀쩡한 사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */

public class MyMain {
    public static void main(String[] args) {
        // int[][] key = {
        // { 0, 0, 1 },
        // { 0, 1, 0 },
        // { 0, 1, 1 } };
        int[][] key = { 
            { 0, 0, 0 }, 
            { 1, 0, 0 },
            { 0, 1, 1 }};
        int[][] lock = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(key, lock));
    }
}

class Solution {
    int n;
    int nMask;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        int[] keyInt = new int[n];
        int[] lockInt = new int[n];
        for (int i = 0; i < n; i++) {
            nMask |= (1 << i);
        }

        lockInt = toInt(lock);
        printArray("lock ", lockInt, true);
        for (int i = 0; i < 3; i++) {
            keyInt = rotate(key, i);
            if (matchKeyUpDown(lockInt, keyInt))
                return true;
        }
        return false;
    }

    private boolean matchKeyUpDown(int[] lockInt, int[] keyInt) {
        boolean result;
        printArray("key", keyInt, true);
        Loop1: // 아래로 shift
        for (int nShift = 0; nShift < n; nShift++) {
            result = true;
            for (int i = 0; i < nShift; i++) { // 락만 비교
                if (((~lockInt[i] & nMask) != 0)) {
                    result = false;
                    continue Loop1;
                }
            }
            for (int i = nShift; i < n; i++) { // 락 & 키 비교
                if (((lockInt[i] & nMask) != (~keyInt[i - nShift] & nMask))) {
                    result = false;
                    continue Loop1;
                }
            }
            if (result) {
                return true;
            }
        }
        Loop2: // 위로 shift
        for (int nShift = 0; nShift < n; nShift++) {
            result = true;
            for (int i = 0; i < nShift; i++) { // 락 & 키 비교
                if (((lockInt[i] & nMask) != (~keyInt[i + nShift] & nMask))) {
                    result = false;
                    continue Loop2;
                }
            }
            for (int i = nShift; i < n; i++) { // 락만 비교
                if (((~lockInt[i] & nMask) != 0)) {
                    result = false;
                    continue Loop2;
                }
            }
            if (result) {
                return true;
            }
        }
        Loop3: // 좌로 shift
        for (int nShift = 0; nShift < n; nShift++) {
            result = true;
            for (int i = 0; i < n; i++) { // 락만 비교
                if (((lockInt[i] & nMask) != (~keyInt[i] << nShift & nMask))) {
                    result = false;
                    continue Loop3;
                }
            }
            if (result) {
                return true;
            }
        }
        Loop4: // 좌로 shift
        for (int nShift = 0; nShift < n; nShift++) {
            result = true;
            for (int i = 0; i < n; i++) { // 락만 비교
                if (((lockInt[i] & nMask) != (~keyInt[i] >> nShift & nMask))) {
                    result = false;
                    continue Loop4;
                }
            }
            if (result) {
                return true;
            }
        }
        return false;
    }

    void printArray(String msg, int[] arr, boolean hex) {
        if (hex) {
            for (int i = 0; i < n; i++) {
                System.out.println(Integer.toBinaryString(arr[i]));
            }
        } else
            System.out.println(msg + Arrays.toString(arr));
    }

    private int[] rotate(int[][] from, int rCount) {
        int[][] rotated = rCount == 0 ? from : new int[n][n]; // rCount 0 이면 rotate안하고, from 바로 사용
        for (int i = 0; i < rCount; i++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    rotated[x][n - y - 1] = from[y][x];
                }
            }
            from = rotated;
        }
        return toInt(rotated);
    }

    private int[] toInt(int[][] arr) {
        int[] result = new int[n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result[y] |= (arr[y][x] << (n - x - 1));
            }
        }
        return result;
    }
}