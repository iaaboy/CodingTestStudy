package acmicpc15988;

import java.io.*;

/* 1, 2, 3 더하기 3
 * https://www.acmicpc.net/problem/15988
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            long arr[] = new long[N + 4];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for (int i = 4; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009;
            }
            sb.append(arr[N]).append("\n");
        }
        System.out.print(sb);
    }
}