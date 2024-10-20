package prog132265;

import java.util.*;

/*
롤케이크 자르기
https://school.programmers.co.kr/learn/courses/30/lessons/132265
*/
public class MyMain {
    public static void main(String[] args) {
        // int [] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping = { 1, 2, 3, 1, 4 };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(topping));
    }
}

class Solution {
    public int solution(int[] topping) {
        int[] toppingLog = new int[topping.length];
        int[] toppingLog2 = new int[topping.length];
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            numSet.add(topping[i]);
            toppingLog[i] = numSet.size();
        }
        for (int i = topping.length - 1; i >= 0; i--) {
            numSet2.add(topping[i]);
            toppingLog2[i] = numSet2.size();
        }

        // System.out.println(Arrays.toString(topping));
        // System.out.println(Arrays.toString(toppingLog));
        // System.out.println(Arrays.toString(toppingLog2));

        int toppingCount = 0;
        for (int i = 0; i < toppingLog.length - 1; i++) {
            if (toppingLog[i] == toppingLog2[i + 1]) {
                toppingCount++;
            }
        }

        return toppingCount;
    }
}