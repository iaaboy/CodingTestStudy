package acmicpc31848;

import java.io.*;
import java.util.*;

/* 엉성한 도토리 분류기
 * https://www.acmicpc.net/problem/31848
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] hole = new int[N];
        int prevMax = 0;
        for (int i = 0; i < N; i++) {
            hole[i] = Integer.parseInt(st.nextToken()) + i;
            if (hole[i] > prevMax) {
                prevMax = hole[i];
            } else {
                hole[i] = prevMax;
            }
        }

        // System.out.println("\n" + Arrays.toString(hole));

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int inNum = Integer.parseInt(st.nextToken());
            sb.append(lowerBound(hole, inNum) + " ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}
