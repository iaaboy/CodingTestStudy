package acmicpc11726;

import java.io.*;

/* 2×n 타일링
 * https://www.acmicpc.net/problem/11726
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        if (N != 1) {
            arr[2] = 2;
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            }
        }
        System.out.println(arr[N]);
    }
}
