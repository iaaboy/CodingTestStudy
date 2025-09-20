package acmicpc5638;

import java.io.*;
import java.util.*;

/* 수문
 * https://www.acmicpc.net/problem/5638
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] water = new int[N];
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            water[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        int[] totalWater = new int[M];
        int[] time = new int[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            totalWater[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        int loopCount = (int) Math.pow(2, N);
        int[] minCost = new int[M];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int i = 0; i < loopCount; i++) {
            int[] flownWater = new int[M];
            int totalCost = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    for (int k = 0; k < M; k++) {
                            flownWater[k] += time[k] * water[j];
                    }
                    totalCost += cost[j];
                }
            }
            for (int j = 0; j < M; j++) {
                if (totalWater[j] <= flownWater[j]) {
                    minCost[j] = Math.min(minCost[j], totalCost);
                }
            }
            // System.out.println(Integer.toBinaryString(i) + " " + Arrays.toString(flownWater) + " , " + totalCost);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minCost.length; i++) {
            sb.append("Case " + (i + 1) + ": " + (minCost[i] == Integer.MAX_VALUE ? "IMPOSSIBLE" : Integer.toString(minCost[i]))).append("\n");
        }
        System.out.print(sb);
    }
}

/*
4
50000 60000
720000 120000
130000 50000
1200000 150000
3
5000000 7
5000000 30
63000000 24
 */