package acmicpc13397;

import java.io.*;
import java.util.*;

/* https://www.acmicpc.net/problem/13397
 * 구간 나누기 2 
 */

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int left = 0;
        int right = -1;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (getCount(mid) <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // for (int i = 0; i < 10; i++) {
        // System.out.println(i + ":" + isValid(i));
        // }

        System.out.println(right);
    }

    private static int getCount(int mid) {
        int cnt = 1;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < N; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];

            if (max - min > mid) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt;
    }
}
