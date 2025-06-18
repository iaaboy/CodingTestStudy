package acmicpc6986;

import java.io.*;
import java.util.*;

/* 절사평균
 * https://www.acmicpc.net/problem/6986
 * 부동소수점...
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(bf.readLine());
        }
        Arrays.sort(nums);
        for (int i = 0; i < K; i++) {
            nums[i] = 0;
            nums[N - 1 - i] = 0;
        }
        double sum1 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += nums[i];
        }
        // System.out.println(Arrays.toString(nums));
        double sum2 = sum1;
        System.out.printf("%.2f\n", sum1 / (N - 2 * K));
        sum2 += nums[K] * K;
        sum2 += nums[N - K - 1] * K;
        System.out.printf("%.2f\n", sum2 / N);
    }
}
