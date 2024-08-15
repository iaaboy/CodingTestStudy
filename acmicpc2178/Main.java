package acmicpc2178;

import java.io.*;
import java.util.*;

/* 미로 탐색
 * https://www.acmicpc.net/problem/2178
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        PriorityQueue<Location> pQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pQ.add(new Location(0, 0, 1, 10));
        visited[0][0] = true;
        while (!pQ.isEmpty()) {
            Location cL = pQ.poll();
            // System.out.println(cL);
            for (int i = 0; i < 4; i++) {
                int nextY = cL.y + offsetY[i];
                int nextX = cL.x + offsetX[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                    continue;
                if (Math.abs(i - cL.prev) == 2)
                    continue;
                if (nextY == N - 1 && nextX == M - 1) {
                    System.out.println(cL.distance + 1);
                    return;
                }
                if (arr[nextY][nextX] == '1') {
                    if (!visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        pQ.add(new Location(nextY, nextX, cL.distance + 1, i));
                    }
                }
            }
        }

    }

    static class Location {
        int y;
        int x;
        int distance;
        int prev;

        public Location(int y, int x, int distance, int prev) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return y + "," + x + ":" + distance;
        }
    }

    static int[] offsetY = { 0, -1, 0, 1 };
    static int[] offsetX = { -1, 0, 1, 0 };

}
