package acmicpc2467;

import java.util.*;
import java.io.*;

/* 용액
 * https://www.acmicpc.net/problem/2467
 */

public class Main {
    static int n;
    static List<Long> v = new ArrayList<>();
    // 결과로 출력할 두 값
    static long ans1, ans2;

    // 두 용액의 합이 0에 가장 가까운 값을 찾는 이분 탐색 메서드
    public static void binarySearch() {
        int left = 0; // 리스트의 시작 인덱스
        int right = n - 1; // 리스트의 끝 인덱스
        long res = v.get(left) + v.get(right); // 초기 합 계산
        ans1 = v.get(left); // 초기 결과값 설정 (왼쪽 값)
        ans2 = v.get(right); // 초기 결과값 설정 (오른쪽 값)

        // 투 포인터 탐색 시작
        while (left < right) {
            long tmp = v.get(left) + v.get(right); // 현재 두 용액의 합 계산

            // 절대값을 비교하여 0에 더 가까운 경우 결과 갱신
            if (Math.abs(tmp) < Math.abs(res)) {
                res = Math.abs(tmp); // 현재 최소 절대값 갱신
                ans1 = v.get(left); // 왼쪽 용액 값 저장
                ans2 = v.get(right); // 오른쪽 용액 값 저장
            }

            // 두 용액의 합이 음수면 더 큰 값으로 이동
            if (tmp < 0) {
                left++;
            } 
            // 두 용액의 합이 양수면 더 작은 값으로 이동
            else {
                right--;
            }
        }

        // 결과 출력
        System.out.println(ans1 + " " + ans2);
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 용액 개수 입력
        n = Integer.parseInt(br.readLine());
        // 용액 리스트 입력 (공백으로 구분된 정수)
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 리스트에 입력 값 추가
        for (int i = 0; i < n; i++) {
            v.add(Long.parseLong(st.nextToken()));
        }

        // 이분 탐색 실행
        binarySearch();
    }
}