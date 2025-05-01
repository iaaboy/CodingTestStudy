package acmicpc30459;

import java.io.*;
import java.util.*;

/* 현수막 걸기
 * https://www.acmicpc.net/problem/30459
 *  Set이용 중복 제거하고, 모든 가능한 밑변 길이를 저장
 *  이분 탐색(매개변수 탐색) 으로 가능한 K보다 작은 최대를 구한다.
 *  결과중 최대값을 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] pole = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            pole[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> posts = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff <= K) {
                    posts.add(diff);
                }
            }
        }
        int heightDouble = 2 * K;
        Arrays.sort(pole);
        double maxWidth = -1;
        for (Integer p : posts) {
            int idx = lastLEQ(pole, p, heightDouble);
            if (idx != -1) {
                maxWidth = Math.max(p * pole[idx], maxWidth);
            }
            // if (idx != -1) {
            // System.out.println(p + "-> " + pole[idx]);
            // } else {
            // System.out.println(p + " -> " + idx);
            // }
        }
        if (maxWidth == -1) {
            System.out.println((int) maxWidth);
        } else {
            System.out.printf("%.1f\n", maxWidth / 2);
        }

        // System.out.println(posts);
        // System.out.println(Arrays.toString(pole));

    }

    private static int lastLEQ(int[] arr, int baseLineLength, int k) {
        int left = 0, right = arr.length - 1;
        int result = -1; // 결과가 없을 경우 -1

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] * baseLineLength <= k) {
                result = mid; // 후보 저장
                left = mid + 1; // 오른쪽을 더 탐색
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
