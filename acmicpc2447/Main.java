package acmicpc2447;

import java.io.*;

/* 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
재귀
 */

public class Main {
    static char[][] paper;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        paper = new char[N][N];
        drawStar(N, true, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(paper[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static boolean scatch[][] = {
            { true, true, true },
            { true, false, true },
            { true, true, true }
    };

    private static void drawStar(int depth, boolean print, int y, int x) {
        if (depth == 1) {
            // System.out.println(y + "," + x + ":" + print);
            if (print) {
                paper[y][x] = '*';
            } else {
                paper[y][x] = ' ';
            }
            return;
        }

        int multi = depth / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                drawStar(multi, print & scatch[i][j], y + i * multi, x + j * multi);
            }
        }

    }
}
