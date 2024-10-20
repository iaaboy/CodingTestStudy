package prog49191;

import java.util.*;

/* 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
public class MyMain {
    public static void main(String[] args) {
        int[] n = { 5, 5 };
        int[][][] results = {
                { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } },
                { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }
        };
        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(n[i], results[i]));
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        char[][] winMap = new char[n + 1][n + 1];
        for (int[] r : results) {
            winMap[r[0]][r[1]] = 'W';
            winMap[r[1]][r[0]] = 'L';
        }

        // printWinMap(winMap);

        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int j = 1; j <= n; j++) {
                ArrayList<Integer> win = new ArrayList<>();
                ArrayList<Integer> lost = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    if (winMap[j][i] == 'W') {
                        lost.add(i);
                    } else if (winMap[j][i] == 'L') {
                        win.add(i);
                    }
                }
                if (win.size() > 0 && lost.size() > 0) {
                    isChanged = updateMap(winMap, win, lost);
                }
            }
        }

        // printWinMap(winMap);

        int answer = 0;
        for (int j = 1; j <= n; j++) {
            boolean distinguishable = true;
            for (int i = 1; i <= n; i++) {
                if (i != j && winMap[j][i] != 'W' && winMap[j][i] != 'L') {
                    distinguishable = false;
                }
            }
            if (distinguishable) {
                answer++;
            }
        }

        return answer;
    }

    private boolean updateMap(char[][] winMap, ArrayList<Integer> win, ArrayList<Integer> lost) {
        boolean result = false;

        for (int w : win) {
            for (int l : lost) {
                if (winMap[w][l] == 0) {
                    winMap[w][l] = 'W';
                    winMap[l][w] = 'L';
                    result = true;
                }
            }
        }

        return result;
    }

    void printWinMap(char[][] winMap) {
        for (char[] line : winMap) {
            System.out.println(Arrays.toString(line));
        }
    }
}