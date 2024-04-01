package prog77485;

import java.util.Arrays;

/* 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */

public class MyMain {
    public static void main(String[] args) {
        int rows = 100;
        int columns = 97;
        int[][] queries = { { 1, 1, 100, 97 } };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(rows, columns, queries)));
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] num = new int[rows + 1][columns + 1];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < num[0].length; j++) {
                num[i][j] = count++;
            }
        }
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] qr : queries) {
            answer[index++] = rotate(num, qr[0], qr[1], qr[2], qr[3]);
        }
        return answer;
    }

    private void printAll(int[][] num) {
        // for (int j = 0; j < num.length; j++) {
        // System.out.print("\n" + j + ": ");
        // for (int i = 0; i < num[0].length; i++) {
        // System.out.print(num[j][i] + (num[j][i] > 9 ? " " : " "));
        // }
        // }
    }

    private int rotate(int[][] num, int r1, int c1, int r2, int c2) {
        int temp = num[r1][c1];
        int minNum = temp;
        for (int j = r1 + 1; j <= r2; j++) {
            num[j - 1][c1] = num[j][c1];
            minNum = Math.min(minNum, num[j][c1]);
        }
        printAll(num);
        for (int i = c1 + 1; i <= c2; i++) {
            num[r2][i - 1] = num[r2][i];
            minNum = Math.min(minNum, num[r2][i]);
        }
        printAll(num);
        for (int j = r2; j > r1; j--) {
            num[j][c2] = num[j - 1][c2];
            minNum = Math.min(minNum, num[j - 1][c2]);
        }
        printAll(num);
        for (int i = c2; i > c1; i--) {
            num[r1][i] = num[r1][i - 1];
            minNum = Math.min(minNum, num[r1][i - 1]);
        }
        num[r1][c1 + 1] = temp;
        printAll(num);

        return minNum;
    }
}