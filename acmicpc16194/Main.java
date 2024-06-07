package acmicpc16194;

import java.io.*;
import java.util.*;

/* 카드 구매하기 2
 * https://www.acmicpc.net/problem/16194
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] card = new int[N + 1];
        int[] memo = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            memo[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                memo[i] = Math.max(memo[i], memo[i - j] + card[j]);
            }
        }
        System.out.println(memo[N]);
    }
}
