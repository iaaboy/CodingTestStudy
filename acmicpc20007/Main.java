package acmicpc20007;

import java.io.*;
import java.util.*;

/* 떡 돌리기
 * https://www.acmicpc.net/problem/20007
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[][] cost = new int[N][N];
        Integer[] index = new Integer[N];
        final int INF = 10000001;
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], INF);
            index[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[f][t] = c;
            cost[t][f] = c;
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    cost[s][e] = Math.min(cost[s][e], cost[s][m] + cost[m][e]);
                }
            }
        }
        Arrays.sort(index, (a, b) -> cost[Y][a] - cost[Y][b]);

        int count = 0;
        int x = 0;
        for (int i = 0; i < index.length; i++) {
            if (Y == index[i]) {
                continue;
            }
            if (cost[Y][index[i]] * 2 > X) {
                System.out.println(-1);
                return;
            }
            if (cost[Y][index[i]] * 2 > x) {
                count++;
                x = X;
                x -= cost[Y][index[i]] * 2;
            } else {
                x -= cost[Y][index[i]] * 2;
            }
        }
        System.out.println(count);
    }
}
