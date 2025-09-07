package acmicpc1553;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] dominos;
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
        dominos = new int[28][2];
        used = new boolean[28];
        int index = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos[index][0] = i;
                dominos[index][1] = j;
                index++;
            }
        }
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
                System.out.println();
                for (int i = 0; i < 8; i++) {
                    System.out.println(Arrays.toString(dp[i]));
                }
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
            for (int i = 0; i < dominos.length; i++) {
                if (!used[i]) {
                    // check 가로
                    if (isVerticalMatch(y, x, dominos[i])) {
                        used[i] = true;
                        dp[y][x] = dominos[i][0];
                        dp[y][x + 1] = dominos[i][1];

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
                    // check 세로
                    if (isHorizontalMatch(y, x, dominos[i])) {
                        used[i] = true;
                        dp[y][x] = dominos[i][0];
                        dp[y + 1][x] = dominos[i][1];

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
        }
    }

    private static boolean isHorizontalMatch(int y, int x, int[] domino) {
        if (y >= 7) {
            return false;
        }
        boolean isBlank = dp[y + 1][x] == -1 && dp[y][x] == -1;
        boolean isMatch = domino[0] == map[y][x] && domino[1] == map[y + 1][x];
        return isBlank && isMatch;
    }

    private static boolean isVerticalMatch(int y, int x, int[] domino) {
        if (x >= 6) {
            return false;
        }
        boolean isBlank = dp[y][x] == -1 && dp[y][x + 1] == -1;
        boolean isMatch = domino[0] == map[y][x] && domino[1] == map[y][x + 1];
        return isBlank && isMatch;
    }
}
