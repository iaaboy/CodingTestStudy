package prog92342;

import java.util.*;

/* 양궁대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 5, 1, 9, 10 };
        int[][] infos = {
                { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, // [0,2,2,0,1,0,0,0,0,0,0]
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // [-1]
                { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 }, // [1,1,2,0,1,2,2,0,0,0,0]
                { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 } // [1,1,1,1,1,1,1,1,0,0,2]
        };

        Solution mSol = new Solution();
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(mSol.solution(n[i], infos[i])));
        }

    }
}

class Solution {
    int n;
    int[] info;
    int maxScore;
    boolean[] maxWin;

    public int[] solution(int n, int[] info) {
        boolean[] win = new boolean[11];
        this.n = n;
        this.info = info;
        maxScore = -1;

        dfs(win, 0);

        if (maxScore == -1) {
            return new int[] { -1 };
        }
        int[] answer = new int[info.length];
        int remainedArrow = n;
        for (int i = 0; i < answer.length; i++) {
            if (maxWin[i]) {
                answer[i] = info[i] + 1;
                remainedArrow -= answer[i];
            }
        }
        if (remainedArrow > 0) {
            answer[answer.length - 1] = remainedArrow;
        }
        return answer;
    }

    private void dfs(boolean[] win, int depth) {
        if (depth == win.length) {
            int score = calcScore(win);
            if (score != -1) {
                if (score == maxScore) {
                    maxScore = score;
                    // System.out.println(score + " - " + Arrays.toString(win));
                    maxWin = compareWins(maxWin, win.clone());
                } else if (score > maxScore) {
                    maxScore = score;
                    // System.out.println(score + " - " + Arrays.toString(win));
                    maxWin = win.clone();
                }
            }
            return;
        }
        win[depth] = true;
        dfs(win, depth + 1);
        win[depth] = false;
        dfs(win, depth + 1);
    }

    // 동점일 때 낮은 점수로 맞혔을 때 우선
    private boolean[] compareWins(boolean[] yourWin, boolean[] myWin) {
        for (int i = myWin.length - 1; i >= 0; i--) {
            if (yourWin[i] && !myWin[i]) {
                return yourWin;
            } else if (!yourWin[i] && myWin[i]) {
                return myWin;
            }
        }
        return yourWin;
    }

    private int calcScore(boolean[] win) {
        int totalArrow = 0;
        int lionSum = 0;
        int apeachSum = 0;
        for (int i = 0; i < win.length; i++) {
            if (win[i]) {
                totalArrow += info[i] + 1;
                lionSum += win.length - 1 - i;
            } else {
                if (info[i] > 0) {
                    apeachSum += win.length - 1 - i;
                }
            }
        }
        if (apeachSum < lionSum && totalArrow <= n) {
            return lionSum - apeachSum; // 라이언과 어피치의 점수차!!
        } else {
            return -1;
        }
    }
}