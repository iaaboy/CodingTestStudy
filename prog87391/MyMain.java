package prog87391;

import java.util.Arrays;
import java.util.Random;

/* 공 이동 시뮬레이션
 * https://school.programmers.co.kr/learn/courses/30/lessons/87391
 */

public class MyMain {
    int testN = 5;

    public static void main(String[] args) {
        int n = 10;
        int m = 10;
        int x = 9;
        int y = 0;
        int[][] query = { { 1, 1 }, { 2, 4 }, { 2, 2 }, { 3, 2 }, { 0, 1 },
                { 0, 4 }, { 2, 2 }, { 0, 3 }, { 0, 1 }, { 3, 1 } };

        Solution mSol = new Solution();
        Solution2 mSol2 = new Solution2();

        Random random = new Random();
        x = random.nextInt(10);
        y = random.nextInt(10);
        for (int i = 0; i < query.length; i++) {
            query[i][0] = random.nextInt(4);
            query[i][1] = random.nextInt(5);
        }

        for (int i = 0; i < 1; i++) {
            long answer1 = mSol.solution(n, m, x, y, query);
            long answer2 = mSol2.solution(n, m, x, y, query);
            System.out.println("answer : " + answer1);
            System.out.println("answer2 : " + answer2);
            if (answer1 != answer2) {
                System.out.println("Something wrong ");
                System.out.println(x + "," + y);
                for (int j = 0; j < query.length; j++) {
                    System.out.println(Arrays.toString(query[j]));
                }
            }
        }
    }
}

class Solution {
    public long solution(int n, int m, int y, int x, int[][] queries) {
        int yMin = 0;
        int yMax = n - 1;
        long yMaxCount = 1;
        long yMinCount = 1;

        int xMin = 0;
        int xMax = m - 1;
        long xMaxCount = 1;
        long xMinCount = 1;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) { // 감소
                xMax -= queries[i][1];
                xMin -= queries[i][1];
                if (xMax < 0) {
                    if (xMaxCount < m)
                        xMaxCount += -xMax;
                    xMax = 0;
                }
                if (xMin < 0) {
                    if (xMinCount < m)
                        xMinCount += -xMin;
                    xMin = 0;
                }
            } else if (queries[i][0] == 1) { // 증가
                xMax += queries[i][1];
                xMin += queries[i][1];
                if (xMax > m - 1) {
                    if (xMaxCount < m)
                        xMaxCount += (xMax - (m - 1));
                    xMax = m - 1;
                }
                if (xMin > m - 1) {
                    if (xMinCount < m)
                        xMinCount += (xMin - (m - 1));
                    xMin = m - 1;
                }
            } else if (queries[i][0] == 2) { // 감소
                yMax -= queries[i][1];
                yMin -= queries[i][1];
                if (yMax < 0) {
                    if (yMaxCount < n)
                        yMaxCount += -yMax;
                    yMax = 0;
                }
                if (yMin < 0) {
                    if (yMinCount < n)
                        yMinCount += -yMin;
                    yMin = 0;
                }
            } else if (queries[i][0] == 3) { // 증가
                yMax += queries[i][1];
                yMin += queries[i][1];
                if (yMax > n - 1) {
                    if (yMaxCount < n)
                        yMaxCount += (yMax - (n - 1));
                    yMax = n - 1;
                }
                if (yMin > n - 1) {
                    if (yMinCount < n)
                        yMinCount += (yMin - (n - 1));
                    yMin = n - 1;
                }
            }
        }

        if (yMax == yMin) {
            yMaxCount = yMinCount = n;
        }
        if (xMax == xMin) {
            xMaxCount = xMinCount = m;
        }

        long xResult = 0;
        long yResult = 0;
        if (x == xMax) {
            xResult = xMaxCount;
        } else if (x == xMin) {
            xResult = xMinCount;
        } else if (x > xMax || x < xMin) {
            xResult = 0;
        } else {
            xResult = 1;
        }
        if (y == yMax) {
            yResult = yMaxCount;
        } else if (y == yMin) {
            yResult = yMinCount;
        } else if (y > yMax && y < yMin) {
            yResult = 1;
        } else {
            yResult = 0;
        }

        System.out.println(xMin + "," + xMax + "::" + xMinCount + "," + xMaxCount + ".. " + xResult);
        System.out.println(yMin + "," + yMax + "::" + yMinCount + "," + yMaxCount + ".. " + yResult);

        return xResult * yResult;
    }
}

