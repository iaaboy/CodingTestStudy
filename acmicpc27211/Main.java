package acmicpc27211;

import java.io.*;
import java.util.*;

/* 도넛 행성
 * https://www.acmicpc.net/problem/27211
 */

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int id = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    navigate(arr, id++, i, j);
                }
            }
        }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        System.out.println(id - 2);
    }

    static int[] offX = { 1, 0, -1, 0 };
    static int[] offY = { 0, -1, 0, 1 };

    static void navigate(int[][] arr, int id, int y, int x) {
        // System.out.println("navigate: " + id + "-" + y + "," + x);
        Queue <Coor> mQ = new LinkedList<>();
        arr[y][x] = id;
        mQ.add(new Coor(y, x));

        while (!mQ.isEmpty()) {
            Coor cur = mQ.poll();
            for (int i = 0; i < 4; i++) {
                int nX = cur.x + offX[i];
                int nY = cur.y + offY[i];
                if (nX < 0) {
                    nX = M - 1;
                } else if (nX == M) {
                    nX = 0;
                }
                if (nY < 0) {
                    nY = N - 1;
                } else if (nY == N) {
                    nY = 0;
                }
                if (arr[nY][nX] == 0) {
                    arr[nY][nX] = id;
                    mQ.add(new Coor(nY, nX));
                }
            }
        }
    }
    static class Coor {
        int y;
        int x;
        public Coor(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}