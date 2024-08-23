package acmicpc1189;

import java.io.*;
import java.util.*;

/* 컴백홈
 * https://www.acmicpc.net/problem/1189
 */

public class Main {
    static char[][] arr;
    static int R, C, K;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt((st.nextToken()));
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = R - 1; i >= 0; i--) {
            arr[i] = bf.readLine().toCharArray();
        }
        boolean[][] visit = new boolean[R][C];
        visit[0][0] = true;
        visitNext(visit, 0, 0, 1);
        System.out.println(count);
    }

    private static void visitNext(boolean[][] visit, int y, int x, int distance) {
        if (distance == K && y == R - 1 && x == C - 1) {
            count++;
            return;
        } else if (distance > K) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + offsetX[i];
            int nextY = y + offsetY[i];
            if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R)
                continue;
            if (!visit[nextY][nextX] && arr[nextY][nextX] != 'T') {
                visit[nextY][nextX] = true;
                visitNext(visit, nextY, nextX, distance + 1);
                visit[nextY][nextX] = false;
            }
        }
    }

    static int[] offsetY = { 0, -1, 0, 1 };
    static int[] offsetX = { -1, 0, 1, 0 };
}
