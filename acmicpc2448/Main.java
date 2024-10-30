package acmicpc2448;

import java.io.*;
import java.util.*;

/* 별 찍기 - 11
 * https://www.acmicpc.net/problem/2448
 */

public class Main {
    static char[][] arr;
    static int W, H;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int H = Integer.parseInt(bf.readLine());
        int K = -1;
        int N = H / 3;
        while (N >= 1) {
            N /= 2;
            K++;
        }
        W = (int) (Math.pow(2, K) - 1) + 5 * (int) Math.pow(2, K);
        arr = new char[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(arr[i], ' ');
        }
        // System.out.println(H + "," + W + "," + K);
        printStar(0, W / 2, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static char[][] star = {
            { ' ', ' ', '*', ' ', ' ' },
            { ' ', '*', ' ', '*', ' ' },
            { '*', '*', '*', '*', '*' }
    };
    // static char[][] star = {
    // { '-', '-', '*', '-', '-' },
    // { '-', '*', '-', '*', '-' },
    // { '*', '*', '*', '*', '*' }
    // };

    private static void printStar(int y, int x, int k) {
        int w = (int) (Math.pow(2, k) - 1) + 5 * (int) Math.pow(2, k);
        int h = 3 * (int) Math.pow(2, k);
        // System.out.println(" y:" + y + " x:" + x + " w:" + w + " h:" + h + " k:" +
        // k);

        if (k == 0) {
            int sy = 0;
            int sx = 0;
            int xstart = x - 2;
            for (int i = y; i < y + 3; i++) {
                sx = 0;
                for (int j = xstart; j < xstart + 5; j++) {
                    arr[i][j] = star[sy][sx];
                    sx++;
                }
                sy++;
            }
            return;
        }
        // 세군데 재귀 호출
        // 1. 제자리
        printStar(y, x, k - 1);

        // 2,3 삼각형 좌우
        printStar(y + h / 2, x + (1 + w / 4), k - 1);
        printStar(y + h / 2, x - (1 + w / 4), k - 1);
    }
}
