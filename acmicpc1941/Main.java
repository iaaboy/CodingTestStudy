package acmicpc1941;

import java.io.*;
import java.util.*;

/* 소문난 칠공주
 * https://www.acmicpc.net/problem/1941
 */

 /*
BG) 5*5행렬 기준 풀이 이므로 완전 탐색 가능
25개중 7개를 고르는 backtrack.

1. Array 25개중 7개를 true로 하는 backgracking 
2. 각 케이스에서 상하좌우 인접하여 그룹이 되는 수를 센다. 7개면 true, 아니면 false
3. 조건에 맞는 수를 세어 count 출력
  */

public class Main {
    static char[][] map;
    static boolean[] visit = new boolean[5 * 5];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        backTrack(-1, 0, 0, 0);
        System.out.println(totalCount);
    }

    static long totalCount = 0;

    private static void backTrack(int at, int depth, int y, int s) {
        if (depth == 7) {
            boolean isGroup = checkGroup();
            if (isGroup) {
                // System.out.println(Arrays.toString(visit));
                // printVisit();
                totalCount++;
            }
            return;
        }
        for (int i = at + 1; i < 5 * 5; i++) {
            visit[i] = true;
            if (map[i / 5][i % 5] == 'S') {
                backTrack(i, depth + 1, y, s + 1);
            } else {
                if (y + 1 < 4) {
                    backTrack(i, depth + 1, y + 1, s);
                }
            }

            visit[i] = false;
        }
    }

    private static void printVisit() {
        for (int i = 0; i < visit.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            if (!visit[i]) {
                System.out.print("-");
            } else {
                System.out.print(map[i / 5][i % 5]);
            }
        }
        System.out.println();
    }

    private static boolean checkGroup() {
        int count = 0;
        Queue<Coord> q = new LinkedList<>();
        boolean[][] checked = new boolean[5][5];
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                checked[i / 5][i % 5] = true;
                count++;
                q.add(new Coord(i / 5, i % 5));
                break;
            }
        }

        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                if (visit[ny * 5 + nx] && !checked[ny][nx]) {
                    count++;
                    checked[ny][nx] = true;
                    q.add(new Coord(ny, nx));
                }
            }
        }

        return count == 7;
    }

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
}