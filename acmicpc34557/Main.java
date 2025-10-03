package acmicpc34557;

import java.io.*;
import java.util.*;

/* 횃불이의 모험
 * https://www.acmicpc.net/problem/34557
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int cy = 0, cx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    cy = i;
                    cx = j;
                    map[i][j] = 0;
                }
            }
        }

        char[] keys = { 'W', 'A', 'S', 'D' };
        String[] events = new String[4];
        for (int i = 0; i < 4; i++) {
            events[i] = bf.readLine();
        }
        ;

        char[] inChr = bf.readLine().toCharArray();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        int[] preState = new int[4];

        for (char c : inChr) {
            for (int i = 0; i < 4; i++) {
                int cur = (c == keys[i]) ? 1 : 0;

                if (executeEvent(events[i], preState[i], cur)) {
                    int ny = cy + dx[i];
                    int nx = cx + dy[i];
                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == 0) {
                        cy = ny;
                        cx = nx;
                    }
                }

                preState[i] = cur;
            }
        }

        System.out.println((cy + 1) + " " + (cx + 1));

    }

    private static boolean executeEvent(String event, int pre, int cur) {
        if (event.equals("Down"))
            return pre == 0 && cur == 1;
        if (event.equals("Stay"))
            return pre == 1 && cur == 1;
        if (event.equals("Up"))
            return pre == 1 && cur == 0;
        return false;
    }

}
