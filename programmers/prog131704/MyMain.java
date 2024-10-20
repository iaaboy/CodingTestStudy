package prog131704;

import java.util.*;

/*
 * 택배상자
https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */

public class MyMain {
    public static void main(String[] args) {
        // int[] order = { 4, 3, 1, 2, 5 };
        int[] order = { 3, 1, 2, 4, 5 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(order));
    }
}

class Solution {
    public int solution(int[] order) {
        Stack<Integer> mStack = new Stack<>();
        int curNumber = 0;
        int n = order.length;
        int[] base = new int[n + 1];

        for (int i = 1; i < n + 1; i++)
            base[i] = i;

        int baseIndex = 1;
        boolean hasItems = true;

        while (hasItems == true && baseIndex <= n + 1) {
            hasItems = false;
            if (baseIndex < n + 1 && order[curNumber] == base[baseIndex]) {
                curNumber++;
                baseIndex++;
                hasItems = true;
            } else if (!mStack.isEmpty() && order[curNumber] == mStack.peek()) {
                mStack.pop();
                curNumber++;
                hasItems = true;
            } else if (baseIndex < n + 1) {
                mStack.add(base[baseIndex]);
                baseIndex++;
                hasItems = true;
            }
        }
        return curNumber;
    }
}