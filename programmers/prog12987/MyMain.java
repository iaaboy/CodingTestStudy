package prog12987;

import java.util.Arrays;

/* 숫자 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] as = { { 5, 1, 3, 7 }, { 2, 2, 2, 2 }, { 1, 2, 3 } };
        int[][] bs = { { 2, 2, 6, 8 }, { 1, 1, 1, 1 }, { 0, 5, 4 } };

        Solution mSol = new Solution();
        for (int i = 0; i < as.length; i++)
            System.out.println(mSol.solution(as[i], bs[i]));
    }
}

class Solution {
    public int solution(int[] A, int[] B) {

        int indexB = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int countWin = 0;

        for (int a = 0; a < A.length; a++) {
            for (int b = indexB; b < B.length; b++) {
                if (A[a] < B[b]) {
                    // System.out.println(A[a] + " win " + B[b]);
                    indexB = b + 1;
                    countWin++;
                    break;
                }
            }
        }

        return countWin;
    }
}