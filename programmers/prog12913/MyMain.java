package prog12913;

/* 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(land));
    }
}

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] memoSum = new int[land.length][land[0].length];

        memoSum[0] = land[0];
        for (int j = 1; j < land.length; j++) {
            for (int i = 0; i < land[0].length; i++) {
                for (int k = 0; k < land[0].length; k++) {
                    if (i == k)
                        continue;
                    memoSum[j][i] = Math.max(memoSum[j][i], land[j][i] + memoSum[j - 1][k]);
                }
            }
        }

        for (int i = 0; i < memoSum[0].length; i++) {
            answer = Math.max(answer, memoSum[land.length - 1][i]);
        }

        return answer;
    }
}