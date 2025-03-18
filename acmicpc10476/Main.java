package acmicpc10476;

import java.io.*;
import java.util.*;

/* 좁은 미술전시관
 * https://www.acmicpc.net/problem/10476
각 줄 별로 좌/우/선택안함
모든 경우를 방문하는데, 중복 방문을 dp값 저장하여 처리.
 */

public class Main {
    static int K, N;
    static int[][][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        dp = new int[N + 1][K + 1][3]; // line , 남은 door, 0 - left / 1 - right / 2 - 둘다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        bf.readLine();

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0, K, 2));
    }

    // 왼쪽 닫힘 0, 오른쪽 닫힘 1, 둘다 열림 2
    static int solve(int line, int remained, int prevState) {
        if (remained == 0) {
            int total = 0;
            //이후 남은 값을 모두 더함.
            for (int i = line; i < N; i++)
                for (int j = 0; j < 2; j++)
                    total += arr[i][j];
            dp[line][remained][prevState] = total;
            return dp[line][remained][prevState];
        }

        if (line == N) //!!! 이전에 2를 모두 사용.
            return Integer.MIN_VALUE;

        if (dp[line][remained][prevState] != -1)
            return dp[line][remained][prevState];

        int result = Integer.MIN_VALUE;

        if (prevState == 0 || prevState == 2) {
            result = Math.max(result, solve(line + 1, remained - 1, 0) + arr[line][1]);
        }
        if (prevState == 1 || prevState == 2) {
            result = Math.max(result, solve(line + 1, remained - 1, 1) + arr[line][0]);
        }

        dp[line][remained][prevState] = Math.max(result, solve(line + 1, remained, 2) + arr[line][0] + arr[line][1]);

        return dp[line][remained][prevState];
    }
}
