package acmicpc10844;

import java.io.*;

/* 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[][] arr = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            long[] nextNum = new long[10];
            nextNum[1] += arr[i - 1][0] % 1000000000;
            for (int j = 1; j < 9; j++) {
                nextNum[j - 1] += arr[i - 1][j] % 1000000000;
                nextNum[j + 1] += arr[i - 1][j] % 1000000000;
            }
            nextNum[8] += arr[i - 1][9];
            for (int j = 0; j < 10; j++) {
                arr[i][j] = nextNum[j] % 1000000000;
            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[N][i] % 1000000000;
        }
        System.out.println(sum % 1000000000);
    }
}
