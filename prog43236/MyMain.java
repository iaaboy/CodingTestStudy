package prog43236;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // int distance = 25;
        // int [] rocks = {2, 14, 11, 21, 17};
        // int n =2;

        int distance = 16;
        int[] rocks = { 4, 8, 11 };
        int n = 2;
        Solution mSol = new Solution();
        System.out.println(mSol.solution(distance, rocks, n));
    }
}

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int[] gap = new int[rocks.length + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.gap - b.gap;
        });

        Arrays.sort(rocks);
        // System.out.println(" " +Arrays.toString(rocks));

        gap[0] = rocks[0];
        for (int i = 1; i < rocks.length; i++)
            gap[i] = rocks[i] - rocks[i - 1];
        gap[rocks.length] = distance - rocks[rocks.length - 1];

        for (int i = 0; i < gap.length; i++)
            pq.add((new Node(gap[i], i)));

        System.out.println(Arrays.toString(gap));
        System.out.println(pq);

        int handled = 0;
        ArrayList<Integer> minList = new ArrayList<>();
        while (handled < n) {
            // 최소값과 같은 크기 데이터 뽑는다.
            if (minList.isEmpty()) {
                int curMin = pq.peek().gap;

                while (!pq.isEmpty() && curMin == pq.peek().gap) {
                    minList.add(pq.poll().index);
                }
            }

            // 그중 합칠 것을 뽑는다
            int minVal = Integer.MAX_VALUE;
            int curIndex = 0;
            for (int i = 0; i < minList.size(); i++) {
                int minIdx = minList.get(i);
                if (minIdx != gap.length - 1 && minVal > gap[minIdx] + gap[minIdx + 1]) {
                    minVal = gap[minIdx] + gap[minIdx + 1];
                    curIndex = minIdx;
                }
                if (minIdx != 0 && minVal > gap[minIdx] + gap[minIdx - 1]) {
                    minVal = gap[minIdx] + gap[minIdx - 1];
                    curIndex = minIdx - 1;
                }
            }

            // 합치는 데이터 업데이트

            // System.out.print(curIndex);
            minList.remove(Integer.valueOf(curIndex));
            gap[curIndex] = minVal;
            rocks[curIndex] = -1;
            gap[curIndex + 1] = minVal;

            handled++;
        }

        int[] refinedLock = new int[rocks.length];

        int rIdx = 0;
        for (int r : rocks) {
            if (r != -1) {
                refinedLock[rIdx++] = r;
            }
        }
        refinedLock[rIdx] = distance;

        System.out.println(Arrays.toString(rocks));
        System.out.println(Arrays.toString(refinedLock));

        answer = refinedLock[0];
        for (int i = 1; i <= rIdx; i++) {
            if (answer > refinedLock[i] - refinedLock[i - 1]) {
                answer = refinedLock[i] - refinedLock[i - 1];
            }
            ;
        }

        return answer;
    }
}

class Node {
    int gap;
    int index;

    public Node(int gap, int index) {
        this.gap = gap;
        this.index = index;
    }

    @Override
    public String toString() {
        return "g: " + gap + ", i: " + index;
    }
}