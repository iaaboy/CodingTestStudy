package prog12971;

import java.util.Arrays;

/* 스티커 모으기(2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] stickers = {
                { 5},
                { 14, 6, 5, 11, 3, 9, 2, 10 },
                 };
        Solution mSol = new Solution();
        for (int[] sticker : stickers)
            System.out.println(mSol.solution(sticker));
    }
}

class Solution {
    public int solution(int[] sticker) {
        int answer = Integer.MIN_VALUE;

        if(sticker.length == 1)
            return sticker[0];

        int len = sticker.length;
        int[] dpFirst = new int[len];
        int[] dpSecond = new int[len];

        dpFirst[0] = sticker[0];
        dpFirst[1] = sticker[0];
        dpSecond[0] = 0;
        dpSecond[1] = sticker[1];

        for (int i = 2; i < len; i++) {
            dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + sticker[i]);
            dpSecond[i] = Math.max(dpSecond[i - 1], dpSecond[i - 2] + sticker[i]);
        }

        answer = Math.max(dpFirst[len - 2], dpSecond[len - 1]);

        return answer;
    }
}