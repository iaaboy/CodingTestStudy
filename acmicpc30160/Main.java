package acmicpc30160;

import java.io.*;
import java.util.*;

/* 제곱 가중치
 * https://www.acmicpc.net/problem/30160
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] S = new long[N + 1]; // a1+a2+...+ai 누적합
        long[] T = new long[N + 1]; // a1+3a2+5a3+...+(2i-1)ai 누적합

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + arr[i];
            T[i] = T[i - 1] + (2L * i - 1) * arr[i];
        }

        long tempSum = arr[1] * 1L * 1;

        StringBuilder sb = new StringBuilder();
        sb.append(tempSum).append(" ");

        
        for (int k = 2; k <= N; k++) {
            long Xk = 2L * k * S[k] - T[k];
            tempSum = tempSum + Xk;
            sb.append(tempSum).append(" ");
        }
        System.out.println(sb);
    }
}
