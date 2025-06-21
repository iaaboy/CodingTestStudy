package acmicpc15683;

import java.io.*;
import java.util.*;

/* 감시
 * https://www.acmicpc.net/problem/15683
 * 구현!
 */

public class Main {
    static int[][] map;
    static int N, M;
    static int totalZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    CctvCount++;
                }
                if (map[i][j] == 0) {
                    totalZero++;
                }
            }
        }
        dir = new int[CctvCount];
        cctv = new CCTV[CctvCount];
        int ccIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv[ccIdx++] = new CCTV(i, j, map[i][j]);
                }
            }
        }
        checkMap(0);
        System.out.println(result);
    }

    static int CctvCount = 0;
    static int[] dir;
    static CCTV[] cctv;
    static int[][][] cctvDirection = {
            {},
            { { 0 }, { 1 }, { 2 }, { 3 } },
            { { 0, 2 }, { 1, 3 } },
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, },
            { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } },
            { { 0, 1, 2, 3 } },
    };

    private static void checkMap(int d) {
        if (CctvCount == d) {
            countBlindSpot();
            return;
        }
        for (int i = 0; i < cctvDirection[cctv[d].type].length; i++) {
            dir[d] = i;
            checkMap(d + 1);
        }
    }

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result = Integer.MAX_VALUE;

    private static void countBlindSpot() {
        boolean[][] blindMap = new boolean[N][M];
        for (int i = 0; i < dir.length; i++) {
            // System.out.println(cctv[i] + " : " +
            // Arrays.toString(cctvDirection[cctv[i].type][dir[i]]));
            int y = cctv[i].y;
            int x = cctv[i].x;
            int[] dirs = cctvDirection[cctv[i].type][dir[i]];
            for (int d : dirs) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                        break;
                    }
                    if (map[ny][nx] == 6) {
                        break;
                    }
                    if (map[ny][nx] == 0) {
                        blindMap[ny][nx] = true;
                    }
                }
            }
        }
        int nonBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // System.out.print(blindMap[i][j] ? "#" : "-");
                if (blindMap[i][j]) {
                    nonBlindCount++;
                }
            }
            // System.out.println("");
        }
        // System.out.println(totalZero - nonBlindCount);
        result = Math.min(result, totalZero - nonBlindCount);
    }

    static class CCTV {
        int y, x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        @Override
        public String toString() {
            return y + "," + x + "(" + type + ")";
        }
    }
}
