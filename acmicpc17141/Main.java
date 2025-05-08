package acmicpc17141;

import java.io.*;
import java.util.*;

/* 연구소 2
 * https://www.acmicpc.net/problem/17141
 * bfs/dfs기본.
 */

public class Main {
    static int[][] map;
    static ArrayList<Coord> v;
    static int N, M;
    static boolean[] visited;
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    v.add(new Coord(i, j));
                    zeroCount++;
                } else if (map[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        visited = new boolean[v.size()];
        traverse(0, 0);
        if (minC == Integer.MAX_VALUE) {
            minC = -1;
        }
        System.out.println(minC);
    }

    static int minC = Integer.MAX_VALUE;

    private static void traverse(int at, int count) {
        if (count == M) {
            // System.out.println("check" + Arrays.toString(visited));
            int c = exper(visited);
            if (c >= 0) {
                minC = Math.min(minC, c);
            }
            return;
        }
        for (int i = at; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                traverse(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    static int[] dx = { 0, 1, -1, 0 };
    static int[] dy = { 1, 0, 0, -1 };

    private static int exper(boolean[] visited) {
        int[][] cnt = new int[N][N];
        int max = 1;
        Queue<Coord> q = new ArrayDeque<>();
        int handledCount = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                Coord cv = v.get(i);
                // System.out.print(cv + " ");
                cnt[cv.y][cv.x] = 1;
                handledCount++;
                q.add(cv);
            }
        }
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if ((map[ny][nx] == 0 || map[ny][nx] == 2) && cnt[ny][nx] == 0) {
                    cnt[ny][nx] = cnt[c.y][c.x] + 1;
                    max = Math.max(max, cnt[ny][nx]);
                    handledCount++;
                    q.add(new Coord(ny, nx));
                }
            }
        }
        if (handledCount < zeroCount) {
            return -1;
        } else {
            return max - 1;
        }
    }

    static class Coord {
        int x, y;

        @Override
        public String toString() {
            return y + "," + x;
        }

        public Coord(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}