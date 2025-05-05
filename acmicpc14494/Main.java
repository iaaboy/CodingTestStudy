package acmicpc14494;

import java.io.*;
import java.util.*;

/* 다이나믹이 뭐예요?
 * https://www.acmicpc.net/problem/14494
 * dp
 * 점화식 
 * D[i][j] += ((D[i - 1][j] + D[i][j - 1]) % 1000000007 + D[i - 1][j - 1]) % 1000000007;
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][M + 1];
        D[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                D[i][j] += ((D[i - 1][j] + D[i][j - 1]) % 1000000007 + D[i - 1][j - 1]) % 1000000007;
            }
        }
        System.out.println(D[N][M]);
    }
}
