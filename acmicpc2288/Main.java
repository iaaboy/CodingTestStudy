package acmicpc2288;

import java.io.*;
import java.util.*;

/* 격자의 분리자
 * https://www.acmicpc.net/problem/2288
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] map;

        boolean[][] visited;
        int[] dx = {0, 0, 1};
        int[] dy = {-1, 1, 0};
        StringBuilder sb = new StringBuilder();

        while (N != 0 && M != 0) {
            map = new char[N][];
            for (int i = 0; i < N; i++) {
                map[i] = bf.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = M - 2; j >= 0; j--) {
                    if (map[i][j] == 'S' && map[i][j+1] == 'B') {
                        map[i][j+1] = 'S';
                    }
                }
            }

            // for (int i = 0; i < N; i++) {
            //     System.out.println(Arrays.toString(map[i]));
            // }
            // System.out.println();

            visited = new boolean[N][M];
            Queue<Node> q = new LinkedList<>();
            for (int j = 0; j < M; j++) {
                if (map[0][j] == 'S') {
                    q.offer(new Node(0, j, 1));
                    visited[0][j] = true;
                }
            }

            int answer = -1;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                // System.out.println(cur);
                if (cur.x == N - 1) {
                    answer = cur.dist;
                    break;
                }
                for (int d = 0; d < 3; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] != 'S') continue;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1));
                }
            }

            sb.append(answer).append("\n");

            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x; this.y = y; this.dist = dist;
        }
        @Override
        public String toString() {
            return y + "," + x + "(" + dist + ")";
        }
    }
}
