package acmicpc21938;

import java.io.*;
import java.util.*;

/* 영상처리
 * https://www.acmicpc.net/problem/21938
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] image = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    image[i][j] += Integer.parseInt(st.nextToken());
                }
                image[i][j] /= 3;
            }

        }
        int bound = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (image[i][j] >= bound) {
                    image[i][j] = 255;
                } else {
                    image[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (image[i][j] >= bound) {
                    image[i][j] = 255;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        int[] dx = { 0, 1, -1, 0 };
        int[] dy = { 1, 0, 0, -1 };
        int count = 10000000;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (image[y][x] == 255) {
                    count++;
                    image[y][x] = count;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[] { y, x });
                    while (!q.isEmpty()) {
                        int[] c = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int ny = c[0] + dy[d];
                            int nx = c[1] + dx[d];
                            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                                continue;
                            }
                            if (image[ny][nx] == 255) {
                                image[ny][nx] = count;
                                q.add(new int[] { ny, nx });
                            }
                        }
                    }
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(image[i]));
        // }

        System.out.println(count - 10000000);
    }
}
