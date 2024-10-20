package prog118667;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        // int[] queue1 = { 3, 2, 7, 2 }; int[] queue2 = { 4, 6, 5, 1 };
        // int [] queue1 = {1, 2, 1, 2}; int []queue2 = {1, 10, 1, 2};
        int[] queue1 = { 1, 1 };
        int[] queue2 = { 1, 5 };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(queue1, queue2));
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] combinedQ = new int[queue1.length + queue2.length];
        long q1Sum = 0;
        long q2Sum = 0;
        int index = 0;

        for (int q : queue1) {
            combinedQ[index++] = q;
            q1Sum += q;
        }
        for (int q : queue2) {
            combinedQ[index++] = q;
            q2Sum += q;
        }

        System.out.println(Arrays.toString(combinedQ));

        int q1ptr = 0;
        int q2ptr = queue1.length;

        int mvCount = 0; // 현재까지 이동 count
        int curVal = 0; // 업뎃시 사용하는 지금 값.
        int maxMove = 2 * combinedQ.length; // 이동 최대값

        while (q1Sum != q2Sum && mvCount < maxMove) {
            if (q1Sum > q2Sum) {
                curVal = combinedQ[q1ptr];
                q1Sum -= curVal;
                q2Sum += curVal;
                q1ptr++;
                if (q1ptr >= combinedQ.length) {
                    q1ptr = 0;
                }
            } else {
                curVal = combinedQ[q2ptr];
                q1Sum += curVal;
                q2Sum -= curVal;
                q2ptr++;
                if (q2ptr >= combinedQ.length) {
                    q2ptr = 0;
                }
            }
            mvCount++;
            System.out.println("q1: " + q1ptr + ", sum1: " + q1Sum + ", q2: " + q2ptr + ", sum2: " + q2Sum);
        }

        if (mvCount == maxMove) {
            return -1;
        }

        return mvCount;
    }
}

/*
 * 기존
 * 테스트 1 〉 통과 (0.25ms, 72.7MB)
 * 테스트 2 〉 통과 (0.17ms, 86MB)
 * 테스트 3 〉 통과 (0.18ms, 70.6MB)
 * 테스트 4 〉 통과 (0.14ms, 72MB)
 * 테스트 5 〉 통과 (0.30ms, 79.1MB)
 * 테스트 6 〉 통과 (0.27ms, 76.7MB)
 * 테스트 7 〉 통과 (0.56ms, 75MB)
 * 테스트 8 〉 통과 (0.57ms, 70.9MB)
 * 테스트 9 〉 통과 (2.08ms, 73.4MB)
 * 테스트 10 〉 통과 (1.36ms, 85.6MB)
 * 테스트 11 〉 통과 (31.44ms, 107MB)
 * 테스트 12 〉 통과 (17.21ms, 84.6MB)
 * 테스트 13 〉 통과 (15.25ms, 87.1MB)
 * 테스트 14 〉 통과 (14.11ms, 93.6MB)
 * 테스트 15 〉 통과 (12.98ms, 104MB)
 * 테스트 16 〉 통과 (17.77ms, 103MB)
 * 테스트 17 〉 통과 (16.41ms, 109MB)
 * 테스트 18 〉 통과 (76.60ms, 151MB)
 * 테스트 19 〉 통과 (88.62ms, 149MB)
 * 테스트 20 〉 통과 (72.63ms, 146MB)
 * 테스트 21 〉 통과 (93.86ms, 136MB) >>> 테스트 21 〉 통과 (6.76ms, 129MB)
 * 테스트 22 〉 통과 (108.23ms, 147MB) >>> 테스트 22 〉 통과 (16.14ms, 134MB)
 * 테스트 23 〉 통과 (91.32ms, 157MB)
 * 테스트 24 〉 통과 (94.11ms, 140MB)
 * 테스트 25 〉 통과 (0.39ms, 80.9MB)
 * 테스트 26 〉 통과 (0.37ms, 79.2MB)
 * 테스트 27 〉 통과 (0.36ms, 73.2MB)
 * 테스트 28 〉 통과 (58.01ms, 117MB)
 * 테스트 29 〉 통과 (2.94ms, 85MB)
 * 테스트 30 〉 통과 (115.24ms, 121MB) >>> 테스트 30 〉 통과 (3.88ms, 86.6MB)
 * 
 * 이번 풀이
 * 테스트 1 〉 통과 (0.03ms, 75.6MB)
 * 테스트 2 〉 통과 (0.02ms, 76.5MB)
 * 테스트 3 〉 통과 (0.03ms, 76.6MB)
 * 테스트 4 〉 통과 (0.03ms, 77.1MB)
 * 테스트 5 〉 통과 (0.05ms, 85.9MB)
 * 테스트 6 〉 통과 (0.03ms, 75.3MB)
 * 테스트 7 〉 통과 (0.03ms, 72.8MB)
 * 테스트 8 〉 통과 (0.06ms, 75.9MB)
 * 테스트 9 〉 통과 (0.08ms, 77.4MB)
 * 테스트 10 〉 통과 (0.17ms, 84.8MB)
 * 테스트 11 〉 통과 (5.88ms, 93.6MB)
 * 테스트 12 〉 통과 (4.08ms, 72.7MB)
 * 테스트 13 〉 통과 (3.60ms, 80.9MB)
 * 테스트 14 〉 통과 (3.26ms, 88.6MB)
 * 테스트 15 〉 통과 (2.68ms, 93.6MB)
 * 테스트 16 〉 통과 (2.91ms, 94.5MB)
 * 테스트 17 〉 통과 (4.72ms, 94.1MB)
 * 테스트 18 〉 통과 (17.09ms, 137MB)
 * 테스트 19 〉 통과 (15.70ms, 128MB)
 * 테스트 20 〉 통과 (6.28ms, 131MB)
 * 테스트 21 〉 통과 (6.76ms, 129MB)
 * 테스트 22 〉 통과 (16.14ms, 134MB)
 * 테스트 23 〉 통과 (16.47ms, 127MB)
 * 테스트 24 〉 통과 (7.61ms, 127MB)
 * 테스트 25 〉 통과 (0.04ms, 65.4MB)
 * 테스트 26 〉 통과 (0.03ms, 73.2MB)
 * 테스트 27 〉 통과 (0.05ms, 75.5MB)
 * 테스트 28 〉 통과 (4.83ms, 88.9MB)
 * 테스트 29 〉 통과 (0.51ms, 79.1MB)
 * 테스트 30 〉 통과 (3.88ms, 86.6MB)
 */