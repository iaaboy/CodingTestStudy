package prog12945;

/* 피보나치 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        System.out.println(mSol.solution(6));
    }
}

class Solution {
    public int solution(int n) {
        int n1 = 1; 
        int n2 = 1;
        int n3 = 0;
        
        for (int i = 0; i < n - 2; i++) {
            n3=(n1+n2) % 1234567;
            n1=n2;
            n2=n3;
        }

        return n3;
    }
}