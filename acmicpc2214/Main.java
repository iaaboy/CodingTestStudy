package acmicpc2214;

import java.io.*;
import java.util.*;

/* 성냥개비와 정사각형
 * https://www.acmicpc.net/problem/2214
 */

public class Main {
    static int R, C;
    static Lngth[][] leftOver, rightUnder;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (R != 0 && C != 0) {
            total = 0;
            boolean[][] arrC = new boolean[R + 1][C];
            boolean[][] arrR = new boolean[R][C + 1];
            int r = 0;
            for (; r < R; r++) {
                char[] cIn = bf.readLine().toCharArray();
                for (int i = 0; i < cIn.length; i++) {
                    arrC[r][i] = cIn[i] == '-';
                }
                cIn = bf.readLine().toCharArray();
                for (int i = 0; i < cIn.length; i++) {
                    arrR[r][i] = cIn[i] == '|';
                }
            }
            char[] cIn = bf.readLine().toCharArray();
            for (int i = 0; i < cIn.length; i++) {
                arrC[r][i] = cIn[i] == '-';
            }
            rightUnder = new Lngth[R][C];

            for (int j = 0; j < R; j++) {
                int accC = 0;
                for (int i = C - 1; i >= 0; i--) {
                    if (arrC[j][i]) {
                        accC++;
                    } else {
                        accC = 0;
                    }
                    rightUnder[j][i] = new Lngth(0, accC);
                }
            }
            for (int i = 0; i < C; i++) {
                int accR = 0;
                for (int j = R - 1; j >= 0; j--) {
                    if (arrR[j][i]) {
                        accR++;
                    } else {
                        accR = 0;
                    }
                    rightUnder[j][i].r = accR;
                }
            }
            printArr(rightUnder);
            leftOver = new Lngth[R + 1][C + 1];
            for (int j = 1; j <= R; j++) {
                int accC = 0;
                for (int i = 1; i <= C; i++) {
                    if (arrC[j][i - 1]) {
                        accC++;
                    } else {
                        accC = 0;
                    }
                    leftOver[j][i] = new Lngth(0, accC);
                }
            }
            // printArr(leftOver);
            for (int i = 1; i <= C; i++) {
                int accR = 0;
                for (int j = 1; j <= R; j++) {
                    if (arrR[j - 1][i]) {
                        accR++;
                    } else {
                        accR = 0;
                    }
                    leftOver[j][i].r = accR;
                }
            }
            printArr(leftOver);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    checkPoints(i, j);
                }
            }

            sb.append(total + " squares\n");

            st = new StringTokenizer(bf.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    private static void checkPoints(int r, int c) {
        // System.out.println("CheckPoint: " + r + "," + c);
        for (int area = 1; area + r <= R && area + c <= C; area++) {
            // System.out.print(r + "," + c + "-" + (r + area) + "," + (c + area));
            boolean result = (area <= rightUnder[r][c].r && area <= rightUnder[r][c].c
                    && area <= leftOver[r + area][c + area].r && area <= leftOver[r + area][c + area].c);
            if (result) {
                total++;
            }
            // System.out.println(
            // " : " + area + " , " + rightUnder[r][c] + " , " + leftOver[r + area][c +
            // area] + " >> " + result);
        }
    }

    private static void printArr(Lngth[][] arr) {
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(Arrays.toString(arr[i]));
        // }
    }

    static class Lngth {
        int r;
        int c;

        public Lngth(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return r + "," + c;
        }
    }
}
