package acmicpc2579;

import java.io.*;

/* 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        if (N == 1) {
            System.out.println(arr[0]);            
            return;
        } else if (N == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        int [] sum = new int[N];
        sum[0] = arr[0];
        sum[1] = arr[0] + arr[1];
        sum[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
        for (int i = 3; i < arr.length; i++) {
            int oneStep = sum[i - 3] + arr[i] + arr[i - 1]; 
            int twoStep = sum[i - 2] + arr[i];
            sum[i] = Math.max(oneStep, twoStep);
        }
        System.out.println(sum[N-1]);
    }
}
