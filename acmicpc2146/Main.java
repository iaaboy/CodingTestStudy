package acmicpc2146;

import java.io.*;
import java.util.*;

/* 다리 만들기
 * https://www.acmicpc.net/problem/2146
 */

public class Main {
    static int[][] map;
    static int N;
    static ArrayList<ArrayList<Coord>> landList = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int indexCount = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    unionLand(i, j, indexCount--);
                }
            }
        }

        int index = -1;
        int minDist = Integer.MAX_VALUE;
        for (ArrayList<Coord> lands : landList) {
            // System.out.println(lands);
            minDist = Math.min(minDist, voyage(lands, index--));
            printMap();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0) {
                        map[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(minDist);
    }

    private static void printMap() {
        // for (int k = 0; k < N; k++) {
        //     System.out.println(Arrays.toString(map[k]));
        // }
    }

    static int INF = Integer.MAX_VALUE;

    private static int voyage(ArrayList<Coord> lands, int myId) {
        int result = INF;
        Queue<Sail> sailQ = new ArrayDeque<>();
        for (Coord coord : lands) {
            sailQ.add(new Sail(coord.y, coord.x, 0));
        }
        while (!sailQ.isEmpty()) {
            Sail c = sailQ.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + offX[i];
                int nextY = c.y + offY[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (map[nextY][nextX] == 0) {
                    // sailing sea
                    map[nextY][nextX] = c.distance + 1;
                    sailQ.add(new Sail(nextY, nextX, c.distance + 1));
                } else if (map[nextY][nextX] < 0 && map[nextY][nextX] != myId) {
                    // met another lands
                    // System.out.println(nextY + "," + nextX + ":" + (c.distance));
                    result = c.distance;
                    return result;
                }
            }
        }
        return result;
    }

    private static void unionLand(int y, int x, int id) {
        ArrayList<Coord> coords = new ArrayList<>();
        landList.add(coords);
        Queue<Coord> q = new ArrayDeque<>();
        Coord coord = new Coord(y, x);
        q.add(coord);
        coords.add(coord);

        map[y][x] = id;
        while (!q.isEmpty()) {
            Coord c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = c.x + offX[i];
                int nextY = c.y + offY[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (map[nextY][nextX] == 1) {
                    map[nextY][nextX] = id;
                    coord = new Coord(nextY, nextX);
                    q.add(coord);
                    coords.add(coord);
                }
            }
        }
    }

    static int[] offX = { 1, 0, 0, -1 };
    static int[] offY = { 0, 1, -1, 0 };

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ")";
        }
    }

    static class Sail {
        int y, x;
        int distance;

        public Sail(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ":" + distance + ")";
        }
    }
}