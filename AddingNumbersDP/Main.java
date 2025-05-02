package AddingNumbersDP;

/*
 * Thanks to GPT
 */

public class Main {
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 합이 0이 되는 방법은 1가지 (아무 것도 안 쓰는 경우)

        int[] nums = {1, 2, 3}; // 사용할 숫자

        for (int num : nums) {
            for (int i = num; i <= n; i++) {
                dp[i] += dp[i - num];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7; // 원하는 숫자
        System.out.println("조합의 수 (순서 무시): " + countWays(n));
    }
}