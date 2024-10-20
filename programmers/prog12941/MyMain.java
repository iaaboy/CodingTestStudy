package prog12941;

import java.util.*;

/* 최솟값 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] sample = {
                { 1, 4, 2 }, { 5, 4, 4 }
        };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(sample[0], sample[1]));
    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }
}