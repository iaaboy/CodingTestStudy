package acmicpc3987;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/* 보이저 1호
 * https://www.acmicpc.net/problem/3987
 */

public class Main {
    static char[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // String fN = "10b";
        // String in = "in.";
        // String inputName = "!!!directory" + in + fN;
        // BufferedReader bf = new BufferedReader(new FileReader(inputName,
        // Charset.forName("UTF-8")));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        st = new StringTokenizer(bf.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        if (map[y][x] == 'C') {
            System.out.println("U\n0");
            return;
        }

        int distMax = 0;
        String direction = "";
        for (int i = 0; i < 4; i++) {
            int dist = traverse(y, x, i);
            // System.out.println("result:" + y + "," + x + ".." + dName[i] + ":" + dist +
            // "\n");
            if (dist == -1) {
                System.out.println(dName[i] + "\nVoyager");
                distMax = -1;
                break;
            } else {
                if (distMax < dist) {
                    distMax = dist;
                    direction = dName[i];
                }
            }
        }
        if (distMax != -1) {
            System.out.println(direction + "\n" + distMax);
        }

        // String out = "out.";
        // String outputName = "directory" + out + fN;
        // BufferedReader answer = new BufferedReader(new FileReader(outputName,
        // Charset.forName("UTF-8")));
        // System.out.println(answer.readLine());
        // System.out.println(answer.readLine());
        // answer.close();
    }

    private static int traverse(int y, int x, int dir) {
        int dist = 1;
        Queue<Coord> q = new ArrayDeque<>();
        q.add(new Coord(y, x, dir, dist));
        while (!q.isEmpty()) {
            Coord c = q.poll();
            // System.out.println(c);
            {
                int nextDir = c.dir;
                int nextY = c.y + yOffset[nextDir];
                int nextX = c.x + xOffset[nextDir];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    return c.distance;
                }

                if (nextY == y && nextX == x && dir == nextDir) {
                    return -1;
                }

                if (map[nextY][nextX] == '.') {
                } else if (map[nextY][nextX] == '/') {
                    nextDir = slash[c.dir];
                } else if (map[nextY][nextX] == '\\') {
                    nextDir = backSlash[c.dir];
                } else if (map[nextY][nextX] == 'C') {
                    return c.distance;
                }
                q.add(new Coord(nextY, nextX, nextDir, c.distance + 1));
            }
        }

        return dist;
    }

    static int[] slash = { 1, 0, 3, 2 };
    static int[] backSlash = { 3, 2, 1, 0 };

    static String[] dName = { "U", "R", "D", "L" };
    static int[] xOffset = { 0, 1, 0, -1 };
    static int[] yOffset = { -1, 0, 1, 0 };

    static class Coord {
        int y, x;
        int distance;
        int dir;

        public Coord(int y, int x, int dir, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return y + "," + x + " " + dName[dir] + " " + distance;
        }
    }
}
