package acmicpc1535;

import java.io.*;
import java.util.*;

/* 안녕
 * https://www.acmicpc.net/problem/1535
 * 주석) thx to gpt
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 N 입력 받기
        int N = Integer.parseInt(bf.readLine());

        // 각 사람에게 인사할 때 소모되는 체력(health)과 얻는 기쁨(joy)을 저장할 배열
        int[] health = new int[N];
        int[] joy = new int[N];

        // 첫 번째 줄: 체력 소모량 입력
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        // 두 번째 줄: 각 사람과 인사할 때 얻는 기쁨 입력
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 기쁨값을 저장할 변수
        int max = 0;

        // DP 배열: spent[i][j]는 i번째 사람까지 고려했을 때, 총 j만큼 체력을 소모하여 얻을 수 있는 최대 기쁨
        // 체력은 최대 100 미만이어야 하므로 [N][101]로 생성
        int[][] spent = new int[N][101];

        // 배열 초기화: 모든 값을 -1로 설정하여 "불가능한 상태"를 표시
        for (int i = 0; i < N; i++) {
            Arrays.fill(spent[i], -1);
            spent[i][0] = 0; // 체력을 0만큼 쓴 상태는 항상 가능하며, 기쁨은 0
        }

        // 첫 번째 사람을 고려: 체력을 써도 100 미만이면, 해당 상태 갱신
        if (health[0] < 100) {
            spent[0][health[0]] = joy[0];
            max = Math.max(spent[0][health[0]], max);
        }

        // DP 점화식 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 100; j++) {
                // 만약 현재 사람과 인사할 체력이 충분하다면,
                if (j - health[i] >= 0 && spent[i - 1][j - health[i]] != -1) {
                    // 이전 상태에서 이어오거나, 현재 사람과 인사해서 joy[i]를 추가하는 경우 중 큰 값 선택
                    spent[i][j] = Math.max(spent[i - 1][j], spent[i - 1][j - health[i]] + joy[i]);
                    max = Math.max(spent[i][j], max);
                }
                // 인사를 하지 않는 경우도 고려
                else if (spent[i - 1][j] >= 0) {
                    spent[i][j] = spent[i - 1][j];
                    max = Math.max(spent[i][j], max);
                }
            }
        }

        // 최종적으로 구한 최대 기쁨 출력
        System.out.println(max);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(spent[i][j] + " ");
            }
            System.out.println();
        }
    }
}
