package prog43238;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[] times = { 7, 10 };
        int n = 6;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(n, times));
    }
}

class Solution {
    long Min = 0 - 1;
    long Max;
    int[] times;
    int n;
    long answer = 0;

    public long solution(int n, int[] times) {
        this.times = times;
        this.n = n;

        Max = times[times.length - 1] * (long) n;

        Arrays.sort(this.times);

        calcNumber(Max / 2);

        return answer;
    }

    private void calcNumber(long curNum) {

        boolean result = false;

        long calcNow = 0L;
        for (int i = 0; i < times.length; i++) {
            calcNow += ((long) curNum / (long) times[i]);
        }

        long calcPre = 0L;
        for (int i = 0; i < times.length; i++) {
            calcPre += (long) ((long) (curNum - 1) / (long) times[i]);
        }

        // System.out.println(curNum + ": " + calcNow + "/" + calcPre+ ", min,max: " +
        // Min + ", " + Max);
        // System.out.println("curNum: " + curNum);

        if (calcNow >= n && calcPre < n) {
            // System.out.println("came to result: " + curNum);
            answer = curNum;
            result = true;
        }

        if (result) {
            return;
        } else {

            long next = 0;
            if (calcNow >= n) {
                Max = curNum;
                next = (Min + curNum) / 2;
            } else {
                Min = curNum;
                next = (Max + curNum) / 2;
            }

            if (next == Max) {
                next--;
            } else if (next == Min) {
                next++;
            }

            calcNumber(next);
        }

        return;
    }
}