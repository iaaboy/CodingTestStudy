package acmicpc1912;

import java.io.*;
import java.util.*;

/* 연속합
 * https://www.acmicpc.net/problem/1912
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] num = new int[N];
        int[] memo = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(num[i], max);
        }
        max = num[0];
        memo[0] = num[0];

        for (int i = 1; i < N; ++i) {
            memo[i] = Math.max(memo[i - 1] + num[i], num[i]);
            max = Math.max(memo[i], max);
        }
        System.out.println(max);
    }
}