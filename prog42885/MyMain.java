package prog42885;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] peoples = { { 52, 50, 47, 50 },
                { 70, 50, 80, 50 },
                { 70, 80, 50 },

        };
        int[] limits = { 100, 100, 100 };

        Solution mSol = new Solution();
        for (int i = 0; i < peoples.length; i++) {
            System.out.println("result: " + mSol.solution(peoples[i], limits[i]));
        }
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;

        boolean[] paired = new boolean[people.length];

        // 정렬
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        // 가장 작은수부터
        int i = 0;
        for (; i < people.length; i++) {
            if (paired[i]) {
                continue;
            }

            boolean isExist = false;
            int c = i + 1;
            int maxPair = people[i];
            int pairIdx = c;
            for (; c < people.length; c++) {
                // i의 값과 c의 값이 limit을 넘지 않는 가장 큰
                if (paired[c]) {
                    continue;
                }

                if (people[c] + people[i] < limit) {
                    isExist = true;
                    pairIdx = c;
                    maxPair = people[c] + people[i];
                } else if (people[c] + people[i] == limit) {
                    isExist = true;
                    pairIdx = c;
                    maxPair = people[c] + people[i];
                    break;
                }
                else {
                    break;
                }
            }

            if (isExist) {
                System.out.println("i: " + i + " c:" + (pairIdx) + ",mPair: " + maxPair);
                paired[i] = paired[pairIdx] = true;
                answer--;
            } else {
                // 더이상 loop돌 필요 없음.
                break;
            }

        }

        return answer;
    }
}