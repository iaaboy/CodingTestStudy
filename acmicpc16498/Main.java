package acmicpc16498;

import java.io.*;
import java.util.*;

/* 작은 벌점
 * https://www.acmicpc.net/problem/16498
 * 완전 탐색으로 풀음(자바기준 시간이 여유 있음). 이분탐색이 더 효율적임.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] a = new int[A];
        int[] b = new int[B];
        int[] c = new int[C];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < A; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < B; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                for (int j2 = 0; j2 < C; j2++) {
                    int diff = Math.max(a[i], Math.max(b[j], c[j2])) - Math.min(a[i], Math.min(b[j], c[j2]));
                    minDiff = Math.min(minDiff, diff);
                }
            }
        }
        System.out.println(minDiff);
    }
}
