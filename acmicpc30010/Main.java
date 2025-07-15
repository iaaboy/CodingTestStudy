package acmicpc30010;

import java.io.*;
import java.util.Arrays;

/* 잘못된 버블정렬
 * https://www.acmicpc.net/problem/30010
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] A = new int[N];
        A[0] = N;
        for (int i = 1; i < N; i++) {
            A[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ");
        for (int i = 1; i < N; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

        // System.out.println(Arrays.toString(A));
        // for (int i = N - 1; i > 0; i--) {
        //     for (int j = i - 1; j >= 0; j--) {
        //         if (A[j] > A[j + 1]) {
        //             System.out.print("switch ");
        //             int tmp = A[j];
        //             A[j] = A[j + 1];
        //             A[j + 1] = tmp;
        //         }
        //         System.out.println(j + "-" + (j + 1) + " ");
        //     }
        //     System.out.println(Arrays.toString(A));
        // }
        // System.out.println(Arrays.toString(A));
    }
}
