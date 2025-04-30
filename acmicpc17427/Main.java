package acmicpc17427;

import java.io.*;

/* 약수의 합 2
 * https://www.acmicpc.net/problem/17427
 */

public class Main {
    static long[] arr;
    static long sum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * i <= N; j++) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
