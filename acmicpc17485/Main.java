package acmicpc17485;

import java.io.*;
import java.util.*;

/* 진우의 달 여행 (Large)
 * https://www.acmicpc.net/problem/17485 , 17484
 * 설명) 자세한 주석, 
 * 주석 Thx to GPT
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 선언
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 행 수 N과 열 수 M을 입력받음
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행의 개수
        int M = Integer.parseInt(st.nextToken()); // 열의 개수

        // 3차원 DP 배열 선언
        // dp[i][j][k] : i행 j열에 도착했을 때의 최소 연료 소비량 (k는 이동 방향)
        // k = 0: 왼쪽 아래(↙), k = 1: 아래(↓), k = 2: 오른쪽 아래(↘)
        int[][][] dp = new int[N][M][3];

        // dp 배열을 충분히 큰 수로 초기화 (최솟값을 구하는 문제이므로)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], 1000000);
            }
        }

        // 연료 소비량 입력을 저장할 배열
        int[][] arr = new int[N][M];

        // 각 행의 연료 소비량을 입력받아 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 테이블 채우기
        for (int i = 0; i < N; i++) { // 행을 따라 내려가면서
            for (int j = 0; j < M; j++) { // 열마다 처리
                if (i == 0) {
                    // 첫 번째 행은 시작 위치이므로, 어떤 방향으로 왔든지 값은 arr[0][j] 그대로
                    dp[i][j][0] = arr[i][j];
                    dp[i][j][1] = arr[i][j];
                    dp[i][j][2] = arr[i][j];
                    continue; // 다음 열로 넘어감
                }

                if (j == 0) {
                    // 왼쪽 끝 열인 경우 → 왼쪽 아래(↙)로 오는 건 불가능
                    // ↓ 방향으로 오는 경우: 이전 위치는 같은 열, 이전 방향은 ↙ 또는 ↘
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + arr[i][j], dp[i - 1][j][2] + arr[i][j]);

                    // ↘ 방향으로 오는 경우: 오른쪽에서 오므로 j+1 열에서 ↙, ↓ 방향만 가능
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0] + arr[i][j], dp[i - 1][j + 1][1] + arr[i][j]);
                } else if (j == M - 1) {
                    // 오른쪽 끝 열인 경우 → 오른쪽 아래(↘)로 오는 건 불가능
                    // ↙ 방향으로 오는 경우: j-1 열에서 ↓ 또는 ↘ 방향만 가능
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + arr[i][j], dp[i - 1][j - 1][2] + arr[i][j]);

                    // ↓ 방향으로 오는 경우: j 열에서 ↙ 또는 ↘ 방향만 가능
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + arr[i][j], dp[i - 1][j][2] + arr[i][j]);
                } else {
                    // 일반적인 중간 열

                    // ↙ 방향으로 오는 경우: j-1 열에서 ↓ 또는 ↘ 방향에서만 가능 (같은 방향 연속 금지)
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + arr[i][j],
                            dp[i - 1][j - 1][2] + arr[i][j]);

                    // ↓ 방향으로 오는 경우: j 열에서 ↙ 또는 ↘ 방향만 가능
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + arr[i][j],
                            dp[i - 1][j][2] + arr[i][j]);

                    // ↘ 방향으로 오는 경우: j+1 열에서 ↙ 또는 ↓ 방향만 가능
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0] + arr[i][j],
                            dp[i - 1][j + 1][1] + arr[i][j]);
                }
            }
        }

        // 디버깅용: DP 테이블 전체 출력 (현재는 주석 처리됨)
        // for (int j = 0; j < N; j++) {
        // for (int j2 = 0; j2 < M; j2++) {
        // for (int i = 0; i < 3; i++) {
        // System.out.printf("%2d ", dp[j][j2][i]);
        // }
        // System.out.print(" / ");
        // }
        // System.out.println();
        // }

        // 마지막 행에서 가장 적은 연료를 소모한 값을 찾아 출력
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                result = Math.min(result, dp[N - 1][j][k]);
            }
        }

        // 정답 출력
        System.out.println(result);
    }
}
