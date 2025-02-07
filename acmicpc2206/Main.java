package acmicpc2206;

import java.io.*;
import java.util.*;

/* 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 */

public class Main {
    static int INF = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] wall = new boolean[N][M];
        int[][][] dist = new int[2][N][M]; // 1. wall broken, 0, keep

        for (int i = 0; i < N; i++) {
            char[] m = bf.readLine().toCharArray();
            for (int j = 0; j < m.length; j++) {
                wall[i][j] = m[j] == '1';
                for (int k = 0; k < 2; k++) {
                    dist[k][i][j] = INF;
                }
            }
        }

        Queue<Coord> q = new ArrayDeque<>();
        q.add(new Coord(0, 0 , false));
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            Coord c = q.poll();
            if (c.breakWall) {
                // 이미 깨진 경우
                for (int i = 0; i < 4; i++) {
                    int nY = c.y + offY[i];
                    int nX = c.x + offX[i];
                    if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                        continue;
                    }
                    if (wall[nY][nX]) {
                        continue;
                    } else  if (dist[1][nY][nX] == INF || dist[1][nY][nX] > dist[1][c.y][c.x] + 1) {
                        dist[1][nY][nX] = dist[1][c.y][c.x] + 1;
                        q.add(new Coord(nY, nX, true));
                    }
                }
                
            } else {
                for (int i = 0; i < 4; i++) {
                    int nY = c.y + offY[i];
                    int nX = c.x + offX[i];
                    if (nX < 0 || nY < 0 || nX >= M || nY >= N) {
                        continue;
                    }
                    if (wall[nY][nX] && !c.breakWall) {
                        // Todo 벽을 깬 경우
                        if (dist[1][nY][nX] == INF || dist[1][nY][nX] > dist[1][c.y][c.x] + 1) {
                            dist[1][nY][nX] = dist[0][c.y][c.x] + 1;
                            q.add(new Coord(nY, nX, true));
                        }
                        continue;
                    } else  if (dist[0][nY][nX] == INF || dist[0][nY][nX] > dist[0][c.y][c.x] + 1) {
                        dist[0][nY][nX] = dist[0][c.y][c.x] + 1;
                        q.add(new Coord(nY, nX, false));
                    }
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dist[0][i]));
        // }
        // System.out.println("====");
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dist[1][i]));
        // }

        int result = -1;
        if (dist[0][N - 1][M - 1] == -1 && dist[1][N - 1][M - 1] == -1 ) {
            
        } else if (dist[0][N - 1][M - 1] == -1 || dist[1][N - 1][M - 1] == -1 ){
            result = Math.max(dist[0][N - 1][M - 1] , dist[1][N - 1][M - 1]);
        } else {
            result = Math.min(dist[0][N - 1][M - 1] , dist[1][N - 1][M - 1]);
        }
        System.out.println(result);
    }

    static int[] offX = { 0, 1, 0, -1 };
    static int[] offY = { -1, 0, 1, 0 };

    static class Coord {
        int y, x;
        boolean breakWall;

        public Coord(int y, int x , boolean bw) {
            this.y = y;
            this.x = x;
            this.breakWall = bw;
        }
    }
}

/*
 * 
6 4
0010
1000
1100
0000
0111
0000
 */