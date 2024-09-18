package acmicpc30405;

import java.io.*;
import java.util.*;

/* 박물관 견학
 * https://www.acmicpc.net/problem/30405
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[K];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j < n - 2; j++) {
                Integer.parseInt(st.nextToken());
            }
            int end = Integer.parseInt(st.nextToken()) - 1;
            arr[start]++;
            arr[end]++;
            sum += 2;
        }
        int leftSum = 0;
        for (int i = 0; i < K; i++) {
            leftSum += arr[i];
            if ((sum + 1) / 2 <= leftSum) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
