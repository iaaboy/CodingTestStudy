package acmicpc10830;

import java.io.*;
import java.util.*;

/* 행렬 제곱
 * https://www.acmicpc.net/problem/10830
 */

class Main {
    static int n;
    static int[][] inArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        inArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inArr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] pResult = pow(inArr, b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(pResult[i][j] + " ");
                } else {
                    System.out.println(pResult[i][j] + " ");
                }
            }
        }
    }

    public static int[][] pow(int[][] arr, long e) {
        if (e == 1L) {
            return arr;
        }

        int[][] temp = pow(arr, e / 2);
        temp = multiply(temp, temp);
        if (e % 2 == 1) {
            return multiply(temp, inArr);
        } else {
            return temp;
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {

        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += (A[i][k] * B[k][j]) % 1000;
                }
                C[i][j] %= 1000;
            }
        }

        return C;
    }
}