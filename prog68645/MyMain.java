package prog68645;

import java.util.Arrays;

/* 삼각 달팽이
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */

public class MyMain {
    public static void main(String[] args) {
        int[] ns = { 4, 5, 6 };
        Solution mSol = new Solution();
        for (int n : ns)
            System.out.println(Arrays.toString(mSol.solution(n)));
    }
}

class Solution {
    int facto;
    int n;

    public int[] solution(int n) {
        facto = factorial(n);
        int[] answer = new int[facto];
        this.n = n;

        System.out.println(facto);

        fillAnswer(answer, 0, 0, 0, 1);

        return answer;
    }

    private void fillAnswer(int[] answer, int cur, int x, int y, int number) {
        if (cur == n)
            return;

        int way = cur % 3;
        if (way == 0) {
            for (int i = 0; i < n - cur; i++) {
                answer[factorial(y) + x] = number;
                y++;
                number++;
            }
            y--;
            x++;
        } else if (way == 1) {
            for (int i = 0; i < n - cur; i++) {
                answer[factorial(y) + x] = number;
                x++;
                number++;
            }
            y--;
            x -= 2;
        } else {
            for (int i = 0; i < n - cur; i++) {
                answer[factorial(y) + x] = number;
                x--;
                y--;
                number++;
            }
            y += 2;
            x++;
        }
        fillAnswer(answer, cur + 1, x, y, number);
    }

    int factorial(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return factorial(n - 1) + n;
    }
}