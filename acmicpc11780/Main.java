package acmicpc11780;

import java.io.*;
import java.util.*;

/* 플로이드 2
 * https://www.acmicpc.net/problem/11780
플로이드 워셜 처리과정 중간에 route를 Array로 끼워넣는다.
없는 경로의 처리에 대해 주의
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int INF = Integer.MAX_VALUE;
        int[][] cost = new int[N + 1][N + 1];
        ArrayList<Integer>[][] route = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][i] = 0;
            for (int j = 1; j <= N; j++) {
                route[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[from][to] = Math.min(cost[from][to], c);
        }

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                if (s == m)
                    continue;
                for (int e = 1; e <= N; e++) {
                    if (s == e)
                        continue;
                    if (cost[s][m] == INF || cost[m][e] == INF)
                        continue;
                    if (cost[s][e] > cost[s][m] + cost[m][e]) {
                        cost[s][e] = cost[s][m] + cost[m][e];
                        route[s][e].clear();
                        route[s][e].addAll(route[s][m]);
                        route[s][e].add(m);
                        route[s][e].addAll(route[m][e]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s = 1; s <= N; s++) {
            for (int e = 1; e <= N; e++) {
                if (cost[s][e] == INF) {
                    sb.append( "0 ");
                } else {
                    sb.append(cost[s][e] + " ");
                }
                
            }
            sb.append("\n");
        }
        for (int s = 1; s <= N; s++) {
            for (int e = 1; e <= N; e++) {
                if (s == e || cost[s][e] == INF) {
                    sb.append("0\n");
                } else {
                    sb.append(route[s][e].size() + 2).append(" ");
                    sb.append(s).append(" ");
                    for (Integer r : route[s][e]) {
                        sb.append(r).append(" ");
                    }
                    sb.append(e).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
