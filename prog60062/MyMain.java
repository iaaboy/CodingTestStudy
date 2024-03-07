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
        for (int i = 0; i < 1; i++)
            System.out.println(mSol.solution(n[i], weaks[i], dist[i]));
    }
}

class Solution {
    int[] extendedWeak;
    int w;
    int answer;

    public int solution(int n, int[] weak, int[] dist) {
        extendedWeak = new int[weak.length * 2];
        w = weak.length;
        answer = -1;

        // 0. 외곽을 확장
        for (int i = 0; i < extendedWeak.length; i++) {
            if (i < weak.length) {
                extendedWeak[i] = weak[i];
            } else {
                extendedWeak[i] = weak[i - weak.length] + n;
            }
        }

        System.out.println(Arrays.toString(extendedWeak));

        // 1. dist 의 순열을 구한다. (가장 적은수부터 dist 개수까지 개수를 늘려가면서)
        // 2. 각 조합에서 커버 가능한지 확인한다.
        isPass = false;
        for (int i = 1; i <= dist.length; i++) {
            if (permu(dist, 0, i))
                break;
        }

        return answer;
    }

    boolean isPass = false;

    private boolean permu(int[] dist, int count, int targetCnt) { // 순열
        if (isPass) { // pass 이면 바로 빠져나옴.
            return true;
        }
        if (count == targetCnt) {
            if (checkAllStartPoint(dist, count)) {
                isPass = true;
                // System.out.println("passed " + count + ", " + Arrays.toString(dist));
                answer = count;
                return true;
            } else {
                return false;
            }
        }
        for (int i = count; i < dist.length; i++) {
            swap(dist, i, count);
            if (permu(dist, count + 1, targetCnt))
                return true;
            swap(dist, i, count);
        }
        return false;
    }

    private boolean checkAllStartPoint(int[] dist, int count) { // 시작점 변경하면서 모든 시작점 확인
        int n = extendedWeak.length / 2;
        for (int i = 0; i < n; i++) { // 시작점 변경
            if (isPass(i, dist, count)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPass(int st, int[] dist, int count) { // caller가 지정해주는 지점부터 패스 여부 판단
        int curPossible = extendedWeak[st] + dist[0];
        int used = 1;
        for (int i = st + 1; i < st + w; i++) {
            if (extendedWeak[i] > curPossible) {
                if (used >= dist.length) {
                    return false;
                }
                curPossible = extendedWeak[i] + dist[used++];
                if (used > count) {
                    return false;
                }
            }
        }
        return true;
    }

    void swap(int[] dist, int from, int to) {
        int temp = dist[from];
        dist[from] = dist[to];
        dist[to] = temp;
    }
}