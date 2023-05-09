package prog154538;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] numbers = { { 10, 40, 30 } };

        Solution mSol = new Solution();

        for (int[] num : numbers) {
            System.out.println(mSol.solution(num[0], num[1], num[2]));
            System.out.println();
        }
    }
}

class Solution {
    int curNum;

    PriorityQueue<Depth> pq = new PriorityQueue<>();

    public int solution(int x, int y, int n) {
        curNum = x;
        if (x == y)
            return 0;
        return checkNext(1, x, y, n);
    }

    private int checkNext(int count, int curX, int y, int n) {

        int nextX;

        System.out.println("check: " + count + "," + curX + "," + y + "," + n);

        nextX = curX + n;
        if (nextX == y) {
            return count;
        } else {
            if (nextX < y) {
                pq.add(new Depth(count + 1, nextX));
            }
        }

        nextX = curX * 2;
        if (nextX == y) {
            return count;
        } else {
            if (nextX < y) {
                pq.add(new Depth(count + 1, nextX));
            }
        }

        nextX = curX * 3;
        if (nextX == y) {
            return count;
        } else {
            if (nextX < y) {
                pq.add(new Depth(count + 1, nextX));
            }
        }

        int res;
        while (pq.size() > 0) {
            Depth data = pq.peek();
            pq.remove();
            res = checkNext(data.count, data.curX, y, n);
            if (res > 0) {
                return res;
            }
        }

        return -1;
    }
}

class Depth implements Comparable<Depth> {
    int count;
    int curX;

    public Depth(int count, int curX) {
        this.count = count;
        this.curX = curX;
    }

    @Override
    public int compareTo(Depth o) {
        if (count > o.count) {
            return 1;
        }
        return -1;
    }
}
