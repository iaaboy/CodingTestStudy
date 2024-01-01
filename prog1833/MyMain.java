package prog1833;

import java.util.Arrays;

/* 캠핑
 * https://school.programmers.co.kr/learn/courses/30/lessons/1833
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 4;
        int[][] data = { { 0, 0 }, { 1, 1 }, { 0, 2 }, { 2, 0 } };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, data));
    }
}

class Solution {
    int[][] data;

    public int solution(int n, int[][] data) {
        int answer = 0;
        this.data = data;

        Arrays.sort(data, (a, b) -> {
            return a[1] - b[1];
        });

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (i == j)
                    continue;
                if (data[i][0] != data[j][0] && data[i][1] != data[j][1]) {
                    if (checkBetween(i, j)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    boolean checkBetween(int from, int to) {
        // System.out.println(from + "," + to + ":" + Arrays.toString(data[from]) + "->"
        // + Arrays.toString(data[to]));
        for (int i = from + 1; i < to; i++) {
            // System.out.println("compare " + i + ":" + Arrays.toString(data[i]));
            if (data[i][1] > data[from][1] && data[i][1] < data[to][1]) {
                if (data[i][0] > Math.min(data[from][0], data[to][0]) &&
                        data[i][0] < Math.max(data[from][0], data[to][0])) {
                    // System.out.println("hit: " + i);
                    return false;
                }
            }
        }

        return true;
    }
}