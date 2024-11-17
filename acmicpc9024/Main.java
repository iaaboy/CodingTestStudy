package acmicpc9024;

import java.io.*;
import java.util.*;

/* 두 수의 합
 * https://www.acmicpc.net/problem/9024
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuffer sb = new StringBuffer();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int count = countMax(arr, K);
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static int countMax(int[] arr, int K) {
        int l = 0;
        int r = arr.length - 1;
        int ans = 2000000010;
        int cnt = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (Math.abs(sum - K) < Math.abs(ans - K)) {
                ans = sum;
                cnt = 1;
            } else if (Math.abs(sum - K) == Math.abs(ans - K)) {
                cnt++;
            }
            if (sum > K)
                r--;
            else
                l++;
        }
        return cnt;
    }
}
