package prog134239;

import java.util.*;

/*
  우박수열 정적분
  https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */
public class MyMain {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = { { 0, 0 }, { 0, -1 }, { 2, -3 }, { 3, -3 } };

        Solution mSolution = new Solution();
        System.out.println(Arrays.toString(mSolution.solution(k, ranges)));
    }
}

class Solution {
    ArrayList<Integer> mList = new ArrayList<>();

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        getHail(k);

        // System.out.println(mList);

        int index = 0;
        for (int[] r : ranges) {
            double integ;
            r[1] = mList.size() - 1 + r[1];
            if (r[0] < r[1]) {
                integ = calcInteg(r[0], r[1]);
            } else if (r[0] == r[1]) {
                integ = 0;
            } else {
                integ = -1;
            }
            answer[index++] = integ;

            // System.out.println(Arrays.toString(r) + ": " + integ);
        }
        return answer;
    }

    double calcInteg(int a, int b) {
        double result = 0;
        for (int i = Math.min(a, b) + 1; i <= Math.max(a, b); i++) {
            double h1 = Math.max(mList.get(i), mList.get(i - 1));
            double h2 = Math.min(mList.get(i), mList.get(i - 1));

            result += h2;
            result += (h1 - h2) / 2;

            // System.out.println("i: " + i + " .. [" + h1 + "," + h2 + "]" + " r:" +
            // result);
        }
        return result;
    }

    void getHail(int k) {
        mList.add(k);
        if (k == 1) {
            return;
        }

        if (k % 2 == 0) {
            getHail(k / 2);
        } else {
            getHail(k * 3 + 1);
        }
    }
}