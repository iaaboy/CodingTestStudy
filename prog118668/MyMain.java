package prog118668;

import java.util.*;
/* 코딩 테스트 공부
 * https://school.programmers.co.kr/learn/courses/30/lessons/118668
 */

public class MyMain {
    public static void main(String[] args) {
        int[] alp = { 10, 0 };
        int[] cop = { 10, 0 };
        int[][][] problems = {
                { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } },
                { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } }
        };

        Solution mSol = new Solution();

        for (int i = 0; i < 2; i++) {
            System.out.println(mSol.solution(alp[i], cop[i], problems[i]));
        }
    }
}

class Solution {
    int answer;
    int n;
    static int AlpReq = 0;
    static int CopReq = 1;
    static int AlpSolvedBonus = 2;
    static int CopSolvedBonus = 3;
    static int Cost = 4;
    static int POINT_COUNT = 500;
    int[][] problems;
    int[][] memo;

    public int solution(int alp, int cop, int[][] problems) {
        n = problems.length;
        this.problems = problems;
        answer = -1;
        memo = new int[POINT_COUNT][POINT_COUNT];
        for (int i = 0; i < POINT_COUNT; i++) {
            for (int j = 0; j < POINT_COUNT; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<CodingStatus> pQ = new PriorityQueue<>((a, b) -> a.time - b.time);
        pQ.add(new CodingStatus(alp, cop, 0));
        int maxA = -1;
        int maxC = -1;
        for (int[] p : problems) {
            maxA = Math.max(maxA, p[0]);
            maxC = Math.max(maxC, p[1]);
        }

        while (!pQ.isEmpty()) {
            CodingStatus cur = pQ.poll();
            if (cur.alp >= maxA && cur.cop >= maxC) {
                answer = cur.time;
                break;
            }
            if (memo[cur.alp][cur.cop] > cur.time) {
                memo[cur.alp][cur.cop] = cur.time;
            }

            for (int i = 0; i < n; i++) {
                int nextAlp = cur.alp;
                int nextCop = cur.cop;
                int nextStudyTime = cur.time;
                boolean isDiff = false;

                if (problems[i][AlpReq] > cur.alp) {
                    nextAlp = problems[i][AlpReq];
                    nextStudyTime += (problems[i][AlpReq] - cur.alp);
                    isDiff = true;
                }
                if (problems[i][CopReq] > cur.cop) {
                    nextCop = problems[i][CopReq];
                    nextStudyTime += (problems[i][CopReq] - cur.cop);
                    isDiff = true;
                }
                if (isDiff && (memo[nextAlp][nextCop] > nextStudyTime)) {
                    memo[nextAlp][nextCop] = nextStudyTime;
                    pQ.add(new CodingStatus(nextAlp, nextCop, nextStudyTime));
                }
                // next가 조건 만족시 리턴
                nextAlp += problems[i][AlpSolvedBonus];
                nextCop += problems[i][CopSolvedBonus];
                nextStudyTime += problems[i][Cost];
                if (memo[nextAlp][nextCop] > nextStudyTime) {
                    memo[nextAlp][nextCop] = nextStudyTime;
                    pQ.add(new CodingStatus(nextAlp, nextCop, nextStudyTime));
                }
            }
        }
        return answer;
    }

    class CodingStatus {
        int alp;
        int cop;
        int time;

        public CodingStatus(int alp, int cop, int time) {
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }

        @Override
        public String toString() {
            return alp + "," + cop + "," + time;
        }
    }
}