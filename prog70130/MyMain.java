package prog70130;

import java.util.*;

/* 스타 수열
 * https://school.programmers.co.kr/learn/courses/30/lessons/70130
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] as = {
                { 5, 0, 2, 0, 9, 2, 6, 2, 2, 7 },
                { 5, 2, 3, 3, 5, 3 },
                { 0, 3, 3, 0, 7, 2, 0, 2, 2, 0 }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 1; i++) {
            System.out.println(mSol.solution(as[i]));
        }
    }
}

class Solution {
    public int solution(int[] a) {
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            numCount.put(a[i], numCount.containsKey(a[i]) ? (numCount.get(a[i]) + 1) : 1);
        }
        Integer[] nums = new Integer[numCount.keySet().size()];
        Set<Integer> nums2 = numCount.keySet();
        int index = 0;
        for (Integer n : nums2) {
            nums[index++] = n;
        }
        Arrays.sort(nums, (k, l) -> numCount.get(l) - numCount.get(k));

        int answer = -1;
        for (Integer num : nums) {
            if (answer > numCount.get(num)) {
                break;
            }
            int length = getLength(num, a);
            answer = Math.max(answer, length);
        }

        return answer * 2;
    }

    private int getLength(Integer num, int[] a) {
        int lastOccupied = -1;
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) {
                if (i == lastOccupied) {
                    continue;
                }
                if (lastOccupied != i - 1) {
                    if (a[i] == a[i - 1]) {
                        if (i + 1 >= a.length) {
                            continue;
                        }
                        if (a[i] == a[i + 1]) {
                            continue;
                        }
                        lastOccupied = i + 1;
                    } else {
                        lastOccupied = i;
                    }

                } else {
                    if (i + 1 >= a.length) {
                        continue;
                    }
                    if (a[i] == a[i + 1]) {
                        continue;
                    }
                    lastOccupied = i + 1;
                }
                len++;
            }
        }
        return len;
    }
}