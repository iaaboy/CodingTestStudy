package prog12935;

import java.util.Arrays;

/*
 * 제일 작은 수 제거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12935
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] arrs = {
                { 4, 1, 2, 5 },
                { 1, 2, 3, 4, 54, 7, 87, 8 }
        };

        Solution mSol = new Solution();
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(mSol.solution(arr)));
        }
    }
}

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int minVal = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIdx = i;
            }
        }

        int add1 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == minIdx) {
                add1++;
                answer[i] = arr[i + add1];
                continue;
            } else
                answer[i] = arr[i + add1];
        }

        return answer;
    }
}