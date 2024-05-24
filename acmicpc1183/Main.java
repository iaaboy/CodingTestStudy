package acmicpc1183;

import java.io.*;
import java.util.*;

/* 약속
 * https://www.acmicpc.net/problem/1183
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        if (N % 2 == 1) {
            System.out.println(1);
        } else {
            System.out.println(Math.abs(arr[N / 2] - arr[N / 2 - 1]) + 1);
        }
    }
}
