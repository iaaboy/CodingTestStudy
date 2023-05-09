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

        pq.add(new Depth(0, y));
        while (pq.size() > 0) {
            Depth curDepth = pq.peek();
            pq.remove();

            System.out.println("check: " + curDepth.count + "," + curDepth.curY + "," + y + "," + n);

            if (curDepth.curY == x)
                return curDepth.count;

            if (curDepth.curY > x) {
                if (curDepth.curY % 3 == 0) {
                    pq.add(new Depth(curDepth.count + 1, curDepth.curY / 3));
                }
                if (curDepth.curY % 2 == 0) {
                    pq.add(new Depth(curDepth.count + 1, curDepth.curY / 2));
                }
                pq.add(new Depth(curDepth.count + 1, curDepth.curY - n));
            }
        }
        return -1;
    }

}

class Depth implements Comparable<Depth> {
    int count;
    int curY;

    public Depth(int count, int curY) {
        this.count = count;
        this.curY = curY;
    }

    @Override
    public int compareTo(Depth o) {
        if (count > o.count) {
            return 1;
        }
        return -1;
    }
}
