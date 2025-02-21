package acmicpc5578;

import java.io.*;
import java.util.*;

/* 薄氷渡り
 * https://www.acmicpc.net/problem/5578
 */

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(bf.readLine()); // 가로
        N = Integer.parseInt(bf.readLine()); // 세로

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    boolean[][] visit = new boolean[N][M];
                    // System.out.println("Start travel: " + i + "," + j);
                    visit[i][j] = true;
                    travel(visit, i, j, 4, 1);
                }
            }
        }
        System.out.println(maxDist);
    }

    static int maxDist = 0;

    private static void travel(boolean[][] visit, int y, int x, int prevDir, int distance) {

        maxDist = Math.max(distance, maxDist);
        // System.out.println(y + "," + x + "," + dString[prevDir] + ":" + distance);

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY >= 0 && nY < N && nX >= 0 && nX < M) {
                if (!visit[nY][nX] && map[nY][nX] == 1) {
                    visit[nY][nX] = true;
                    travel(visit, nY, nX, i, distance + 1);
                    visit[nY][nX] = false;
                }
            }
        }
        return;
    }

    // 동 북 서 남
    static String[] dString = { "동", "북", "서", "남 ", "All" };
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
}
