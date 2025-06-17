package acmicpc14503;

import java.io.*;
import java.util.*;

/* 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 * 단순구현이지만 문제에 대해 정확히 이해 필요.
 * 1. 빈칸이 있는 경우 현재 방향을 기준으로 먼저 반시계 90도 회전한다
 * 2. 입력 주의 : 1이면 동, 3이면 서
 * 3. 주위에 빈칸이 없는 경우 방향 그대로 후진하고, 다시 빈칸이 있는지 찾는것부터 시작.
 */ 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        if (dir == 1) {
            dir = 3;
        } else if (dir == 3) {
            dir = 1;
        }
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean hasNextOperation = true;
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, -1, 0, 1 };
        int count = 2;
        loop: while (hasNextOperation) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[y][x] == 0) {
                map[y][x] = count++;
                continue;
            }
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            // -1. 반시계 방향으로 90도 회전한다.
            // -2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            // -3. 1번으로 돌아간다.
            for (int i = 1; i <= 4; i++) {
                int ny = y + dy[(i + dir) % 4];
                int nx = x + dx[(i + dir) % 4];
                if (map[ny][nx] == 0) {
                    // set x, y, dir
                    y = ny;
                    x = nx;
                    dir = (i + dir) % 4;
                    continue loop;
                }
            }
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            // -1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            // -2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            int prevY = y + dy[(dir + 2) % 4];
            int prevX = x + dx[(dir + 2) % 4];
            if (map[prevY][prevX] == 1) {
                break;
            } else {
                y = prevY;
                x = prevX;
            }
        }
        System.out.println(count - 2);

        // for (int i = 0; i < R; i++) {
        //     System.out.print(i + " ");
        //     for (int j = 0; j < C; j++) {
        //         System.out.printf("%3d", map[i][j]);
        //     }
        //     System.out.println();
        // }

    }
}
