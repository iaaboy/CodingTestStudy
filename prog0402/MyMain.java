package prog0402;

import java.util.*;

class MyMain {
    public static void main(String[] args) {
        int [] inputArr = {5,-5,4,7,-9,2,4};

        Solution sol = new Solution();
        long result = sol.solution(inputArr);
        System.out.println(result);
    }
}

/*
sequence :        [5, -5,    4,  7,  -9, 2, 4]
pulsed sequence : [-5, -5,  -4,  7,  9,  2, -4]
prefix :       [0, -5, -10, -14, -7, 2,  4, 0]
중간합이 낮은 -14(3번째)  -> {-5, -5,  -4} 합
중간합이 가장 높은 4(6번째) -> {-5, -5,  -4,  7,  9,  2} 합
결과 구간                -> {7 ,9 ,2}
답 : 19
 */

class Solution {
    public long solution(int[] sequence) {
        long[] prefix = new long[sequence.length + 1];// sequence의 합을 나타낸 배열

        System.out.println(Arrays.toString(sequence));

        int pulse = -1;
        for(int i = 0; i < sequence.length; i++) {
            sequence[i] = sequence[i]*pulse;
            pulse = pulse*-1;
        }

        for (int i = 1; i <= sequence.length; i++) {
            prefix[i] = prefix[i - 1] + sequence[i - 1];
        }

        System.out.println(Arrays.toString(sequence));
        System.out.println(Arrays.toString(prefix));
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i = 0; i< prefix.length ; i++) {
            if(prefix[i] <  min) {
                min = prefix[i];
            }
            if(prefix[i] >  max) {
                max = prefix[i];
            }
        }

        System.out.println(Math.abs(max-min));
        return Math.abs(max-min);
    }
}

