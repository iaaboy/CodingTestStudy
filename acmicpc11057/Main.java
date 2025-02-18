package acmicpc11057;

import java.io.*;
import java.util.*;

/* 오르막 수
 * https://www.acmicpc.net/problem/11057
 */

public class Main {
    static int MOD = 10_007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (j < k) {
                        arr[i][j] += arr[i - 1][k] % MOD;
                    }
                }
                arr[i][j] += arr[i - 1][j] % MOD;
            }
        }
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(Arrays.toString(arr[i]));
        // }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += (long) arr[N][i] % MOD;
        }
        System.out.println(sum % MOD);
    }
}
