package acmicpc2851;

import java.io.*;

/* 슈퍼 마리오
 *  https://www.acmicpc.net/problem/2851
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 10;
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + num;
        }

        int rIdx = 0;
        int minDiff = Integer.MAX_VALUE;

        // System.out.println(Arrays.toString(sum));

        for (int i = 1; i < sum.length; i++) {
            if (Math.abs(sum[i] - 100) <= minDiff) {
                rIdx = i;
                minDiff = Math.abs(sum[i] - 100);
            }
        }

        System.out.println(sum[rIdx]);
    }
}