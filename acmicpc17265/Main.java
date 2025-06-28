package acmicpc17265;

/* 나의 인생에는 수학과 함께
 * https://www.acmicpc.net/problem/17265
 */

import java.io.*;
import java.util.*;

public class Main {
    static int INF = 20000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().replace(" ", "").toCharArray();
        }
        int[][] max = new int[N][N];
        int[][] min = new int[N][N];
        for (int i = 0; i < min.length; i++) {
            Arrays.fill(min[i], INF);
        }
        max[0][0] = map[0][0] - '0';
        min[0][0] = map[0][0] - '0';
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if ((i + j) % 2 == 0) {// 숫자만
                    // 좌
                    // max
                    int left = j >= 2 ? max[i][j - 2] : -INF;
                    int up = i >= 2 ? max[i - 2][j] : -INF;
                    int upleft = (i >= 1 && j >= 1) ? max[i - 1][j - 1] : -INF;
                    int leftMax = j >= 1 ? calc(left, map[i][j - 1], map[i][j] - '0') : -INF;
                    int upMax = i >= 1 ? calc(up, map[i - 1][j], map[i][j] - '0') : -INF;
                    int upleftMax1 = j >= 1 ? calc(upleft, map[i][j - 1], map[i][j] - '0') : -INF;
                    int upleftMax2 = i >= 1 ? calc(upleft, map[i - 1][j], map[i][j] - '0') : -INF;
                    max[i][j] = Math.max(Math.max(leftMax, upMax), Math.max(upleftMax1, upleftMax2));
                    // 상
                    left = j >= 2 ? min[i][j - 2] : INF;
                    up = i >= 2 ? min[i - 2][j] : INF;
                    upleft = (i >= 1 && j >= 1) ? min[i - 1][j - 1] : INF;
                    int leftMin = j >= 1 ? calc(left, map[i][j - 1], map[i][j] - '0') : INF;
                    int upMin = i >= 1 ? calc(up, map[i - 1][j], map[i][j] - '0') : INF;
                    int upleftMin1 = j >= 1 ? calc(upleft, map[i][j - 1], map[i][j] - '0') : INF;
                    int upleftMin2 = i >= 1 ? calc(upleft, map[i - 1][j], map[i][j] - '0') : INF;
                    min[i][j] = Math.min(Math.min(leftMin, upMin), Math.min(upleftMin1, upleftMin2));
                }
            }
        }
        System.out.println(max[N - 1][N - 1] + " " + min[N - 1][N - 1]);
    }

    private static int calc(int i, char c, int j) {
        int result = 0;
        switch (c) {
            case '+':
                result = i + j;
                break;
            case '-':
                result = i - j;
                break;
            case '*':
                result = i * j;
                break;
            default:
                break;
        }
        return result;
    }
}