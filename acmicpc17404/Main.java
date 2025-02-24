package acmicpc17404;

import java.io.*;
import java.util.*;

/* RGB거리 2
 * https://www.acmicpc.net/problem/17404
 */

 /*
풀이)
이전 선택 조건에 다음 선택이 영향 받음. (DP)
1. 첫번째 집을 R/G/B 로 각각 선택했을때를 각각의 케이스로 나눠 
2. 2번째 선택을 먼저 정의하고, 이후에는 
    dp R(N) = dp G(N-1) / dp B(N-1) 중 최소값 + 현재 집을 R로 칠하는데 드는 비용
    .. 같은 방식으로 G, B 수행
3. 결과 dp중 첫번째 선택한 집을 제외하고, 나머지 중 최소값을 저장
4. 1-3 을 R/G/B의 각 경우에 대해 반복, 최종 결과 출력
  */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        for (int base = 0; base < 3; base++) {
            int[][] dp = new int[N][3];

            for (int i = 0; i < 3; i++) {
                if (i == base) {
                    dp[1][i] = Integer.MAX_VALUE;
                    continue;
                }
                dp[1][i] = arr[0][base] + arr[1][i];
            }

            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }
            for (int i = 0; i < 3; i++) {
                if (i == base) {
                    continue;
                }
                min = Math.min(dp[N - 1][i], min);
            }
        }
        System.out.println(min);
    }
}
