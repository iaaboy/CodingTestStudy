package prog12899;

/* 124나라
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 0; i < 10; i++)
            System.out.println(mSol.solution(i));
    }
}

class Solution {
    StringBuilder answer;

    public String solution(int n) {
        answer = new StringBuilder();
        calculate(n - 1);
        answer.reverse();
        return answer.toString();
    }

    void calculate(int n) {
        int number = n % 3 + 1;
        answer.append(number == 3 ? 4 : number);
        // System.out.print(number);
        if (n > 2)
            calculate(n / 3 - 1);
    }
}