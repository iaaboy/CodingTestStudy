package acmicpc16234;

import java.io.*;
import java.util.*;

/* 인구 이동
 * https://www.acmicpc.net/problem/16234
 * 구현.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int movingDays = 0;
        ids = new int[N * N];
        boolean hasMoving = true;
        while (true) {
            int idNum = 0;
            hasMoving = false;
            for (int i = 0; i < N * N; i++) {
                ids[i] = idNum++;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i < N - 1) {
                        int diffUpDown = Math.abs(map[i][j] - map[i + 1][j]);
                        if (diffUpDown >= L && diffUpDown <= R) {
                            // combine ids
                            setUnion(i * N + j, (i + 1) * N + j);
                            hasMoving = true;
                        }
                    }
                    if (j < N - 1) {
                        int diffLeftRright = Math.abs(map[i][j] - map[i][j + 1]);
                        if (diffLeftRright >= L && diffLeftRright <= R) {
                            // combine ids
                            setUnion(i * N + j, i * N + j + 1);
                            hasMoving = true;
                        }
                    }
                }
            }
            if (!hasMoving) {
                break;
            }
            int[] sum = new int[N * N];
            int[] count = new int[N * N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int me = getUnion(i * N + j);
                    sum[me] += map[i][j];
                    count[me]++;
                }
            }
            for (int i = 0; i < N * N; i++) {
                if (count[i] > 0)
                    sum[i] = sum[i] / count[i];
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sum[getUnion(i * N + j)];
                }
            }
            movingDays++;
            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < N; j++) {
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        System.out.println(movingDays);
    }

    static int[] ids;

    private static int getUnion(int from) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }

        if (from != f) { // key !!! Union find 의 while loop를 줄임
            ids[from] = f;
        }

        return f;
    }

    private static void setUnion(int from, int to) {
        int f = from;
        while (ids[f] != f) {
            f = ids[f];
        }
        int t = to;
        while (ids[t] != t) {
            t = ids[t];
        }
        if (f > t) {
            ids[f] = t;
        } else {
            ids[t] = f;
        }
    }
}
