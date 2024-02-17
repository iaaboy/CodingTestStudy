package prog60059;

import java.util.Arrays;
import java.util.BitSet;

/* 멀쩡한 사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] key = { 
            { 0, 0, 1 },
            { 0, 1, 0 },
            { 0, 1, 1 } };
        //int[][] key = { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 1, 0 } };
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
    int lockIgnore;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        int[] keyInt = new int[n];
        int[] lockInt = new int[n];

        for (int i = 0; i < n; i++) {
            lockIgnore |= (1 << i);
        }
        
        //앞에 붙은 0000XXX .. 0000을 바꿔야함.

        lockInt = rotate(lock, 0);
        for(int i = 0 ; i < n ; i++) {
            lockInt[i] = lockInt[i] | ~lockIgnore;
        }
        printArray("lock ", lockInt, true);
        for (int i = 0; i < 3; i++) {
            keyInt = rotate(key, i);
            if (matchKey(lockInt, keyInt))
                return true;
        }
        return false;
    }

    private boolean matchKey(int[] lockInt, int[] keyInt) {
        boolean result = false;
        printArray("key", keyInt, true);
        for (int key = 0; key < n; key++) {
            result = true;
            for (int i = 0; i < n; i++) {
                if (i < key) {
                    // 락만 비교
                    System.out.println("check lock " + Integer.toBinaryString(~lockInt[i]));
                    if ((~lockInt[i] != 0)) {
                        result = false;
                        break;
                    }
                } else {
                    // 락 & 키 비교
                    System.out.println("compare key and lock");
                    System.out.println("lock: " + Integer.toBinaryString(lockInt[i]));
                    System.out.println("key: " + Integer.toBinaryString(~keyInt[i - key]) + " <<< " + Integer.toBinaryString(keyInt[i - key]));
                    if ((lockInt[i] != ~keyInt[i - key])) {
                        result = false;
                        break;
                    }
                }
            }
            if(result) {
                return true;
            }
        }
        return false;
    }
    void printArray(String msg, int[] arr, boolean hex) {
        if(hex) {
            for(int i = 0; i < n ; i++ ) {
                System.out.println(Integer.toBinaryString(arr[i]));
            }
        } else 
            System.out.println(msg + Arrays.toString(arr));
    }

    private int[] rotate(int[][] from, int rCount) {
        int[][] rotated = rCount == 0 ? from : new int[n][n]; // rCount 0 이면 rotate안하고, from 바로 사용
        int[] result = new int[n];
        for (int i = 0; i < rCount; i++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    rotated[x][n - y - 1] = from[y][x];
                }
            }
            from = rotated;
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result[y] |= (rotated[y][x] << (n-x -1));
            }
        }
        return result;
    }
}