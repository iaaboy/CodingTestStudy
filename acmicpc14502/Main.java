package acmicpc14502;

import java.io.*;
import java.util.*;

/* 연구소 3
 * https://www.acmicpc.net/problem/17142
 * bfs
 */

public class Main {
    static int[][] map;
    static ArrayList<Coord> two, zero;
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        two = new ArrayList<>();
        zero = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    two.add(new Coord(i, j));
                } else if (map[i][j] == 0) {
                    zero.add(new Coord(i, j));
                }
            }
        }
        visited = new boolean[zero.size()];

        traverse(0, 0);

        System.out.println(max);
    }

    static int max = 0;

    private static void traverse(int at, int count) {
        if (count == 3) {
            int c = exper(visited);
            if (max < c) {
                max = c;
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
        int[][] cnt = new int[N][M];
        int count = 0;
        for (Coord t : two) {
            cnt[t.y][t.x] = 2;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                Coord c = zero.get(i);
                cnt[c.y][c.x] = 3;
            }
        }
        Queue<Coord> q = new ArrayDeque<>(two);
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (map[ny][nx] == 0 && cnt[ny][nx] == 0) {
                    cnt[ny][nx] = 1;
                    count++;
                    q.add(new Coord(ny, nx));
                }
            }
        }

        // System.out.println();
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.print(cnt[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(zero.size() - count - 3);

        return zero.size() - count - 3;
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