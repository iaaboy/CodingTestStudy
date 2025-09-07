package acmicpc1553;

import java.io.*;
import java.util.*;

/* 도미노 찾기
 * https://www.acmicpc.net/problem/1553
 */

public class Main {
    static ArrayList<ArrayList<Pair>> dominos;
    static int[][] map;
    static int[][] dp;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            int j = 0;
            for (char ch : bf.readLine().toCharArray()) {
                map[i][j++] = ch - '0';
            }
        }
        dominos = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                ArrayList<Pair> domino = new ArrayList<>();
                domino.add(new Pair(i, j));
                if (i != j) {
                    domino.add(new Pair(j, i));
                }
                dominos.add(domino);
            }
        }
        used = new boolean[dominos.size()];
        dp = new int[8][7];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(dp[i], -1);
        }
        traverse(0, 0);
        System.out.println(count);
    }

    static int count = 0;

    private static void traverse(int y, int x) {
        // System.out.println(y + "," + x);
        if (y == 7 && x == 6) {
            if (dp[y][x] != -1) {
                count++;
                // System.out.println();
                // for (int i = 0; i < 8; i++) {
                //     System.out.println(Arrays.toString(dp[i]));
                // }
            }
            return;
        }
        if (dp[y][x] != -1) {
            if (x == 6) {
                traverse(y + 1, 0);
            } else {
                traverse(y, x + 1);
            }
        } else {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    // check 가로
                    checkVertical(y, x, i);
                    // check 세로
                    checkHorizontal(y, x, i);
                }
            }
        }
    }

    private static void checkHorizontal(int y, int x, int i) {
        int dominoSize = dominos.get(i).size();

        for (int dominoIndex = 0; dominoIndex < dominoSize; dominoIndex++) {
            if (isHorizontalMatch(y, x, dominos.get(i).get(dominoIndex))) {
                used[i] = true;
                dp[y][x] = dominos.get(i).get(dominoIndex).front;
                dp[y + 1][x] = dominos.get(i).get(dominoIndex).back;

                // go next
                if (x == 6) {
                    traverse(y + 1, 0);
                } else {
                    traverse(y, x + 1);
                }

                dp[y][x] = -1;
                dp[y + 1][x] = -1;
                used[i] = false;
            }
        }
    }

    private static void checkVertical(int y, int x, int i) {
        int dominoSize = dominos.get(i).size();

        for (int dominoIndex = 0; dominoIndex < dominoSize; dominoIndex++) {
            if (isVerticalMatch(y, x, dominos.get(i).get(dominoIndex))) {
                used[i] = true;
                dp[y][x] = dominos.get(i).get(dominoIndex).front;
                dp[y][x + 1] = dominos.get(i).get(dominoIndex).back;

                // go next
                if (x == 6) {
                    traverse(y + 1, 0);
                } else {
                    traverse(y, x + 1);
                }

                dp[y][x] = -1;
                dp[y][x + 1] = -1;
                used[i] = false;
            }
        }
    }

    private static boolean isHorizontalMatch(int y, int x, Pair domino) {
        if (y >= 7) {
            return false;
        }
        boolean isBlank = dp[y + 1][x] == -1 && dp[y][x] == -1;
        boolean isMatch = domino.front == map[y][x] && domino.back == map[y + 1][x];
        return isBlank && isMatch;
    }

    private static boolean isVerticalMatch(int y, int x, Pair domino) {
        if (x >= 6) {
            return false;
        }
        boolean isBlank = dp[y][x] == -1 && dp[y][x + 1] == -1;
        boolean isMatch = domino.front == map[y][x] && domino.back == map[y][x + 1];
        return isBlank && isMatch;
    }

    static class Pair {
        int front;
        int back;

        public Pair(int front, int back) {
            this.front = front;
            this.back = back;
        }
    }
}
