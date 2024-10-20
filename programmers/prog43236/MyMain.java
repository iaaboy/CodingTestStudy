package prog43236;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = { 2, 14, 11, 21, 17 };
        int n = 2;

        // int distance = 16;
        // int[] rocks = { 4, 8, 11 };
        // int n = 2;
        Solution mSol = new Solution();
        System.out.println(mSol.solution(distance, rocks, n));
    }
}

class Solution {
    boolean[] visited;
    int[] rocks;
    int[] excludeList;
    int rocksCount = 0;
    int n = 0;
    int[] gap;
    int baseMin = Integer.MAX_VALUE;

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        this.n = n;
        this.rocks = rocks;
        rocksCount = rocks.length;
        excludeList = new int[n];
        gap = new int[rocks.length + 1];

        Arrays.sort(rocks);

        for(int i = 0; i <= rocks.length ; i++){
            if(i == 0) {
                gap[i] = rocks[i];
            } else if(i == rocks.length) {
                gap[i] = distance - rocks[i-1];
            } else {
                gap[i] = rocks[i] - rocks[i-1];
            }
            if(gap[i] < baseMin) {
                baseMin = gap[i];
            }
        }
        System.out.println(Arrays.toString(gap));

        combination(0, 0);
        return answer;
    }

    private void combination(int cnt, int idx) {
        if (cnt == n) {
            checkMin(excludeList);
            return;
        }
        for (int i = idx; i < rocksCount; i++) {
            excludeList[cnt] = i+1;
            combination(cnt + 1, i + 1);
        }
    }

    private int checkMin(int[] excludeList) {
        int minVal = baseMin;
        System.out.println(Arrays.toString(excludeList));

                

        return minVal;
    }
}