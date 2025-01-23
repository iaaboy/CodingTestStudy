package acmicpc1806;

import java.io.*;
import java.util.*;

/* 부분합
 * https://www.acmicpc.net/problem/1806
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int r = 0;
        int l = 0;
        long sum = arr[0];
        int count = Integer.MAX_VALUE;
        while (l < N && r < N) {
            if (sum >= K) {
                // System.out.println("*** ll " + l + ".." + r + ":" + sum + " .. " + (r - l +
                // 1));
                count = Math.min(count, r - l + 1);
            }
            // System.out.println(l + ".." + r + ":" + sum);
            if (sum > K) {
                sum -= arr[l];
                l++;
            } else { // sum <= K
                r++;
                sum += arr[r];
            }
            if (sum >= K) {
                // System.out.println("*** ll " + l + ".." + r + ":" + sum + " .. " + (r - l +
                // 1));
                count = Math.min(count, r - l + 1);
            }
        }
        if (count == Integer.MAX_VALUE) {
            count = 0;
        }
        System.out.println(count);
    }
}