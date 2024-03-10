package prog1838;

import java.util.*;

/* 몸짱 트레이너 라이언의 고민
 * https://school.programmers.co.kr/learn/courses/30/lessons/1838
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 3, 2, 2, 4 };
        int[] m = { 2, 1, 2, 5 };
        int[][][] timetable = {
                { { 1170, 1210 }, { 1200, 1260 } }, // 4
                { { 840, 900 } }, // 0
                { { 600, 630 }, { 630, 700 } }, // 2
                { { 1140, 1200 }, { 1150, 1200 }, { 1100, 1200 }, { 1210, 1300 }, { 1220, 1280 } }// 4
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 4; i++) {
            System.out.println(mSol.solution(n[i], m[i], timetable[i]));
        }
    }
}

class Solution {
    int n;

    public int solution(int n, int m, int[][] timetable) {
        Log[] log = new Log[m * 2];
        this.n = n;
        for (int i = 0; i < m; i++) {
            log[i * 2] = new Log(timetable[i][0], false);
            log[i * 2 + 1] = new Log(timetable[i][1], true);
        }
        Arrays.sort(log, (a, b) -> {
            if (a.time == b.time) {
                if (!a.isOut) {
                    return -1;
                } else {
                    return +1;
                }
            }
            return a.time - b.time;
        });
        int maxCroud = 0;
        int croud = 0;
        for (int i = 0; i < log.length; i++) {
            if (log[i].isOut) {
                croud--;
            } else {
                croud++;
            }
            maxCroud = Math.max(maxCroud, croud);
        }

        // System.out.println("max croud: " + maxCroud);
        if (maxCroud == 1) {
            return 0;
        }
        int answer = calcMaxDistance(n, maxCroud);

        return answer;
    }

    private int calcMaxDistance(int n, int maxCroud) {
        // 1 ~ n * n 중에 maxCroud뽑기.
        int[] lockers = new int[n * n];// 락커 번호
        boolean[] visited = new boolean[n * n];
        for (int i = 0; i < n * n; i++) {
            lockers[i] = i;
        }
        minDist = Integer.MIN_VALUE;
        combi(visited, lockers, 0, 0, maxCroud);

        return minDist;
    }

    int minDist;

    private void combi(boolean[] visited, int[] lockers, int start, int curCount, int maxCroud) {
        if (curCount == maxCroud) {
            ArrayList<Integer> mList = new ArrayList<>();
            for (int i = 0; i < lockers.length; i++) {
                if (visited[i]) {
                    mList.add(lockers[i]);
                }
            }
            // System.out.println( mList);
            int calcResult = calcMin(mList);
            minDist = Math.max(minDist, calcResult);
            // System.out.println(calcResult + " , " + minDist);
            return;
        }
        for (int i = start; i < lockers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(visited, lockers, i, curCount + 1, maxCroud);
                visited[i] = false;
            }
        }
    }

    //list의 두점중 가장 가까운 거리의 두점 구한다.
    private int calcMin(ArrayList<Integer> mList) {
        // List의 모든 2개 조합중 최소 거리 구함.
        boolean[] visited = new boolean[mList.size()];
        int minDist = combi2(mList, visited, 0, 0);
        return minDist;
    }

    //가장 가까운...
    private int combi2(ArrayList<Integer> mList, boolean[] visited, int start, int curCount) {
        if (curCount == 2) {
            int cnt = 0;
            int from = 0;
            int to = 0;
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    if(cnt == 0) {
                        from = mList.get(i);
                        cnt++;
                    } else {
                        to = mList.get(i);
                        break;
                    }
                }
            }

            int yDist = Math.abs(from / n - to / n);
            int xDist = Math.abs(from % n - to % n);
            //from to visited로 계산
            // System.out.println(from + "->" + to + ":" + yDist + xDist);
            return yDist + xDist;
        }
        int curMin = Integer.MAX_VALUE;
        for (int i = start; i < mList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                curMin = Math.min(curMin, combi2(mList, visited, i, curCount + 1));
                visited[i] = false;
            }
        }
        return curMin;
    }

    class Log {
        int time;
        boolean isOut;

        public Log(int time, boolean isOut) {
            this.time = time;
            this.isOut = isOut;
        }
    }
}