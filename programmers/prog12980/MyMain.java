package prog12980;

/* 점프와 순간 이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

public class MyMain {
    public static void main(String[] args) {
        int[] N = { 6, 5, 5000 };
        Solution mSol = new Solution();
        for (int n : N) {
            System.out.println(mSol.solution(n));
        }
    }
}

class Solution {
    public int solution(int n) {
        int energy = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                energy++;
            }
        }
        return energy;
    }
}