package acmicpc17472;

import java.io.*;
import java.util.*;

/* 다리 만들기 2
 * https://www.acmicpc.net/problem/17472
MST + dfs 문제
 */

public class Main {
    static int[][] map;
    static int N, M;
    static int[] ids;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = -Integer.parseInt(st.nextToken());
            }
        }

        int idCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    setGroup(i, j, ++idCount);

                }
            }
        }
        ids = new int[idCount + 1];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }

        ArrayList<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    getBridge(bridges, i, j);
                }
            }
        }

        bridges.sort(null);

        int bridgeCount = 0;
        int costSum = 0;
        for (Bridge b : bridges) {
            if (getUnion(b.from) != getUnion(b.to)) {
                setUnion(b.from, b.to);
                costSum += b.cost;
                bridgeCount++;
                if (bridgeCount == idCount - 1) {
                    break;
                }
            }
        }

        if (bridgeCount == idCount - 1) {
            System.out.println(costSum);
        } else {
            System.out.println(-1);
        }

        // printMap("Mid");
        // System.out.println(bridges);

    }

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
    }

    private static void getBridge(ArrayList<Bridge> bridges, int y, int x) {
        int myId = map[y][x];
        for (int i = 0; i < 4; i++) {
            int zeroCount = 0;
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == myId)
                continue;
            while (map[ny][nx] == 0) {
                zeroCount++;
                ny += dy[i];
                nx += dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == myId) {
                    zeroCount = 0;
                    break;
                }
            }
            if (zeroCount >= 2) {
                bridges.add(new Bridge(map[y][x], map[ny][nx], zeroCount));
            }
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int from, to;
        int cost;

        public Bridge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return from + "-" + to + "(" + cost + ")";
        }

        @Override
        public int compareTo(Bridge o) {
            return cost - o.cost;
        }
    }

    private static void printMap(String msg) {
        System.out.println(msg);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static int[] dx = { 0, 1, -1, 0 };
    static int[] dy = { 1, 0, 0, -1 };

    private static void setGroup(int y, int x, int id) {
        Queue<Coord> q = new ArrayDeque<>();
        map[y][x] = id;
        q.add(new Coord(y, x));

        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = c.y + dy[i];
                int nx = c.x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;
                if (map[ny][nx] == -1) {
                    map[ny][nx] = id;
                    q.add(new Coord(ny, nx));
                }
            }
        }
    }

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}