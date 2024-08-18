package acmicpc17425;

import java.io.*;
import java.util.*;

/* 약수의 합
 * https://www.acmicpc.net/problem/17425
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            max = Math.max(max, arr[i]);
        }
        max++;
        long[] accumul = new long[max];
        Arrays.fill(accumul, 1);
        for (int i = 2; i < accumul.length; i++) {
            for (int j = i; j < accumul.length; j += i) {
                accumul[j] += i;
            }
        }
        for (int i = 2; i < accumul.length; i++) {
            accumul[i] += accumul[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(accumul[arr[i]] + "\n");
        }
        System.out.println(sb);
    }
}
