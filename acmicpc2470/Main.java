package acmicpc2470;

import java.io.*;
import java.util.*;

/* 두 용액
 * https://www.acmicpc.net/problem/2470
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int minL = 0, minR = 0;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = Math.abs(arr[i] + arr[mid]);
                if (min > sum) {
                    min = sum;
                    minL = i;
                    minR = mid;
                    // System.out.println(arr[i] + "," + arr[mid]);
                }
                if (arr[mid] + arr[i] >= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // System.out.println("last: " + arr[i] + " " + arr[right]);
        }
        System.out.println(arr[minL] + " " + arr[minR]);
        // System.out.println(arr[minL] + arr[minR]);
    }
}
