package acmicpc11047;

import java.io.*;
import java.util.*;

/* 동전 0
 * https://www.acmicpc.net/problem/11047
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            int c = K / arr[i];
            if (c > 0) {
                count += c;
                K = K % arr[i];
                // System.out.println(arr[i] + "," + c + " K: " + K);
                if (K == 0) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
