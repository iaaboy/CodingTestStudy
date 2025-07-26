package acmicpc12865;

import java.io.*;
import java.util.*;

/* 평범한 배낭 다시 풀기
 * https://www.acmicpc.net/problem/12865
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건 수
        int K = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        int[] W = new int[N + 1]; // 무게 배열
        int[] V = new int[N + 1]; // 가치 배열

        // dp[i][j] = i번째 물건까지 고려했을 때, j 무게에서의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 각 물건 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        // DP 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 현재 물건을 담을 수 없으면 이전 값 그대로
                } else {
                    // 현재 물건을 선택했을 때와 안 했을 때 중 최대값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        // 결과 출력: 최대 가치
        System.out.println(dp[N][K]);

        // 역추적: 선택된 물건 추출
        int weight = K;
        List<Integer> selectedItems = new ArrayList<>();

        for (int i = N; i >= 1; i--) {
            // dp[i][weight] 값이 dp[i-1][weight]와 다르면 i번째 물건을 선택한 것
            if (dp[i][weight] != dp[i - 1][weight]) {
                selectedItems.add(i);          // i번째 물건 선택됨
                weight -= W[i];                // 무게 줄이기
            }
        }

        // 선택된 물건 출력 (오름차순 정렬)
        Collections.sort(selectedItems);
        System.out.println("선택된 물건 번호: " + selectedItems);

                // DP 테이블 전체 출력
        System.out.println("=== DP 테이블 출력 ===");
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }
    }
}
