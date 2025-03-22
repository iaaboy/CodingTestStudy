package acmicpc14442;

import java.io.*;
import java.util.*;

/* 벽 부수고 이동하기 2
 * https://www.acmicpc.net/problem/14442
dp형식으로 
방문한 노드의 최소값을 visit array에 저장하고, 해당 좌표에서 최소값이 갱신될때 이후 좌표를 다시 방문하도록 Queue에 넣어준다.
이 때 visit array의 3차원 행렬을 만들어 벽이 0개 ~ 10개깨진것의 visit array로 방문 기록을 남기면서 진행.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = bf.readLine().toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                arr[i][j] = cArr[j] - '0';
            }
        }
        int[][][] visit = new int[K + 1][N][M];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<Vertex> q = new ArrayDeque<>();
        visit[0][0][0] = 1;
        q.add(new Vertex(0, 0, 0, 1));

        int[] dx = { 0, 1, -1, 0 };
        int[] dy = { 1, 0, 0, -1 };
        int curMin = Integer.MAX_VALUE;
        if (N == 1 && M == 1) {
            curMin = 1;
        }
        while (!q.isEmpty()) {
            Vertex c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                if (c.dist + 1 > curMin) {
                    continue;
                }
                if (arr[ny][nx] == 0) {
                    // 그대로 진행.
                    if (visit[c.brCount][ny][nx] > c.dist + 1) {
                        visit[c.brCount][ny][nx] = c.dist + 1;
                        if (ny == N - 1 && nx == M - 1) {
                            curMin = Math.min(curMin, c.dist + 1);
                        }
                        q.add(new Vertex(ny, nx, c.brCount, c.dist + 1));
                    }
                } else if (c.brCount < K && arr[ny][nx] == 1) {
                    if (visit[c.brCount + 1][ny][nx] > c.dist + 1) {
                        visit[c.brCount + 1][ny][nx] = c.dist + 1;
                        if (ny == N - 1 && nx == M - 1) {
                            curMin = Math.min(curMin, c.dist + 1);
                        }
                        q.add(new Vertex(ny, nx, c.brCount + 1, c.dist + 1));
                    }
                }
            }
        }

        // StringBuilder debugSb = new StringBuilder();
        // for (int i = 0; i <= K; i++) {
        // for (int j = 0; j < N; j++) {
        // for (int j2 = 0; j2 < M; j2++) {
        // if (visit[i][j][j2] == Integer.MAX_VALUE) {
        // debugSb.append("-").append(" ");
        // }
        // debugSb.append(visit[i][j][j2]).append(" ");
        // }
        // debugSb.append("\n");
        // }
        // }
        // System.out.println(debugSb);

        // int minDist = Integer.MAX_VALUE;
        // for (int i = 0; i <= K; i++) {
        // minDist = Math.min(visit[i][N-1][M-1], minDist);
        // }
        // if (minDist == Integer.MAX_VALUE) {
        // minDist = -1;
        // }
        // System.out.println(minDist);

        if (curMin == Integer.MAX_VALUE) {
            curMin = -1;
        }
        System.out.println(curMin);
    }

    static class Vertex {
        int y, x;
        int brCount;
        int dist;

        public Vertex(int y, int x, int brCount, int dist) {
            this.y = y;
            this.x = x;
            this.brCount = brCount;
            this.dist = dist;
        }
    }
}
