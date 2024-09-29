package acmicpc6146;

import java.io.*;
import java.util.*;

/* 신아를 만나러
 * https://www.acmicpc.net/problem/6146
 */

public class Main {
    static int CENTER = 500;
    static int MAX = CENTER * 2 + 1;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken()) + CENTER;
        y = Integer.parseInt(st.nextToken()) + CENTER;
        int N = Integer.parseInt(st.nextToken());
        char[][] arr = new char[MAX][MAX];

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = '.';
                if (i == CENTER && j == CENTER) {
                    arr[i][j] = 'C';
                }
            }
        }

        // M : 물 웅덩이 , B: 목적지
        arr[y][x] = 'B';
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int xx = Integer.parseInt(st.nextToken()) + CENTER;
            int yy = Integer.parseInt(st.nextToken()) + CENTER;
            arr[yy][xx] = 'M';
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> {
            // if (a.cost == b.cost) {
            //     int adist = Math.abs(a.x - x) + Math.abs(a.y - y);
            //     int bdist = Math.abs(b.x - x) + Math.abs(b.y - y);
            //     return adist - bdist;
            // }
            return a.cost - b.cost;
        });
        pq.add(new Vertex(CENTER, CENTER, 0));

        // printAll(arr);

        int handledCount = 0;
        while (!pq.isEmpty()) {
            // printAll(arr);
            Vertex cur = pq.poll();
            handledCount++;
            // System.out.println("handled: " + cur.cost);
            for (int i = 0; i < 4; i++) {
                int nextY = cur.y + yOffset[i];
                int nextX = cur.x + xOffset[i];

                if (nextX < 0 || nextY < 0 || nextX >= MAX || nextY >= MAX) {
                    continue;
                }
                if (arr[nextY][nextX] == 'B') {
                    // System.out.println("handledCount: " + handledCount);
                    System.out.println(cur.cost + 1);
                    printAll(arr);
                    return;
                }
                if (arr[nextY][nextX] == '.') {
                    arr[nextY][nextX] = 'V'; // visited
                    pq.add(new Vertex(nextY, nextX, cur.cost + 1));
                }
            }
        }

        printAll(arr);
    }

    private static void printAll(char[][] arr) {
        // for (int i = MAX - 1; i >= 0; i--) {
        // for (int j = 0; j < MAX; j++) {
        // System.out.print(arr[i][j]);
        // }
        // System.out.println();
        // }
    }

    static int[] xOffset = { 1, -1, 0, 0 };
    static int[] yOffset = { 0, 0, 1, -1 };

    static class Vertex {
        int y;
        int x;
        int cost;

        public Vertex(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
