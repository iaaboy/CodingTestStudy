package acmicpc10159;

import java.util.*;
import java.io.*;

/* 저울
 * https://www.acmicpc.net/problem/10159
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int UNReach = Integer.MAX_VALUE;

        int[][] route = new int[N + 1][N + 1];
        boolean[][] routable = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(route[i], UNReach);
            route[i][i] = 1;
            routable[i][i] = true;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            route[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (s == e) {
                        continue;
                    }
                    if (route[s][m] != UNReach && route[m][e] != UNReach) {
                        route[s][e] = 1;
                        routable[s][e] = true;
                        routable[e][s] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            // System.out.println("s:" + i + " " + Arrays.toString(route[i]));
            int rCount = N;
            for (int j = 1; j <= N; j++) {
                if (routable[i][j]) {
                    rCount--;
                }
            }
            // System.out.println(rCount +": " + Arrays.toString(routable[i]));
            System.out.println(rCount);
        }
    }
}
