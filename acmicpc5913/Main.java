package acmicpc5913;

import java.io.*;
import java.util.*;

/* 준규와 사과
 * https://www.acmicpc.net/problem/5913
 * 완전탐색
 */

public class Main {
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        map = new int[5][5];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 100;
        }
        map[0][0] = 200;
        map[4][4] = 300;
        int leftCount = 25 - K - 2;
        visitNext(0, 0, 4, 4, leftCount);
        System.out.println(count);
    }

    static int count = 0;
    static int[] dx = { 0, -1, 1, 0 };
    static int[] dy = { 1, 0, 0, -1 };

    static void visitNext(int jy, int jx, int hy, int hx, int leftCount) {
        if (leftCount == -1) {
            count++;
            // System.out.println(count);
            // for (int i = 0; i < 5; i++) {
            // System.out.println(Arrays.toString(map[i]));
            // }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int djx = jx + dx[i];
            int djy = jy + dy[i];
            if (djx < 0 || djy < 0 || djx >= 5 || djy >= 5) {
                continue;
            }
            if (map[djy][djx] == 0) {

                for (int j = 0; j < 4; j++) {
                    int dhx = hx + dx[j];
                    int dhy = hy + dy[j];
                    if (dhx < 0 || dhy < 0 || dhx >= 5 || dhy >= 5) {
                        continue;
                    }
                    if (map[dhy][dhx] == 0) {
                        if (leftCount != 1 && djy == dhy && djx == dhx) {
                            continue;
                        }
                        map[djy][djx] = leftCount;
                        map[dhy][dhx] = leftCount;
                        visitNext(djy, djx, dhy, dhx, leftCount - 2);
                        map[dhy][dhx] = 0;
                        map[djy][djx] = 0;
                    }
                }
            }
        }
    }
}