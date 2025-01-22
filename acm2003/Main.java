package acm2003;

import java.io.*;
import java.util.*;

/* 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        int l = 0;
        int sum = arr[0];
        int count = 0;

        while (l < N && r < N) {
            // System.out.println(l + ".." + r + ":" + sum);
            if (sum == K) {
                count++;
                sum -= arr[l];
                l++;
            } else if (sum > K) {
                sum -= arr[l];
                l++;
            } else { // sum < K
                r++;
                sum += arr[r];
            }
        }

        System.out.println(count);
    }
}
