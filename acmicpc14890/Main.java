package acmicpc14890;

import java.io.*;
import java.util.*;

/* 경사로
 * https://www.acmicpc.net/problem/14890
 */

public class Main {
    static int[][] map;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += checkLine(i, true);
        }
        // System.out.println("Horizontal: " + count);
        int countVer = 0;
        for (int i = 0; i < N; i++) {
            countVer += checkLine(i, false);
        }
        // System.out.println("Vertical: " + countVer);
        System.out.println(count + countVer);
    }

    private static int checkLine(int l, boolean isHorizontal) {
        if (isHorizontal) {
            boolean[] hasRamp = new boolean[N];
            for (int i = 1; i < N; i++) {
                int diff = map[l][i] - map[l][i - 1];
                if (diff == 0) {
                    // do nothing
                } else if (diff == 1) { // 2 2 3
                    int targetNum = map[l][i - 1];
                    for (int j = i - 1; j >= i - L; j--) {
                        if (j < 0 || hasRamp[j] || map[l][j] != targetNum) {
                            return 0;
                        } else {
                            hasRamp[j] = true;
                        }
                    }
                } else if (diff == -1) { // 3 2 2
                    int targetNum = map[l][i];
                    for (int j = i; j < i + L; j++) {
                        if (j >= N || hasRamp[j] || map[l][j] != targetNum) {
                            return 0;
                        } else {
                            hasRamp[j] = true;
                        }
                    }
                } else { // 2 이상 불가능
                    return 0;
                }
            }
        } else {
            boolean[] hasRamp = new boolean[N];
            for (int i = 1; i < N; i++) {
                int diff = map[i][l] - map[i - 1][l];
                if (diff == 0) {
                    // do nothing
                } else if (diff == 1) { // 2 2 3
                    int targetNum = map[i - 1][l];
                    for (int j = i - 1; j >= i - L; j--) {
                        if (j < 0 || hasRamp[j] || map[j][l] != targetNum) {
                            return 0;
                        } else {
                            hasRamp[j] = true;
                        }
                    }
                } else if (diff == -1) { // 3 2 2
                    int targetNum = map[i][l];
                    for (int j = i; j < i + L; j++) {
                        if (j >= N || hasRamp[j] || map[j][l] != targetNum) {
                            return 0;
                        } else {
                            hasRamp[j] = true;
                        }
                    }
                } else { // 2 이상 불가능
                    return 0;
                }
            }
        }
        return 1;
    }
}