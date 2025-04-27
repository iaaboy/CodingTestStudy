package LisDp;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] { 10, 20, 10, 30, 20, 50 };
        int N = arr.length;
        // 각 위치까지의 최장 증가 부분 수열(LIS) 길이를 저장할 배열
        int[] dp = new int[N];
        // 최장 증가 부분 수열의 전체 최대 길이를 저장하는 변수
        int max = 1;

        for (int i = 0; i < N; i++) {
            // 최소 자기 자신 하나는 수열이 될 수 있으므로 dp[i]를 1로 초기화
            dp[i] = 1;
            // 현재 i번째 원소 이전의 모든 원소를 검사
            for (int j = 0; j < i; j++) {
                // 이전 원소(arr[j])가 현재 원소(arr[i])보다 작을 때만 증가 수열이 가능
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    // j까지의 수열에 arr[i]를 추가하는 것이 더 긴 수열을 만든다면 갱신
                    dp[i] = dp[j] + 1;
                    // 전체 최장 길이도 함께 갱신
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }

        // 각 인덱스별 LIS 길이 배열 출력 (디버깅용)
        System.out.println(Arrays.toString(dp));

        // 결과를 출력할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // [아래 주석 처리된 부분]은 최장 증가 부분 수열의 실제 원소들을 구하는 코드
        // 최장 길이(max)부터 시작해서, dp[i]가 curMax인 원소를 거꾸로 찾아가며 결과에 추가하는 방식
        // 이걸 풀어주면 실제 증가 수열을 출력할 수 있다.
        //
        // int curMax = max;
        // for (int i = N - 1; i >= 0; i--) {
        // if (dp[i] == curMax) {
        // sb.insert(0, arr[i] + " "); // 맨 앞에 원소 추가
        // curMax--; // 다음으로 작은 수를 찾기 위해 curMax를 감소
        // }
        // }
        // sb.insert(0, max + "\n").append("\n");

        // 현재는 최장 길이(max)만 출력
        sb.append(max).append("\n");

        // 결과 출력
        System.out.print(sb);
    }
}
