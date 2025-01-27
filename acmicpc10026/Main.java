package acmicpc10026;

import java.io.*;
import java.util.*;

/* 적록색약
 * https://www.acmicpc.net/problem/10026
 */

public class Main {
    static int map[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        char arr[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            char chr[] = bf.readLine().toCharArray();
            arr[i] = chr;
        }
        map = new int[n][n];

        int cnt1 = checkRGB(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        int cnt2 = checkRGB(arr);

        System.out.println(cnt1 + " " + cnt2);

    }

    private static int checkRGB(char[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(map[i], 0);
        }

        int id = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (map[i][j] == 0) {
                    // System.out.println("Union map" + i + " " + j);
                    unionMap(arr, map, new Vertex(i, j), id++);
                }
            }
        }
        // for (int i = 0; i < map.length; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }

        // System.out.println(id - 1);
        return id - 1;
    }

    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };
    static Queue<Vertex> q = new ArrayDeque<>();

    private static void unionMap(char[][] arr, int[][] map, Vertex v, int k) {
        q.clear();
        q.add(v);
        map[v.y][v.x] = k;
        while (!q.isEmpty()) {
            Vertex c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length) {
                    continue;
                }
                if (map[ny][nx] != 0) {
                    continue;
                }
                if (arr[ny][nx] != arr[c.y][c.x]) {
                    continue;
                }
                // System.out.println("add q: " + ny + " " + nx);
                map[ny][nx] = k;
                q.add(new Vertex(ny, nx));
            }
        }
    }

    static class Vertex {
        int y;
        int x;

        Vertex(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
