package prog12971;

import java.util.Arrays;

/* 스티커 모으기(2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] stickers = {
                { 1, 3, 2, 5, 4 },
                { 14, 6, 5, 11, 3, 9, 2, 10 },
                 };
        Solution mSol = new Solution();
        for (int[] sticker : stickers)
            System.out.println(mSol.solution(sticker));
    }
}

class Solution {
    public int solution(int sticker[]) {
        boolean [] visited = new boolean[sticker.length];
        return dfs(visited, sticker, 0, 0);
    }

    private int dfs(boolean [] visited, int[] sticker, int curPosition, int curSum) {
        if(curPosition >= sticker.length) {
            System.out.println(curSum + ": " + Arrays.toString(visited) );
            return curSum;
        }

        //이번에 선택한 경우
        visited[curPosition] = true;
        int sum = dfs(visited, sticker, curPosition + 2, curSum + sticker[curPosition]);
        //이번에 선택 안한 경우
        visited[curPosition] = false;
        int sum2 = dfs(visited, sticker, curPosition + 1, curSum);
        return Math.max(sum, sum2);
    }
}