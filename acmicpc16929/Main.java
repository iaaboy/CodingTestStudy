package acmicpc16929;

import java.io.*;
import java.util.*;

/* Two Dots
 * https://www.acmicpc.net/problem/16929
 *  DFS
 */

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    if (checkCycle(-1, -1, i, j, map[i][j])) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, 1, -1, 0 };

    private static boolean checkCycle(int parentY, int parentX, int y, int x, char c) {
        // System.out.println(parentY + " " + parentX + " -> " + y + " " + x); 
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            if (parentX == nx && parentY == ny)
                continue;

            if (visit[ny][nx] && map[ny][nx] == c) {
                // System.out.println("Cycle : " + c);
                // System.out.println(y + " " + x + " " + ny + " " + nx);
                return true;
            }

            if (!visit[ny][nx] && map[ny][nx] == c) {
                visit[ny][nx] = true;
                if(checkCycle(y, x, ny, nx, c)) {
                    return true;
                };
            }
        }

        return result;
    }
}
