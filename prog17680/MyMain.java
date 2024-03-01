package prog17680;

import java.util.*;

/* [1차] 캐시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */

public class MyMain {
    public static void main(String[] args) {

        int[] caches = { 3, 3, 2, 5, 2, 0 };
        String[][] city = {
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }, // 50
                { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }, // 21
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                        "NewYork", "Rome" }, // 60
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
                        "NewYork", "Rome" }, // 52
                { "Jeju", "Pangyo", "NewYork", "newyork" }, // 16
                { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" },// 25
        };

        Solution mSolution = new Solution();
        for (int i = 0; i < 6; i++) {
            System.out.println("answer: " + mSolution.solution(caches[i], city[i]));
        }

    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        String[] cached = new String[cacheSize];
        int[] history = new int[cacheSize];
        Arrays.fill(cached, "-1");
        Arrays.fill(history, -1);
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            answer += checkCacheVal(cached, history, cities[i], i);
        }
        return answer;
    }

    private int checkCacheVal(String[] cached, int[] history, String city, int index) {
        int oldest = Integer.MAX_VALUE;
        int oldestIdx = 0;
        for (int i = 0; i < cached.length; i++) {
            if (cached[i].equalsIgnoreCase(city)) {
                cached[i] = city;
                history[i] = index;
                return 1;
            }
            if (oldest > history[i]) {
                oldest = history[i];
                oldestIdx = i;
            }
        }
        cached[oldestIdx] = city;
        history[oldestIdx] = index;

        return 5;
    }
}