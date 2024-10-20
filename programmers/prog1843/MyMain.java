package prog1843;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] nums = { "5", "-", "3", "+", "1", "+", "2", "-", "4" };
        // String[] nums = { "1", "-", "3", "+", "5", "-", "8" };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(nums));
    }
}

class Solution {
    int operandsCount;
    int[][] max_dp;
    int[][] min_dp;

    public int solution(String arr[]) {
        // 연산자 수
        operandsCount = arr.length / 2 + arr.length % 2;

        // max / min dp 할당
        max_dp = new int[operandsCount][operandsCount];
        min_dp = new int[operandsCount][operandsCount];

        // 최대, 최소값으로 초기화
        for (int i = 0; i < operandsCount; i++) {
            for (int k = 0; k < operandsCount; k++) {
                max_dp[i][k] = Integer.MIN_VALUE;
                min_dp[i][k] = Integer.MAX_VALUE;
            }
        }

        // 초기값을 string에서 parse
        for (int i = 0; i < operandsCount; i++) {
            max_dp[i][i] = Integer.parseInt(arr[i * 2]);
            min_dp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        // printdp();

        // 원소 1번부터 다음 원소 계산
        for (int cnt = 1; cnt < operandsCount; cnt++) {
            printdp();
            for (int i = 0; i < operandsCount - cnt; i++) {
                int j = i + cnt;
                for (int k = i; k < j; k++) {
                    if (arr[k * 2 + 1].charAt(0) == '+') {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] + max_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] + min_dp[k + 1][j]);
                    } else {
                        max_dp[i][j] = Math.max(max_dp[i][j], max_dp[i][k] - min_dp[k + 1][j]);
                        min_dp[i][j] = Math.min(min_dp[i][j], min_dp[i][k] - max_dp[k + 1][j]);
                    }
                }
            }
        }

        return max_dp[0][operandsCount - 1];
    }

    void printdp() {
        for (int[] dpArr : max_dp) {
            System.out.println(Arrays.toString(dpArr));
        }
        for (int[] dpArr : min_dp) {
            System.out.println(Arrays.toString(dpArr));
        }
    }
}