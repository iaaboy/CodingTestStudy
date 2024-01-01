package prog92342;

import java.util.*;

/* 양궁대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */


public class MyMain {
    public static void main(String[] args) {
        int n = 5;
        int [] info ={2,1,1,1,0,0,0,0,0,0,0};

        // 5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
        // 1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
        // 9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
        // 10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(n, info)));
    }
}

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
                
        return answer;
    }
}