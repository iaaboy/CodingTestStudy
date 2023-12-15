package prog1829;

import java.util.Arrays;

/* 카카오프렌즈 컬러링북
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] picture = {
                { 1, 1, 1, 0 },
                { 1, 2, 2, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 0, 1 },
                { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(6, 4, picture)));
    }
}

class Solution {
    int[] xOffset = { 0, 1, -1, 0 };
    int[] yOffset = { 1, 0, 0, -1 };
    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        this.picture = picture;
        int[] answer = new int[2];

        for (int y = 0; y < picture.length; y++) {
            for (int x = 0; x < picture[0].length; x++) {
                if (picture[y][x] != 0) {
                    int size = checkNear(y, x, picture[y][x]);
                    answer[1] = size > answer[1] ? size : answer[1];
                    answer[0]++;
                }
            }
        }
        return answer;
    }

    private int checkNear(int y, int x, int id) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int newY = y + yOffset[i];
            int newX = x + xOffset[i];
            if (isIntheArea(newY, newX) && id == picture[newY][newX]) {
                picture[newY][newX] = 0;
                count++;
                count += checkNear(newY, newX, id);
            }
        }
        return count;
    }

    private boolean isIntheArea(int y, int x) {
        return y >= 0 && x >= 0 && y < picture.length && x < picture[0].length;
    }
}