package prog42885;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int[][] peoples = {
                { 47, 50, 50, 50, 50, 52, 60 },
                { 52, 50, 47, 50 },
                { 70, 80, 50 },

        };
        int[] limits = { 100, 100, 100 };

        Solution mSol = new Solution();
        for (int i = 0; i < peoples.length; i++) {
            System.out.println("result: " + mSol.solution(peoples[i], limits[i]));
        }
    }
}
/*
 * //1. 정렬
 * //2. 작은수 부터 검색 시작
 * //3. 다음 검색은 이전 검색한 짝보다 작은수
 * //
 * 
 * [47, 50, 50, 50, 50, 52, 60]
 * i: 0 c:5, mPair: 99
 * i: 1 c:4, mPair: 100
 * i: 2 c:3, mPair: 100
 */

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;

        // 보트에 타서 짝지어짐 flag
        boolean[] paired = new boolean[people.length];

        // 정렬
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        // 가장 작은수부터
        int i = 0;
        int pairIdx = people.length;
        for (; i < people.length; i++) {
            if (paired[i]) {
                continue;
            }
            boolean isExist = false;
            int maxPair = people[i];
            for (int c = pairIdx - 1; c >= i + 1; c--) {
                pairIdx = c; // 초기화
                if (paired[c]) {
                    continue;
                }

                if (people[c] + people[i] <= limit) { // i의 값과 c의 값이 limit을 넘지 않는 가장 큰
                    isExist = true;
                    pairIdx = c;
                    maxPair = people[c] + people[i];
                    break; //합이 최대인 짝을 만나서 break
                }
            }

            if (isExist) {
                System.out.println("i: " + i + " c:" + (pairIdx) + ", mPair: " + maxPair);
                paired[i] = paired[pairIdx] = true; // 다음 검색하지 않기 위한 flagging
                answer--; // 보트에 2명이 탔으니, 전체 보트 카운트에서 -1
            } else {
                // 이후 맞는 짝이 없으므로,
                // 더이상 loop돌 필요 없음.
                break;
            }

        }

        return answer;
    }
}