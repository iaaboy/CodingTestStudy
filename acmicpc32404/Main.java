package acmicpc32404;

import java.io.*;
import java.util.*;

/* 일이 커졌어
 * https://www.acmicpc.net/problem/32404
 */

public class Main {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        int num = N;
        for (int i = N - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                arr[i] = num--;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                arr[i] = num--;
            }
        }
        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
    }
}
