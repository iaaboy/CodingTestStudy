package acmicpc31673;

import java.io.*;
import java.util.*;

/* 특별한 학생회장 교체
 * https://www.acmicpc.net/problem/31673
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 예산

        long[] v = new long[N];
        st = new StringTokenizer(bf.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            v[i] = Long.parseLong(st.nextToken());
            sum += v[i];
        }
        sum = sum / 2 + sum % 2;
        Arrays.sort(v);
        int count = N - 1;
        for (; count >= 0; count--) {
            sum -= (long) v[count];
            if (sum <= 0) {
                break;
            }
        }
        // System.out.println(Arrays.toString(v));
        System.out.println(M / (N - count + 1));
    }
}