package acmicpc6987;

import java.io.*;
import java.util.*;

/* 월드컵
 * https://www.acmicpc.net/problem/6987
 * 백트래킹
 */

public class Main {
    static int[][] wins = new int[6][3];
    static int[] game = new int[15];
    static int[][] inputWins = new int[6][3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 6; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    inputWins[j][j2] = Integer.parseInt(st.nextToken());
                }
            }
            go(0);
            sb.append(haResult ? 1 : 0).append(" ");
            haResult = false;
        }

        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    final static int A = 0;
    final static int B = 1;
    final static int C = 2;
    final static int D = 3;
    final static int E = 4;
    final static int F = 5;

    static boolean haResult = false;
    static int[] left = { A, A, A, A, A, B, B, B, B, C, C, C, D, D, E };
    static int[] right = { B, C, D, E, F, C, D, E, F, D, E, F, E, F, F };

    private static void go(int depth) {
        if (haResult) {
            return;
        }
        if (depth >= game.length) {
            boolean isSame = true;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (wins[i][j] != inputWins[i][j]) {
                        isSame = false;
                    }
                }
            }
            if (isSame) {
                haResult = true;
                // sb.append("Hit");
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            wins[left[depth]][i]++;
            wins[right[depth]][2 - i]++;
            if (wins[left[depth]][i] <= inputWins[left[depth]][i] && wins[right[depth]][2 - i] <= inputWins[right[depth]][2 - i]) {
                go(depth + 1);
            }
            wins[left[depth]][i]--;
            wins[right[depth]][2 - i]--;
        }
    }
}
