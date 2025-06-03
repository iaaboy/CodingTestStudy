package acmicpc28081;

import java.io.*;
import java.util.*;

/* 직사각형 피자 풀이
 * https://www.acmicpc.net/problem/28081
 * 이분탐색, K input(Long)에 주의 K <= W * H
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        Scanner sc = new Scanner(System.in);
        // int W = Integer.parseInt(st.nextToken());
        // int H = Integer.parseInt(st.nextToken());
        // int K = Integer.parseInt(st.nextToken());
        long W = sc.nextLong();
        long H = sc.nextLong();
        long K = sc.nextLong();
         

        // int N = Integer.parseInt(bf.readLine());
        int N = sc.nextInt();
        long[] cutX = new long[N + 1];
        // st = new StringTokenizer(bf.readLine());
        long prev = 0;
        for (int i = 0; i < N; i++) {
            // int num = Integer.parseInt(st.nextToken());
            long num = sc.nextLong();
            cutX[i] = num - prev;
            prev = num;
        }
        cutX[N] = H - prev;

        // int M = Integer.parseInt(bf.readLine());
        int M = sc.nextInt();
        long[] cutY = new long[M + 1];
        prev = 0;
        // st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            // int num = Integer.parseInt(st.nextToken());
            long num = sc.nextLong();
            cutY[i] = num - prev;
            prev = num;
        }
        cutY[M] = W - prev;

        Arrays.sort(cutX);
        Arrays.sort(cutY);
        // System.out.println(Arrays.toString(cutX));
        // System.out.println(Arrays.toString(cutY));
        long count = 0;
        for (int i = 0; i < cutX.length; i++) {
            int leqIdx = lastLEQ(cutY, cutX[i], K);
            // System.out.println(cutX[i] + ":" + leqIdx);
            if (leqIdx >= 0) {
                count += (leqIdx + 1);
            }
        }
        System.out.println(count);
    }

    private static int lastLEQ(long[] arr, long multi, long k) {
        int left = 0, right = arr.length - 1;
        int result = -1; // 결과가 없을 경우 -1

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] * multi <= k) {
                result = mid; // 후보 저장
                left = mid + 1; // 오른쪽을 더 탐색
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
