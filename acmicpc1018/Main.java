package acmicpc1018;

import java.io.*;
import java.util.*;

/* 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] chess = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] inCh = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                chess[i][j] = inCh[j] == 'B';
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                result = Math.min(result, getCount(j, i, chess));
            }
        }
        System.out.println(result);
    }

    static boolean cmp[][] = {
            { true, false, true, false, true, false, true, false },
            { false, true, false, true, false, true, false, true },
            { true, false, true, false, true, false, true, false },
            { false, true, false, true, false, true, false, true },
            { true, false, true, false, true, false, true, false },
            { false, true, false, true, false, true, false, true },
            { true, false, true, false, true, false, true, false },
            { false, true, false, true, false, true, false, true },
    };

    static int getCount(int x, int y, boolean[][] chess) {
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i + y][j + x] == cmp[i][j]) {
                    count++;
                } else {
                    count2++;
                }
            }
        }
        return Math.min(count, count2);
    }
}
