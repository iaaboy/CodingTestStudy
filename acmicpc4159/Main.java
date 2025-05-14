package acmicpc4159;

import java.io.*;
import java.util.*;

/* 알래스카
 * https://www.acmicpc.net/problem/4159
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int [] arr = new int[N + 2];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(bf.readLine());
            }
            arr[N] = 0;
            arr[N + 1] = 1422;
            Arrays.sort(arr);
            arr[N + 1] = arr[N + 1] + (arr[N + 1] - arr[N]);
            int prev = 0;
            String result = "POSSIBLE";
            for (int arr2 : arr) {
                if (Math.abs(prev - arr2) > 200) {
                    result = "IMPOSSIBLE";
                    break;
                }
                prev = arr2;
            }
            sb.append(result).append("\n");
            N = Integer.parseInt(bf.readLine()); 
        }
        System.out.print(sb);
    }
}
