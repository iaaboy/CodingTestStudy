package prog12924;

/* 숫자의 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        System.out.println(mSol.solution(1));
    }
}

class Solution {
    public int solution(int n) {
        int sum = 0;
        int count = 0;
        if(n == 1)
            return 1;
        for (int i = 1; i < n; i++) {
            sum += i;
            if (sum > n) {
                break;
            }
            if ((n - sum) % i == 0) {
                count++;
            }
        }
        return count;
    }
}