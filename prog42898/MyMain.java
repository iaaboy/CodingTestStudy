package prog42898;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        int[][] puddles = { { 2, 2 } };
        System.out.println(mSol.solution(4, 3, puddles));

    }
}

// 1,1부터 시작
// m 오른쪽
// n 아래쪽
class Solution {
    Queue<Point> next = new LinkedList<>();

    public int solution(int m, int n, int[][] puddles) {
        int arrivedCount = 0;
        next.add(new Point(1, 1));

        while (!next.isEmpty()) {
            Point curPoint = next.poll();

            if (checkPd(curPoint, puddles))
                continue;

            if (curPoint.m <= m) {
                next.add(new Point(curPoint.m + 1, curPoint.n));
            }
            if (curPoint.n <= n) {
                next.add(new Point(curPoint.m, curPoint.n + 1));
            }

            if (curPoint.m == m && curPoint.n == n) {
                arrivedCount++;
                // System.out.println("arrived: " + arrivedCount);
            }
        }

        return arrivedCount;
    }

    private boolean checkPd(Point curPoint, int[][] puddles) {

        boolean isPd = false;
        for (int[] pd : puddles) {
            if (pd[0] == curPoint.m && pd[1] == curPoint.n) {
                isPd = true;
                break;
            }
        }
        if (isPd) {
            return true;
        }
        return false;
    }
}

class Point {
    int m;
    int n;
    int count;

    public Point(int m, int n) {
        this.m = m;
        this.n = n;
        this.count = 1;
    }
}