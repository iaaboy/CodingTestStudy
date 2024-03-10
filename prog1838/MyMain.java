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
        ArrayList<Loker> list = new ArrayList<>();

        for (int maxDist = 2 * (n - 1); maxDist >= 1; maxDist--) {
            for (int startY = 0; startY < n; startY++) {
                list.clear();
                int count = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (x == 0 && y < startY) {
                            continue;
                        }
                        boolean flag = true;
                        for (Loker p : list) {
                            if (Math.abs(p.x - x) + Math.abs(p.y - y) < maxDist) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            count++;
                            if (count == maxCroud) {
                                return maxDist;
                            }
                            list.add(new Loker(y, x));
                        }
                    }
                }
            }
        }
        return 1;
    }

    class Loker {
        int y;
        int x;

        public Loker(int y, int x) {
            this.y = y;
            this.x = x;
        }
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