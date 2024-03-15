package prog12942;

import java.util.*;

/* 최적의 행렬 곱셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12942
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] matrix_sizes = {
                {5,3}, {3,10}, {10,6}
        };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(matrix_sizes));
    }
}

class Solution {
    public int solution(int[][] matrix_sizes) {
        List<Pair> matPairs = new LinkedList<>();
        for (int i = 0; i < matrix_sizes.length; i++) {
            matPairs.add(new Pair(matrix_sizes[i][0], matrix_sizes[i][1]));
        }
        minCalc = Integer.MAX_VALUE;
        int caclSum = dfs(matPairs, 0);

        return caclSum;
    }

    int minCalc = Integer.MAX_VALUE;

    private int dfs(List<Pair> matPairs, int calcSum) {
        // System.out.println(matPairs);
        if (calcSum > minCalc)
            return calcSum;
        if (matPairs.size() == 1) {
            minCalc = Math.min(calcSum, minCalc);
            return calcSum;
        }
        int calcMin = Integer.MAX_VALUE;
        for (int i = 0; i < matPairs.size(); i++) {
            Pair me = matPairs.get(i);
            for (int j = i + 1; j < matPairs.size(); j++) {
                Pair you = matPairs.get(j);
                if (me.second == you.first) {
                    Pair savedMe = me;
                    Pair savedYou = you;
                    if (calcSum + me.first * me.second * you.second < calcMin) {
                        matPairs.remove(j);
                        matPairs.set(i, new Pair(me.first, you.second));
                        calcMin = Math.min(calcMin, dfs(matPairs, calcSum + me.first * me.second * you.second));
                        // matPairs.remove(i);
                        matPairs.set(i, savedYou);
                        matPairs.add(i, savedMe);
                    }
                }
            }
        }
        return calcMin;
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + "," + second;
        }
    }
}