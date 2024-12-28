package acmicpc2746;

import java.io.*;
import java.util.*;

/*
 * 못 푼문제
 */

public class Main {
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int n = N;
        arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        long s = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 값의 빈도를 저장하는 배열 초기화
        int[] num = new int[1000001];
        for (int i = 0; i < N; i++) {
            int numIn = Integer.parseInt(st.nextToken());
            arr[i] = numIn;
            s += numIn;
            num[numIn]++;
        }
        Arrays.sort(arr);
        Set<Integer> arrSet = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            arrSet.add(arr[i]);
        }

        long ans = 0;
        long s1 = s - arr[n - 1]; // 최댓값 제외한 합

        // 최댓값 제외 (중복 방지)
        num[arr[n - 1]]--;

        // 배열의 최대값 제외한 요소들에 대해 가능한 쌍 계산
        for (int i = 0; i < n - 1; i++) {
            int current = arr[i];
            if (s1 - current - arr[n - 1] >= 0 && s1 - current - arr[n - 1] <= 1000000) {
                int target = (int) (s1 - current - arr[n - 1]);
                if (num[target] > 0) {
                    if (target == current) {
                        ans += (long) num[target] * (num[target] - 1);
                    } else {
                        ans += (long) num[target] * num[current];
                    }
                }
            }
        }

        // 중복 계산 제거 (각 쌍이 두 번씩 계산되었으므로 나눔)
        ans /= 2;

        System.out.println("ans: " + ans);

        // 두 번째로 큰 값을 처리
        num[arr[n - 2]]--; // 두 번째 최댓값 제외
        long s2 = s1 - arr[n - 2]; // 두 번째로 큰 값 제외한 합

        // s2 - arr[n-2]가 유효한 범위 내에 있는 경우
        if (s2 - arr[n - 2] >= 0 && s2 - arr[n - 2] <= 1000000) {
            ans += num[(int) (s2 - arr[n - 2])];
        }
        System.out.println("ans : " + ans);

        // s2 - arr[n-3]이 세 번째 최댓값(arr[n-3])과 같은 경우
        if (n >= 3 && s2 - arr[n - 3] == arr[n - 3]) {
            ans += 1;
        }
        System.out.println(Arrays.toString(arr));

        // 결과 출력
        System.out.println(ans);
    }
}
