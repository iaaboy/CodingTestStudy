package acmicpc11048;

import java.io.*;
import java.util.*;

/* 이동하기
 * https://www.acmicpc.net/problem/11048
 * 점화식
 * D[i][j] += Math.max(D[i - 1][j], Math.max(D[i][j - 1], D[i - 1][j - 1]));
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= M; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
                D[i][j] += Math.max(D[i - 1][j], Math.max(D[i][j - 1], D[i - 1][j - 1]));
            }
        }
        System.out.println(D[N][M]);
    }
}
