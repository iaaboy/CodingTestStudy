package prog92342;

import java.util.*;

/* 양궁대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */

public class MyMain {
    public static void main(String[] args) {
        int[] n = { 5, 1, 9, 10 };
        int[][] infos = {
                { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, //[0,2,2,0,1,0,0,0,0,0,0]
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //[-1]
                { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 }, //[1,1,2,0,1,2,2,0,0,0,0]
                { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 } //[1,1,1,1,1,1,1,1,0,0,2]
        };

        Solution mSol = new Solution();
        for (int i = 0; i < infos.length; i++) {
            System.out.println(Arrays.toString(mSol.solution(n[i], infos[i])));
        }

    }
}

class Solution {
    int n;
    int[] info;
    int maxScore;
    ArrayList<boolean[]> winList;

    public int[] solution(int n, int[] info) {
        boolean[] win = new boolean[11];
        winList = new ArrayList<>();
        this.n = n;
        this.info = info;
        maxScore = -1;

        dfs(win, 0);

        // System.out.println("winList: " + winList);

        int[] answer;
        if (winList.size() == 0) {
            answer = new int[] { -1 };
        } else {// if(winList.size() > 0) {
            answer = new int[info.length];
            int remainedArrow = n;
            for (int i = 0; i < n; i++) {
                if (winList.get(0)[i]) {
                    answer[i] = info[i] + 1;
                    remainedArrow-=answer[i];
                }
            }
            if(remainedArrow > 0) {
                answer[answer.length - 1] = remainedArrow;
            }
        }

        return answer;
    }

    int count = 0;

    private void dfs(boolean[] win, int depth) {
        if (depth == win.length) {
            // check 화살수
            int score = checkCount(win);
            if (score != -1) {
                if (score == maxScore) {
                    maxScore = score;
                    // System.out.println(count + ":" + score + " - " + Arrays.toString(win));
                    count++;
                    winList.add(win.clone());
                } else if (score > maxScore) {
                    maxScore = score;
                    // System.out.println(count + ":" + score + " - " + Arrays.toString(win));
                    count++;
                    winList.clear();
                    winList.add(win.clone());
                }
            }
            return;
        }

        win[depth] = true;
        dfs(win, depth + 1);
        win[depth] = false;
        dfs(win, depth + 1);

    }

    private int checkCount(boolean[] win) {
        int total = 0;
        int lionSum = 0;
        int apeachSum = 0;
        for (int i = 0; i < win.length; i++) {
            if (win[i]) {
                total += info[i] + 1;
                lionSum += win.length - 1 - i;
            } else {
                if (info[i] > 0) {
                    apeachSum += win.length - 1 - i;
                }
            }
        }
        if (apeachSum < lionSum && total <= n) {
            return lionSum;
        } else {
            return -1;
        }
    }
}