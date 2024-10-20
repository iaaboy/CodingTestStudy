package prog62048;

/* 멀쩡한 사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 */

public class MyMain {
    public static void main(String[] args) {

        Solution mSol = new Solution();
        System.out.println("answer: " + mSol.solution(3, 7));
    }
}

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        // double slope = (double) h / (double) w;

        double start = 0;
        double end = 0;

        for (int i = 1; i <= w; i++) {
            // end = (double)i * slope; // 소스점이 정확하지 않아 나누기가 제대로 되지 않음.
            end = (double) i * (double) h / (double) w;
            long diff = (long) Math.ceil(end) - (long) Math.floor(start);
            answer += diff;
            System.out.println("s: " + start + " , e: " + end + " , diff: " + diff);
            start = end;
        }

        return (long) w * (long) h - (long) answer; // 리턴시 integer를 그대로 사용할 경우 overflow.
    }
}