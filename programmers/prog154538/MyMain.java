package prog154538;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] numbers = { { 10, 40, 5 } };

        Solution mSol = new Solution();

        for (int[] num : numbers) {
            System.out.println(mSol.solution(num[0], num[1], num[2]));
            System.out.println();
        }
    }
}

class Solution {
    PriorityQueue<Depth> pq = new PriorityQueue<>();
    int newX;

    public int solution(int x, int y, int n) {
        boolean[] isChecked = new boolean[3_000_001];
        pq.add(new Depth(0, x));

        while (pq.size() > 0) {

            System.out.println("pq:" + pq);
            Depth curDepth = pq.poll();

            if (curDepth.curX == y) // x와 y가 같으면 연산 필요 없음.(예외)
                return curDepth.count;

            newX = curDepth.curX + n;
            {
                if (!isChecked[newX] && newX <= y && newX <= 1_000_000) {
                    isChecked[newX] = true;
                    pq.add(new Depth(curDepth.count + 1, newX));
                }
            }

            newX = curDepth.curX * 2;
            {
                if (!isChecked[newX] && newX <= y && newX <= 1_000_000) { // 조건을 걸러낼 수 없다.
                    isChecked[newX] = true;
                    pq.add(new Depth(curDepth.count + 1, newX));
                }
            }

            newX = curDepth.curX * 3;
            {
                if (!isChecked[newX] && newX <= y && newX <= 1_000_000) {
                    isChecked[newX] = true;
                    pq.add(new Depth(curDepth.count + 1, newX));
                }
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
    public String toString() {
        return "count: " + count + " ,curX: " + curX;
    }

    @Override
    public int compareTo(Depth o) {
        if (count > o.count) {
            return 1;
        }
        return -1;
    }
}
