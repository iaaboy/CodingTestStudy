package prog60062;

import java.util.*;

/* 외벽 점검
 * https://school.programmers.co.kr/learn/courses/30/lessons/60062
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 12, 12 };
        int[][] weaks = {
                { 1, 5, 6, 10 },
                { 1, 3, 4, 9, 10 }
        };
        int[][] dist = {
                { 1, 2, 3, 4 }, // 2
                { 3, 5, 7 } // 1
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(n[i], weaks[i], dist[i]));
    }
}

class Solution {
    int[] extendedWeak;
    public int solution(int n, int[] weak, int[] dist) {
        extendedWeak = new int[weak.length * 2];

        // 0. 외곽을 확장
        for(int i = 0 ; i < extendedWeak.length ; i++) {
            if(i < weak.length) {
                extendedWeak[i] = weak[i];
            } else {
                extendedWeak[i] = weak[i - weak.length] + n;
            }
        }

        System.out.println(Arrays.toString(extendedWeak));

        // 1. dist 의 순열을 구한다.
        // 2. 각 조합에서 커버 가능한지 확인한다.
        for(int i = 1; i <= dist.length ; i++) {
            permu(dist, 0, 2);
        }

        int answer = 0;
        return answer;
    }

    private void permu(int[] dist, int count, int targetCnt) {
        if (count == targetCnt) {
            if(checkAllStartPoint(dist, count)) {
                System.out.println("passed");
            }
            return;
        }
        for (int i = count; i < dist.length; i++) {
            swap(dist, i, count);
            permu(dist, count + 1, targetCnt);
            swap(dist, i, count);
        }
    }

    private boolean checkAllStartPoint(int[] dist, int count) {
        int n = extendedWeak.length / 2 ;
        for(int i = 0 ; i < n; i++) { // 시작점 변경
            if(isPass(i, dist, count)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPass(int i, int[] dist, int count) {

        return false;
    }

    void swap(int[] dist, int from, int to) {
        int temp = dist[from];
        dist[from] = dist[to];
        dist[to] = temp;
    }
}