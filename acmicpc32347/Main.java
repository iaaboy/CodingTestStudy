package acmicpc32347;

import java.io.*;
import java.util.*;

/* 시간을 돌리고 싶어
* GPT 주석추가
 * https://www.acmicpc.net/problem/32347
 */

public class Main {
    // arr: 주어진 배열, 각 위치는 특정 시간을 나타냄
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: N (배열 길이), K (타임머신 사용 가능 횟수)
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 배열 초기화
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 값 입력
        }

        // 이분 탐색을 위한 초기 설정
        int left = 0; // 최소 날짜
        int right = N - 1; // 최대 날짜
        
        // 이분 탐색 시작
        while (left < right) {
            int center = (left + right) / 2; // 중앙 날짜 계산
            if (checkTimeMachine(center, K)) { 
                // 중앙 날짜로 리셋 가능한 경우, 더 작은 날짜도 가능한지 확인
                right = center;
            } else {
                // 불가능한 경우, 더 큰 날짜를 탐색
                left = center + 1;
            }
        }
        
        // 가능한 최소 날짜 출력
        System.out.println(right);
    }

    /**
     * 주어진 날짜(date)에서 타임머신을 K번 사용하여 초기 시점(0)으로 돌아갈 수 있는지 확인
     * @param date 타임머신 리셋할 날짜
     * @param K 타임머신 사용 가능 횟수
     * @return 초기 시점으로 돌아갈 수 있으면 true, 그렇지 않으면 false
     */
    private static boolean checkTimeMachine(int date, int K) {
        int current = arr.length - 1; // 배열의 마지막 위치에서 시작
        while (K > 0) { // 타임머신 사용 가능 횟수 동안 반복
            int next = getNext(current, date); // date 이전에 존재하는 타임머신의 위치 탐색
            if (next == -1) { 
                // 타임머신을 사용할 수 없는 경우
                return false;
            } else if (next == 0) {
                // 초기 시점(0)에 도달한 경우
                return true;
            }
            K--; // 타임머신 사용 횟수 감소
            current = next; // 현재 위치를 업데이트
        }
        return false; // K번 사용 후에도 초기 시점에 도달하지 못한 경우
    }

    /**
     * 주어진 시작 위치에서 date만큼 이전에 존재하는 타임머신의 위치를 탐색
     * @param start 탐색 시작 위치
     * @param date 타임머신 리셋 날짜
     * @return 찾은 타임머신 위치, 없으면 -1, 초기 시점에 도달하면 0
     */
    private static int getNext(int start, int date) {
        int result = -1; // 찾은 위치를 저장 (-1은 찾지 못함을 의미)
        if (start - date <= 0) {
            // date 이전이 초기 시점(0)보다 작거나 같은 경우 초기 시점으로 바로 이동 가능
            return 0;
        }
        int end = start - date; // 탐색 범위 설정 (start부터 start - date까지)
        for (int i = start - 1; i >= end; i--) {
            // 탐색 범위 내에서 타임머신이 존재하는 위치 찾기
            if (arr[i] == 1) {
                result = i;
            }
        }
        return result; // 찾은 위치 반환 (없으면 -1)
    }
}