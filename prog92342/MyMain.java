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
        int[] mincountforWin = new int[info.length];
        boolean[] vicTable = new boolean[info.length];
        // int[] vicTable2 = new int[info.length]; //win draw lose로 하면 되지 않을까?

        // int idx = 0;
        int trialSum = 0;
        // for(int minCnt: mincountforWin) {
        //     mincountforWin[idx] = info[idx]+1;
        //     trialSum += info[idx++];
        // }

        System.out.println("trialSum: " + trialSum);
        System.out.println("mincountforWin: " + Arrays.toString(mincountforWin));

        for(int a = 0; a < Math.pow(2, info.length) ; a++) {
            int b= a;
            System.out.print(b + ": ");
            for(int i = 0 ; i < info.length; i++ ) {
                //System.out.print(b & 0x1);
                vicTable[i] = (b & 0x1) == 1;
                b = b >> 1;
            }
            checkScore(vicTable);
            System.out.println(Arrays.toString(vicTable));
        }

        // df(vicTable, info.length-1);
                
        return answer;
    }

    void checkScore(boolean[] table) {
        
    }
}