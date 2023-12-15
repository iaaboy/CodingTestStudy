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

    int[] xOffset = {0, 1, -1, 0};
    int[] yOffset = {1, 0, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        // removeArea(int y, int x)

        return answer;
    }
}