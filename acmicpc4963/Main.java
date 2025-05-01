package acmicpc4963;

import java.io.*;
import java.util.*;

/* 섬의 개수
 * https://www.acmicpc.net/problem/4963
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (W != 0 && H != 0) {
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = bf.readLine().replace(" ", "").toCharArray();
            }

            int count = 0;
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    if (map[h][w] == '1') {
                        count++;
                        Queue<Coord> q = new ArrayDeque<>();
                        q.add(new Coord(h, w));
                        map[h][w] = '0';
                        while (!q.isEmpty()) {
                            Coord c = q.poll();
                            for (int i = 0; i < 8; i++) {
                                int nx = c.x + dx[i];
                                int ny = c.y + dy[i];
                                if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
                                    continue;
                                }
                                if (map[ny][nx] == '1') {
                                    map[ny][nx] = '0';
                                    q.add(new Coord(ny, nx));
                                }
                            }
                        }
                    }
                }
            }

            sb.append(count).append("\n");
            st = new StringTokenizer(bf.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
    static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

    static class Coord {
        int y;
        int x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
