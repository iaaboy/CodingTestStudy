package prog12953;

import java.util.*;

/* N개의 최소공배수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */

public class MyMain {
    public static void main(String[] args) {
        int[] arr = { 2, 10, 100 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(arr));
    }
}

class Solution {
    ArrayList<Integer> primes = getPrime();

    public int solution(int[] arr) {
        int gongYak = 1;

        for (int pNum : primes) {
            while (isDivided(pNum, arr)) {
                gongYak *= pNum;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % pNum == 0) {
                        arr[i] /= pNum;
                    }
                }
            }
        }
        for (int ar : arr) {
            gongYak *= ar;
        }

        return gongYak;
    }

    private boolean isDivided(int pNum, int[] arr) {
        int deviceCount = 0;
        for (int a : arr) {
            if (a % pNum == 0) {
                deviceCount++;
            }
        }
        return deviceCount >= 2;
    }

    private ArrayList<Integer> getPrime() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}