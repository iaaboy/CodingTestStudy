package progLevel1;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 46, 33, 33, 22, 31, 50 };
        int[] arr2 = { 27, 56, 19, 14, 14, 10 };
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(n, arr, arr2)));
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] var = new String[n];
        String[] answer = new String[n];

        for (int i = 0; i < var.length; i++)
            var[i] = "";

        for (int i = 0; i < arr1.length; i++) {
            int c = arr1[i] | arr2[i];
            String cs = Integer.toBinaryString(c);
            StringBuffer sb = new StringBuffer();
            if (cs.length() < n) {
                for (int j = 0; j < n - cs.length(); j++) {
                    sb.append(" ");
                }
            }
            for (int j = 0; j < cs.length(); j++) {
                if (cs.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}