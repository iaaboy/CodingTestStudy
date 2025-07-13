package acmicpc20056;

import java.io.*;
import java.util.*;

/* 마법사 상어와 파이어볼
 * https://www.acmicpc.net/problem/20056
 * 구현
 */

public class Main {
    static HashMap<Integer, FireBall> balls = new HashMap<>();
    static ArrayList<Integer> aLiveBalls = new ArrayList<>();
    static BallPool[][] map;
    static int N;
    static int ballIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new BallPool[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new BallPool();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            FireBall newBall = new FireBall(r, c, m, s, d);
            map[r][c].balls.add(i);
            aLiveBalls.add(ballIndex);
            balls.put(ballIndex++, newBall);
        }

        printMap("Initial");

        for (int i = 0; i < K; i++) {
            // K시간에 한번씩 이동
            for (Integer b : aLiveBalls) {
                moveBall(b);
            }

            // 2개 이상의 파이어볼이 있는 칸
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c].balls.size() >= 2) {
                        handleMultiFireBall(r, c);
                    }
                }
            }
            printMap(Integer.toString(i));
        }
        long totalM = 0;
        for (Integer b : aLiveBalls) {
            totalM += balls.get(b).m;
        }
        System.out.println(totalM);
    }

    private static void printMap(String msg) {
        // System.out.println(msg);
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         if (map[i][j].balls.size() == 1) {
        //             System.out.print(map[i][j].balls.get(0) + 1 + " ");
        //         } else {
        //             System.out.print(map[i][j].balls.size() + " ");
        //         }

        //     }
        //     System.out.println();
        // }
    }

    static int[][] dd = {
            { 0, 2, 4, 6 },
            { 1, 3, 5, 7 }
    };

    private static void handleMultiFireBall(int r, int c) {
        int m = 0;
        int s = 0;
        boolean odd = true;
        boolean even = true;
        // System.out.println("handleMultiFireBall: " + r + "," + c);
        for (Integer b : map[r][c].balls) {
            FireBall cB = balls.get(b);
            m += cB.m;
            s += cB.s;
            if (cB.d % 2 == 0) {
                odd = false;
            } else {
                even = false;
            }
            aLiveBalls.remove(b);
        }
        m /= 5;
        s /= map[r][c].balls.size();
        int nd = (odd || even) ? 0 : 1;
        map[r][c].balls.clear();
        if (m > 0) {
            // 4개추가
            for (int i = 0; i < 4; i++) {
                FireBall newBall = new FireBall(r, c, m, s, dd[nd][i]);
                aLiveBalls.add(ballIndex);
                map[r][c].balls.add(ballIndex);
                balls.put(ballIndex++, newBall);
            }
        }
    }

    // static int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 };
    // static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    private static void moveBall(int b) {
        FireBall ball = balls.get(b);
        int nr = (ball.r + dr[ball.d] * ball.s) % N;
        if (nr < 0) {
            nr += N;
        }
        int nc = (ball.c + dc[ball.d] * ball.s) % N;
        if (nc < 0) {
            nc += N;
        }
        // System.out.println("Move ball : " + ball.r + "," + ball.c + " -> " + nr + "," + nc);
        map[ball.r][ball.c].balls.remove((Integer) b);
        map[nr][nc].balls.add(b);
        ball.r = nr;
        ball.c = nc;
    }

    static class BallPool {
        ArrayList<Integer> balls = new ArrayList<>();
    }

    static class FireBall {
        // 질량은 mi이고, 방향은 di, 속력은 si이다
        int r, c;
        int m;
        int s;
        int d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
