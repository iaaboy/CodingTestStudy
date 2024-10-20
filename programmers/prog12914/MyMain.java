package prog12914;

/* 멀리 뛰기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */

public class MyMain {
    public static void main(String[] args) {
        int[] ns = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Solution mSol = new Solution();
        for (int n : ns)
            System.out.println(mSol.solution(n));
    }
}

class Solution {
    public long solution(int n) {
        long[] nums = new long[Math.max(2, n) + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = (nums[i - 2] + nums[i - 1]) % 1234567;
        }
        return nums[n];
    }
}