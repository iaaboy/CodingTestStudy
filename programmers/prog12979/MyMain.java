package prog12979;

/* 기지국 설치
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 15, 16 };
        int[][] stations = { { 2, 5, 12 }, { 9 } };
        int[] w = { 1, 2 };

        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(n[i], stations[i], w[i]));
    }
}

class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int prev = 1;

        for (int st : stations) {
            int start = prev;
            int end = st - w - 1;

            prev = st + w + 1;
            if (st < 0 || end > n || start > end) {
                continue;
            }

            count += calcStation(start, end, w);
        }
        if (prev <= n) {
            count += calcStation(prev, n, w);
        }
        return count;
    }

    private int calcStation(int start, int end, int w) {
        int result = (end - start + 1) / (w * 2 + 1);
        result += (end - start + 1) % (w * 2 + 1) == 0 ? 0 : 1;
        // System.out.println(start + "," + end + "," + result);
        return result;
    }
}