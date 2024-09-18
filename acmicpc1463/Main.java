package acmicpc1463;

import java.io.*;
import java.util.*;

/* 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[N] = 0;
        for (int i = N; i >= 1; i--) {
            int curCount = arr[i];
            if (i % 3 == 0 && i / 3 > 0) {
                arr[i / 3] = Math.min(arr[i / 3], curCount + 1);
            }
            if (i % 2 == 0 && i / 2 > 0) {
                arr[i / 2] = Math.min(arr[i / 2], curCount + 1);
            }
            arr[i - 1] = Math.min(arr[i - 1], curCount + 1);
        }
        System.out.println(arr[1]);
    }
}
