package acmicpc21772;

import java.io.*;
import java.util.*;

/* 가희의 고구마 먹방
 * https://www.acmicpc.net/problem/21772
 */

public class Main {
    static int T;
    static int R;
    static int C;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        int startR = -1;
        int startC = -1;
        for (int i = 0; i < R; i++) {
            arr[i] = bf.readLine().toCharArray();
            if (startR == -1) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] == 'G') {
                        startR = i;
                        startC = j;
                    }
                }
            }
        }
        Coord[] visited = new Coord[T];
        visitNext(visited, startR, startC, 0);
        System.out.println(count);
    }

    static class Coord {
        int y;
        int x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x;
        }

        @Override
        public boolean equals(Object that) {
            return this.x == ((Coord) that).x && this.y == ((Coord) that).y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y * 31;
        }
    }

    static int count = 0;

    private static void visitNext(Coord[] visited, int y, int x, int depth) {
        if (depth == T) {
            count = Math.max(count, countVisit(visited));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + offY[i];
            int nextX = x + offX[i];
            if (nextX < 0 || nextY < 0 || nextY >= R || nextX >= C)
                continue;
            visited[depth] = new Coord(nextY, nextX);
            if (arr[nextY][nextX] != '#') {
                visitNext(visited, nextY, nextX, depth + 1);
            }
        }
    }

    private static int countVisit(Coord[] visited) {
        Set<Coord> mSet = new HashSet<Coord>();
        for (int i = 0; i < visited.length; i++) {
            mSet.add(visited[i]);
        }
        int c = 0;
        for (Coord coord : mSet) {
            if (arr[coord.y][coord.x] == 'S') {
                c++;
            }
        }
        // System.out.println(Arrays.toString(visited));
        // System.out.println(c + " : " + mSet);
        return c;
    }

    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, -1, 0, 1 };
}
