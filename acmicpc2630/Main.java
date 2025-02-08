package acmicpc2630;

import java.io.*;
import java.util.*;

/* 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 */

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Count c = getCount(0, 0, N);
        System.out.println(c.zeroCnt + "\n" + c.oneCnt);
    }

    private static Count getCount(int i, int j, int n) {
        if (n == 1) {
            return arr[i][j] == 0 ? new Count(1, 0) : new Count(0, 1);
        }
        int zeroCnt = 0;
        int oneCnt = 0;
        int[] dx = { 0, 0, n / 2, n / 2 };
        int[] dy = { 0, n / 2, 0, n / 2 };

        for (int k = 0; k < 4; k++) {
            Count c = getCount(i + dx[k], j + dy[k], n / 2);
            zeroCnt += c.zeroCnt;
            oneCnt += c.oneCnt;
        }

        if (zeroCnt == 0) {
            return new Count(0, 1);
        } else if (oneCnt == 0) {
            return new Count(1, 0);
        }
        return new Count(zeroCnt, oneCnt);
    }

    static class Count {
        int zeroCnt;
        int oneCnt;

        public Count(int zeroCnt, int oneCnt) {
            this.zeroCnt = zeroCnt;
            this.oneCnt = oneCnt;
        }
    }
}
