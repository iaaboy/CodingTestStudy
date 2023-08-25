package prog77885;

/* 2개 이하로 다른 비트
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */

public class MyMain {
    public static void main(String[] args) {
        long[] numbers = { 1, 2, 3 };

        Solution mSol = new Solution();
        for (long n : mSol.solution(numbers)) {
            System.out.println(n);
        }

    }
}

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        int index = 0;
        for (long num : numbers) {
            answer[index++] = num + checkNum(num);
        }

        return answer;
    }

    private long checkNum(long num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                break;
            }
            count++;
            num = num >> 1;
        }

        if (count > 0) {
            return (long) Math.pow(2, count) - (long) Math.pow(2, count - 1);
        } else {
            return (long) Math.pow(2, count);
        }
    }
}