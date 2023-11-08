package prog12936;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 */

public class MyMain {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;

        Solution mSol = new Solution();
        for (int i = 1; i < 7; i++) {
            System.out.println("answer: " + Arrays.toString(mSol.solution(n, i)));
        }
    }
}

class Solution {
    int count;

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        long[] facto = new long[n];
        long fact = 1;
        ArrayList<Integer> numRemained = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fact = facto[i] = (i + 1) * fact;
            numRemained.add(i + 1);
        }

        // System.out.println("n permutation count: " + Arrays.toString(facto));
        // System.out.println("numRemained: " + numRemained);

        int num = 0;
        for (int i = 0; i < n; i++) {
            int index = 0;
            int count = 0;
            if (i != n - 1) {
                index = (int) ((k - 1) / facto[n - i - 2]);
                // System.out.println("k: " + k + " -> " + index);
                if (k % facto[n - i - 2] == 0) {
                    k = facto[n - i - 2];
                } else {
                    k = k % facto[n - i - 2];
                }

            } else {
                index = 0;
            }

            Iterator<Integer> iterator = numRemained.iterator();
            while (iterator.hasNext()) {
                Integer a = iterator.next();
                if (count == index) {
                    num = a;
                    numRemained.remove(a);
                    break;
                }
                count++;
            }

            answer[i] = num;
        }

        return answer;
    }
}