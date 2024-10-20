package prog68646;

import java.util.Arrays;

/* 풍선 터트리기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68646
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] as = {
                { 9, -1, -5 }, // 3
                { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 }// 6
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(as[i]));
    }
}

class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        if (a.length <= 2) {
            return a.length;
        }

        leftMin[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i], leftMin[i - 1]);
        }
        rightMin[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i + 1]);
        }

        int answer = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                answer++;
            }
        }
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));
        return answer + 2;
    }
}