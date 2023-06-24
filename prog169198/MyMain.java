package prog169198;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[][] balls = { { 5, 8 }, /* {7, 7}, {2, 7}, {7, 3} */ };
        int m = 10; // maxX
        int n = 10; // maxY
        int startX = 5;
        int startY = 9;

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(m, n, startX, startY, balls)));
    }
}

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int index = 0;
        for (int[] ball : balls) {
            answer[index++] = calc(startX, startY, ball[0], ball[1], m, n);
        }
        return answer;
    }

    private int calc(int x, int y, int x2, int y2, int m, int n) {
        // 4방향 계산
        int min = Integer.MAX_VALUE;

        // System.out.println((x2-x != 0 ? x2-x : 1 ));
        // System.out.println((y2-y != 0 ? y2-y: 1));
        // System.out.println((n-y + n-y2));
        // System.out.println((m-x + m-x2));

        int cal;
        if (!(x2 == x && y < y2)) {
            cal = (int) Math.pow(Math.abs(x2 - x != 0 ? x2 - x : 1), 2) + (int) Math.pow((n - y + n - y2), 2);
            if (cal < min) {
                min = cal;
            }
        } else {
            cal = (int) Math.pow((y + y2), 2);
            if (cal < min) {
                min = cal;
            }
        }
        if (!(x2 == x && y > y2)) {
            cal = (int) Math.pow(Math.abs(x2 - x != 0 ? x2 - x : 1), 2) + (int) Math.pow((y + y2), 2);
            if (cal < min) {
                min = cal;
            }
        } else {
            cal = (int) Math.pow((n - y + n - y2), 2);
            if (cal < min) {
                min = cal;
            }
        }

        if (!(y2 == y && x > x2)) {
            cal = (int) Math.pow(Math.abs(y2 - y != 0 ? y2 - y : 1), 2) + (int) Math.pow((x + x2), 2);
            if (cal < min) {
                min = cal;
            }
        } else {
            cal = (int) Math.pow((m - x + m - x2), 2);
            if (cal < min) {
                min = cal;
            }
        }
        if (!(y2 == y && x < x2)) {
            cal = (int) Math.pow(Math.abs(y2 - y != 0 ? y2 - y : 1), 2) + (int) Math.pow((m - x + m - x2), 2);
            if (cal < min) {
                min = cal;
            }
        } else {
            cal = (int) Math.pow((x + x2), 2);
            if (cal < min) {
                min = cal;
            }
        }
        return min;
    }
}