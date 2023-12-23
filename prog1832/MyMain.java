package prog1832;

/* 보행자 천국
 * https://school.programmers.co.kr/learn/courses/30/lessons/1832
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3 };
        int[] n = { 3, 6 };
        int[][][] cityMap = {
                { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
                { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } } };

        Solution mSol = new Solution();

        for (int i = 0; i < 1; i++)
            System.out.println(mSol.solution(m[i], n[i], cityMap[i]));
    }
}

class Solution {
    int MOD = 20170805;
    int count;
    int[][] cityMap;
    int yEnd, xEnd;
    boolean[][] isVisited;

    public int solution(int m, int n, int[][] cityMap) {
        count = 0;
        this.cityMap = cityMap;
        this.yEnd = m - 1;
        this.xEnd = n - 1;
        isVisited = new boolean[m][n];

        visitNext(0, 0, false);
        isVisited[0][0] = true;

        return count;
    }

    private void visitNext(int y, int x, boolean fromLeft) {

        System.out.println("<" + y + "," + x + ">");

        if (x == xEnd && y == yEnd) {
            count++;
            if (count == MOD)
                count = 0;
            return;
        }

        if (cityMap[y][x] == 0) {
            if (x < xEnd && !isVisited[y][x + 1]) {
                isVisited[y][x + 1] = true;
                visitNext(y, x + 1, true);
                isVisited[y][x + 1] = false;
            }
            if (y < yEnd && !isVisited[y + 1][x]) {
                isVisited[y + 1][x] = true;
                visitNext(y + 1, x, false);
                isVisited[y + 1][x] = false;
            }
        } else if (cityMap[y][x] == 2) {
            if (fromLeft) {
                if (x < xEnd && !isVisited[y][x + 1]) {
                    isVisited[y][x + 1] = true;
                    visitNext(y, x + 1, true);
                    isVisited[y][x + 1] = false;
                }
            } else {
                if (y < yEnd && !isVisited[y + 1][x]) {
                    isVisited[y + 1][x] = true;
                    visitNext(y + 1, x, false);
                    isVisited[y + 1][x] = false;
                }
            }
        }
    }
}