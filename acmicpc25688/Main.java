package acmicpc25688;

import java.io.*;
import java.util.*;

/* 빠른 무작위 숫자 탐색
 * https://www.acmicpc.net/problem/25688
 */

public class Main {
    static int N = 5;
    static int[][] map = new int[N][N];
    static Coord[] steps = new Coord[N + 2];
    static int[] index = new int[N + 1];
    static Coord start;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    steps[map[i][j]] = new Coord(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < index.length; i++) {
            index[i] = i + 1;
        }
        permute(0);
        if (minCost == Integer.MAX_VALUE) {
            minCost = -1;
        }
        System.out.println(minCost);
    }

    static int[] dx = { 0, 1, -1, 0 };
    static int[] dy = { 1, 0, 0, -1 };
    static boolean[][] visit = new boolean[N][N];

    static int travel(Coord from, Coord to) {
        if (from.x == to.x && from.y == to.y) {
            return 0;
        }
        Queue<Coord> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }

        visit[from.y][from.x] = true;
        q.add(from);
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (!visit[ny][nx]) {

                    visit[ny][nx] = true;
                    if (map[ny][nx] == -1) {
                        continue;
                    }
                    if (ny == to.y && nx == to.x) {
                        return c.cost + 1;
                    }
                    q.add(new Coord(ny, nx, c.cost + 1));
                }
            }
        }
        return -1;
    }

    static int minCost = Integer.MAX_VALUE;

    static void permute(int depth) {
        if (depth == index.length) {
            int totalCost = 0;
            Coord current = start;
            for (int index : index) {
                int subCost = travel(current, steps[index]);
                if (subCost == -1) {
                    totalCost = -1;
                    break;
                }
                current = steps[index];
                totalCost += subCost;
                // if (totalCost > minCost) {
                // return;
                // }
            }
            // System.out.println(Arrays.toString(index) + ":" + totalCost);
            if (totalCost == -1) {
                return;
            }
            minCost = Math.min(minCost, totalCost);
            return;
        }

        for (int i = depth; i < index.length; i++) {
            swap(index, depth, i);
            permute(depth + 1);
            swap(index, depth, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class Coord {
        int y, x;
        int cost = 0;

        public Coord(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ")";
        }
    }
}
