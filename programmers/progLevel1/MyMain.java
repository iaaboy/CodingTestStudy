package progLevel1;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 */

public class MyMain {
    public static void main(String[] args) {
        int a = 1000000; 
        int b = 1000000; 
        int n = 1000000; 
        Solution mSol = new Solution();

        System.out.println(mSol.solution(a, b, n));
    }
}

class Solution {
    public int solution(int a, int b, int n) {
        return calcCoke(a,b, n, 0);
    }

    private int calcCoke(int a, int b, int n, int curBottle) {
        if(n < a) {
            return curBottle;
        }
        return calcCoke(a, b, n / a + n % a, curBottle + (n / a) * b);
    }
}