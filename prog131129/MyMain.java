package prog131129;

import java.util.*;

/* 카운트 다운
 * https://school.programmers.co.kr/learn/courses/30/lessons/131129
 */

public class MyMain {
    public static void main(String[] args) {
        int[] targets = { 21, 58 };
        Solution mSol = new Solution();
        for (int t : targets)
            System.out.print(Arrays.toString(mSol.solution(t)));
    }
}

class Solution {
    int[][] dp;
    private static int MAX_DART = 100001;

    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for (int i = 1; i < target + 1; i++)
            dp[i][0] = MAX_DART;

        // 0 : darts , 1: bulls/singles

        return throwDart(target);
    }

    int[] throwDart(int scoreRemained) {
        if (dp[scoreRemained][0] == MAX_DART) {
            if (scoreRemained >= 50) {
                int[] temp = throwDart(scoreRemained - 50);
                if (temp[0] + 1 < dp[scoreRemained][0]
                        || temp[0] + 1 == dp[scoreRemained][0] && temp[1] + 1 > dp[scoreRemained][1]) {
                    dp[scoreRemained][1] = temp[1] + 1;
                    dp[scoreRemained][0] = temp[0] + 1;
                }
            }

            int i = scoreRemained >= 20 ? 20 : scoreRemained;
            for (; i >= 1; i--) {
                for (int j = 1; j <= 3; j++) {
                    if (scoreRemained >= i * j) {
                        int[] temp2 = throwDart(scoreRemained - i * j);
                        int bull = j == 1 ? 1 : 0;
                        if (temp2[0] + 1 < dp[scoreRemained][0]
                                || temp2[0] + 1 == dp[scoreRemained][0] && temp2[1] + bull > dp[scoreRemained][1]) {
                            dp[scoreRemained][0] = temp2[0] + 1;
                            dp[scoreRemained][1] = temp2[1] + bull;
                        }
                    }
                }
            }
        }

        return dp[scoreRemained];
    }
}
