package acmicpc6593;

import java.io.*;
import java.util.*;

/* 상범 빌딩
 * https://www.acmicpc.net/problem/6593
 */

public class Main {
    static int OUT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        while (!(L == 0 && R == 0 && C == 0)) {
            Queue<Coord> q = new ArrayDeque<>();
            int[][][] arr = new int[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    char[] m = bf.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (m[c] == '#') {
                            arr[l][r][c] = -1;
                        } else if (m[c] == 'S') {
                            arr[l][r][c] = 1;
                            q.add(new Coord(l, r, c));
                        } else if (m[c] == 'E') {
                            arr[l][r][c] = OUT;
                        }
                    }
                }
                bf.readLine();
            }

            int result = advanture(L, R, C, q, arr);
            if (result > 0) {
                sb.append("Escaped in " + result + " minute(s).\n");
            } else {
                sb.append("Trapped!\n");
            }

            st = new StringTokenizer(bf.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    private static int advanture(int L, int R, int C, Queue<Coord> q, int[][][] arr) {
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextL = c.l + offsetL[i];
                int nextR = c.r + offsetR[i];
                int nextC = c.c + offsetC[i];
                if (nextL < 0 || nextR < 0 || nextC < 0) {
                    continue;
                }
                if (nextL >= L || nextR >= R || nextC >= C) {
                    continue;
                }
                if (arr[nextL][nextR][nextC] == OUT) {
                    return arr[c.l][c.r][c.c];
                }
                if (arr[nextL][nextR][nextC] == 0) {
                    arr[nextL][nextR][nextC] = arr[c.l][c.r][c.c] + 1;
                    q.add(new Coord(nextL, nextR, nextC));
                }
            }
        }
        return -1;
    }

    static int[] offsetL = { 1, -1, 0, 0, 0, 0 };
    static int[] offsetR = { 0, 0, 1, -1, 0, 0 };
    static int[] offsetC = { 0, 0, 0, 0, 1, -1 };

    static class Coord {
        int l, r, c;

        public Coord(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
}
