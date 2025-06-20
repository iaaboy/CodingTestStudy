package acmicpc14499;

import java.io.*;
import java.util.*;

/* 주사위 굴리기
 * https://www.acmicpc.net/problem/14499
 * 까다로운 구현.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int x = Integer.parseInt(st.nextToken()); // x가 세로 , 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1),
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] m = new int[K];
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            m[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < K; i++) {

            // move x,y
            int nx = x + dx[m[i]];
            int ny = y + dy[m[i]];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            } 
            moveDice(m[i]);
            y = ny;
            x = nx;
            //주사위를 굴렸을 때, 이동한 칸(map)에 쓰여 있는 수가 0이면, 
            //주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
            //0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 
            //칸에 쓰여 있는 수는 0이 된다.
            if (map[x][y] == 0) {
                map[x][y] = dice[1][1];
            } else {
                dice[1][1] = map[x][y];
                map[x][y] = 0;
            }
            // for (int j = 0; j < dice.length; j++) {
            //     System.out.println(Arrays.toString(dice[j]));
            // }

            // 이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다
            // System.out.println(x + "," + y + ":  " + dice[3][1]);
            sb.append(dice[3][1]).append("\n");
        }
        System.out.print(sb);
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
    }
 
    // 1동, 2서, 3북, 4남 -> x증가
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static int[][] dice = {
            { -1, 0, -1 }, // 북
            { 0, 0, 0 }, // 서, 아래, 동.
            { -1, 0, -1 }, // 남
            { -1, 0, -1 },// 위
    };

    static int[][][] dir = {
            { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 3, 1 } }, // 서동
            { { 3, 1 }, { 1, 2 }, { 1, 1 }, { 1, 0 } }, // 동서
            { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 3, 1 } }, // 북남
            { { 3, 1 }, { 2, 1 }, { 1, 1 }, { 0, 1 } }, // 남북
    };

    private static void moveDice(int d) {
        int temp = dice[dir[d][0][0]][dir[d][0][1]];
        for (int i = 1; i < 4; i++) {
            dice[dir[d][i - 1][0]][dir[d][i - 1][1]] = dice[dir[d][i][0]][dir[d][i][1]];
        }
        dice[dir[d][3][0]][dir[d][3][1]] = temp;
    }
}
