package acmicpc1956;

import java.io.*;
import java.util.*;

/* 운동
 * https://www.acmicpc.net/problem/1956
 */

public class Main {
    static int[][] dist;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] != 0)
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        else
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] != 0) {
                answer = Math.min(answer, dist[i][i]);
            }
        }
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }
}