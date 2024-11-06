package acmicpc24463;

import java.io.*;
import java.util.*;

/* 미로
 * https://www.acmicpc.net/problem/24463
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        char[][] ch = new char[N][M];
        int[][] gate = new int[2][2];
        int gateIndex = 0;
        for (int i = 0; i < N; i++) {
            ch[i] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (ch[i][j] == '+') {
                    map[i][j] = -1;
                } else if (ch[i][j] == '.') {
                    if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                        // System.out.println("its gate");
                        gate[gateIndex][0] = j;// x
                        gate[gateIndex][1] = i;// y
                        gateIndex++;
                    }
                    ch[i][j] = '@';
                }
            }
        }
        PriorityQueue<V> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        map[gate[0][1]][gate[0][0]] = 1;
        pq.add(new V(gate[0][1], gate[0][0], 1));
        while (!pq.isEmpty()) {
            V c = pq.poll();
            if (c.y == gate[1][1] && c.x == gate[1][0]) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = c.y + offsetY[i];
                int nextX = c.x + offsetX[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (map[nextY][nextX] == 0) {
                    map[nextY][nextX] = c.d + 1;
                    pq.add(new V(nextY, nextX, c.d + 1));
                }
            }
        }

        int pathCount = map[gate[1][1]][gate[1][0]];
        int y = gate[1][1];
        int x = gate[1][0];
        ch[y][x] = '.';
        while (pathCount > 1) {
            for (int i = 0; i < 4; i++) {
                int nextY = y + offsetY[i];
                int nextX = x + offsetX[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (map[nextY][nextX] == pathCount - 1) {
                    y = nextY;
                    x = nextX;
                    pathCount--;
                    ch[y][x] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N; i++) {
        //     sb.append(Arrays.toString(map[i])).append("\n");
        // }
        // for (int i = 0; i < 2; i++) {
        //     sb.append(Arrays.toString(gate[i])).append("\n");
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ch[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[] offsetX = { 0, 1, -1, 0 };
    static int[] offsetY = { 1, 0, 0, -1 };

    static class V {
        int y, x;
        int d;

        public V(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
