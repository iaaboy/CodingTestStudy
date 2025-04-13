package acmicpc14500;

import java.io.*;
import java.util.*;

/* 테트로미노
 * https://www.acmicpc.net/problem/14500
각 파트는 array로 표현하고, 
모든 좌표에 대해 파트와 mapping하여 최대값 구함.
 */

public class Main {
    static int[][][] parts = {
        // 일자
        { { 1, 1, 1, 1 } },
        { { 1 },
          { 1 },
          { 1 },
          { 1 } },
        // 네모
        { { 1, 1 },
          { 1, 1 } },
        // 니은
        { { 1, 0 },
          { 1, 0 },
          { 1, 1 } },
        { { 1, 1 },
          { 0, 1 },
          { 0, 1 } },
        { { 0, 1 },
          { 0, 1 },
          { 1, 1 } },
        { { 1, 1 },
          { 1, 0 },
          { 1, 0 } },
        { {1,1,1},
          {1,0,0} },
        { {0,0,1},
          {1,1,1} },
        { {1,0,0},
          {1,1,1} },
        { {1,1,1},
          {0,0,1} },
        //    |---
        // ---|
        { { 0, 1, 1 },
          { 1, 1, 0 } },
        { {0,1},
          {1,1},
          {1,0}},
        { { 1, 1, 0 },
          { 0, 1, 1 } },
        { {1,0},
          {1,1},
          {0,1}},
        // ---|---
        //    |
        { { 1, 1, 1 },
          { 0, 1, 0 } },
        { {1,0},
          {1,1},
          {1,0}},
        { { 0, 1, 0 },
          { 1, 1, 1 } },
        { {0,1},
          {1,1},
          {0,1}},
    };
    static int [][] num;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, getMax(i, j));
            }
        }
        System.out.println(max);
    }
    private static int getMax(int y, int x) {
        int max = 0;
        for (int[][] part : parts) {
            int m = part[0].length;
            int n = part.length;
            if (y + n > N || x + m > M) {
                continue;
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (part[i][j] == 1) {
                        sum += num[y+i][x+j];
                    }
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}

/*
4 5
1 1 1 1 1
1 1 1 1 1
1 1 1 1 5
1 1 5 5 5
 */