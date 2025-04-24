package acmicpc28065;

import java.io.*;
import java.util.Arrays;

/* SW 수열 구하기
 * https://www.acmicpc.net/problem/28065
해 구성하기(?) .. 애드혹 같은...
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int idx = 1;
        for (int i = 0; i < N; i += 2) {
            arr[i] = idx++;
        }
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 0)
                arr[i] = idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
