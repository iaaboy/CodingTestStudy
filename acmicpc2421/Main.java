package acmicpc2421;

import java.io.*;
import java.util.*;

/* 저금통
 * https://www.acmicpc.net/problem/2421
 *  eratos + dp
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int digit = N >= 100 ? 1000 : N >= 10 ? 100 : 10;
        int num[][] = new int[N + 1][N + 1];
        int maxNum = N * digit + N;
        boolean[] eratos = new boolean[maxNum + 1];
        for (int i = 2; i <= maxNum / 2; i++) {
            for (int j = i * 2; j <= maxNum; j += i) {
                if (!eratos[j]) {
                    eratos[j] = true;// 소수가 아님.
                }
            }
        }
        eratos[11] = false;

        for (int i = 2; i <= N / 2; i++) {
            for (int j = i * 2; j <= N; j += i) {
                if (!eratos[j]) {
                    eratos[j] = true;
                }
            }
        }
        eratos[11] = true;

        // System.out.println(Arrays.toString(eratos));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int d = j >= 100 ? 1000 : j >= 10 ? 100 : 10;
                if (!eratos[i * d + j]) {
                    num[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                num[i][j] = num[i][j] + Math.max(num[i][j - 1], num[i - 1][j]);
            }
        }

        System.out.println(num[N][N]);
    }
}