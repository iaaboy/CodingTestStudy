package acmicpc14585;

import java.io.*;
import java.util.*;

/* 사수빈탕
 * https://www.acmicpc.net/problem/14585
 * 간단한 dp
 * 0에서 출발해서 한칸씩 이동하며 최대값을 저장. 
 * 지금 위치에서 위쪽, 왼쪽중 최소값을 취하고, 지금 위치에 사탕이 있으면 사탕을 더한다.
 */

public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[301][301];
        int maxN = 0;
        for (int me = 1; me <= N; me++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maxN = Math.max(maxN, Math.max(x, y));
            map[y][x] = true;
        }
        int[][] dp = new int[301][301];
        for (int y = 0; y <= maxN; y++) {
            for (int x = 0; x <= maxN; x++) {
                int preY = y == 0 ? 0 : dp[y - 1][x];
                int preX = x == 0 ? 0 : dp[y][x - 1];
                dp[y][x] = Math.max(preY, preX);
                if (map[y][x] && M - y - x > 0) {
                    dp[y][x] += (M - y - x);
                }
            }
        }
        System.out.println(dp[maxN][maxN]);
    }
}