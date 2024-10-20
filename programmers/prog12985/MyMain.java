package prog12985;

/* 예상 대진표
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 4;
        int a = 2;
        int b = 3;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, a, b));
    }
}

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        answer = fight(0, a, b);

        return answer;
    }

    private int fight(int depth, int a, int b) {

        // System.out.println("d: " + depth + " , a:" + a + " , b:" + b);

        if (Math.abs(a - b) <= 1) {
            if (a / 2 != b / 2) {
                return depth + 1;
            }
        }

        return fight(depth + 1, a / 2 + a % 2, b / 2 + b % 2);
    }
}