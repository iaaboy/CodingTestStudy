package acmicpc17182;

import java.io.*;
import java.util.*;

/* 우주 탐사선
 * https://www.acmicpc.net/problem/17182
 */

public class Main {
    static int[][] map;
    static int[][] distMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        distMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                distMap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) {
                    distMap[i][j] = 10000000;
                }
            }
        }

        //플로이드 워셜, 지점간 최소 비용을 먼저 구함
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distMap[i][j] = Math.min(distMap[i][j], distMap[i][k] + distMap[k][j]);
                }
            }
        }

        // for (int i = 0; i < distMap.length; i++) {
        //     System.out.println(Arrays.toString(distMap[i]));
        // }

        int[] visit = new int[N]; // visit은 디버깅을 위해 int로 처리
        visit[K] = 1;
        //완탐.
        visit(visit, K, 0, 1);
        System.out.println(minDist);
    }

    static int minDist = Integer.MAX_VALUE;

    private static void visit(int[] visit, int current, int dist, int depth) {
        if(dist > minDist) { // 현재까지 최소비용보다 낮으면 리턴
            return;
        }
        if (depth == visit.length) {
            // System.out.println(dist + ": " + Arrays.toString(visit));
            minDist = Math.min(minDist, dist);
        }
        for (int j = 0; j < visit.length; j++) {
            if (visit[j] == 0) {
                visit[j] = depth + 1;
                visit(visit, j, dist + distMap[current][j], depth + 1);
                visit[j] = 0;
            }
        }
    }
}
