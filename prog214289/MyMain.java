package prog214289;

import java.util.Arrays;

/* 에어컨
 * https://school.programmers.co.kr/learn/courses/30/lessons/214289
 */

public class MyMain {
    public static void main(String[] args) {
        // temperature: 외부온도, 실내 온도 범위 t1 ~ t2
        // 온도가 다를때 1분당 전력 : a
        // 온도가 같을때 1분당 전력 : b
        int temperature = 28;
        int t1 = 18;
        int t2 = 26;
        int a = 10;
        int b = 8;
        int[] onboard = { 0, 0, 1, 1, 1, 1, 1 };// 40
        // int temperature = -10; int t1 = -5; int t2 = 5; int a= 5; int b=1; int[]
        // onboard = {0, 0, 0, 0, 0, 1, 0};// 25
        // int temperature = 11; int t1 = 8; int t2 = 10; int a= 10; int b=1; int[]
        // onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]};// 20
        // int temperature = 11; int t1 = 8; int t2 = 10; int a= 10; int b=100; int[]
        // onboard = {0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1];// 60

        Solution mSol = new Solution();
        System.out.println(mSol.solution(temperature, t1, t2, a, b, onboard));
    }
}

class Solution {
    int MAX_CURR = 2000000000;

    public int solution(int temperature, int t1, int t2, int move, int keep, int[] onboard) {
        int answer = 0;

        // 징검다리식 풀이
        int[] currency = new int[51];
        int[] currencyNext = new int[51];;
        Arrays.fill(currency, MAX_CURR);
        Arrays.fill(currencyNext, MAX_CURR);

        int outTempIndex = getCorrected(temperature);
        int left = outTempIndex;
        int right = outTempIndex;
        currency[outTempIndex] = 0;
        for (int i = 0; i < currency.length; i++) {
            // System.out.println("Before: " + left + "-" + right + ": " + Arrays.toString(currency));
            // 다음. index범위 설정
            if (onboard[i] == 0) {
                left = Math.max(left - 1, 0);
                right = Math.min(right + 1, currency.length - 1);
            } else {
                left = Math.max(left - 1, getCorrected(t1));
                right = Math.max(right + 1, getCorrected(t2));
            }
            for (int j = left; j <= right; j++) {
                int current = Integer.MAX_VALUE;
                // 좌상
                if (j == outTempIndex) {
                    current = Math.min(current, currency[j - 1]); // off
                } else if (j > outTempIndex) {
                    current = Math.min(current, currency[j - 1]);
                } else {
                    current = Math.min(current, currency[j - 1] + move);
                }
                // 상
                if (j == outTempIndex) {
                    current = Math.min(current, currency[j]);
                } else if (j > outTempIndex) {
                    current = Math.min(current, currency[j] + keep);
                } else {
                    current = Math.min(current, currency[j] + keep);
                }
                // 우상
                if (j == outTempIndex) {
                    current = Math.min(current, currency[j + 1]);
                } else if (j > outTempIndex) {
                    current = Math.min(current, currency[j + 1] + move);
                } else {
                    current = Math.min(current, currency[j + 1]);
                }
                currencyNext[j] = current;
            }
            currency = currencyNext;
            System.out.println("After: " + left + "-" + right + ": ");
            printArr(left, right, currencyNext);
        }

        return answer;
    }
    void printArr(int left, int right, int [] arr) {
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    int getCorrected(int temp) {
        return temp + 10; // -10 ~ 40 index 보정
    }
}