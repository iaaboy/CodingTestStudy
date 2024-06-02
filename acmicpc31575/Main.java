package acmicpc31575;

import java.io.*;
import java.util.*;

/* 도시와 비트코인
 * https://www.acmicpc.net/problem/31575
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] road = new boolean[M][N];

        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(bf.readLine());
            for (int x = 0; x < N; x++) {
                boolean up = y == 0 ? false : road[y - 1][x];
                boolean left = x == 0 ? false : road[y][x - 1];
                boolean me = Integer.parseInt(st.nextToken()) == 1;
                if (x == 0 && y == 0) {
                    road[0][0] = true;
                    continue;
                }
                road[y][x] = (up || left) && me;
            }
        }
        // for (int i = 0; i < road.length; i++) {
        //     System.out.println(Arrays.toString(road[i]));
        // }

        if (road[M - 1][N - 1]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
