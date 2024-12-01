package acmicpc10989;

import java.io.*;

/*
 * https://www.acmicpc.net/problem/10989
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[10001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(bf.readLine())]++;
        }
        // System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
