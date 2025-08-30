package acmicpc2492;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int N = n + 2;
        int m = Integer.parseInt(st.nextToken());
        int M = m + 2;
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) + 1;
            int y = Integer.parseInt(st.nextToken()) + 1;
            map[y][x]++;
        }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < M; i++) {
        //     sb.append(Arrays.toString(map[i])).append("\n");
        // }

        for (int i = 1; i < M; i++) {
            int sum = 0;
            for (int j = 1; j < N; j++) {
                sum += map[i][j];
                map[i][j] = sum + map[i - 1][j];
            }
        }

        int maxCount = 0;
        for (int y = 0; y <= m - K; y++) {
            for (int x = 0; x <= n - K; x++) {
                int count = getCount(y, x, y + K, x + K);
                // System.out.println(y + "," + x + ":" + count);
                maxCount = Math.max(count, maxCount);
            }
        }
        System.out.println(maxCount);

        // sb.append("\n");
        // for (int i = 0; i < M; i++) {
        //     sb.append(Arrays.toString(map[i])).append("\n");
        // }
        // System.out.print(sb);
    }

    static int getCount (int y1, int x1, int y2, int x2) {
        y2++;x2++;
        int sumI = map[y2][x2] - map[y2][x1] - map[y1][x2] + map[y1][x1];
        return sumI;
    }
}
/*
10 6 7 3
0 0
3 4
7 6
4 5
4 3
5 3
6 4
 */