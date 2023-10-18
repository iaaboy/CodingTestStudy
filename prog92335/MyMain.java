package prog92335;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 110011;
        int k = 10;

        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(n, k));
    }
}

class Solution {
    int pCount = 0;

    public int solution(int n, int k) {
        // int answer = -1;

        long quot = n;
        long remain = 0;
        long number = 0;
        long jarit = 0;

        while (quot != 0) {
            remain = quot % k;
            quot = quot / k;
            if (remain == 0) {
                // System.out.println("number: " + number);
                isPrime(number);
                number = 0;
                jarit = 0;
            } else {
                number += Math.pow(10, jarit) * remain;
                jarit++;
            }
        }
        if (number > 0) {
            isPrime(number);
            // System.out.println("number: " + number);
        }
        return pCount;
    }

    boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            pCount++;
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        pCount++;
        return true;
    }
}