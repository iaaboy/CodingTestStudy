package acmicpc11578;

import java.io.*;
import java.util.*;

/* 팀원 모집
 * https://www.acmicpc.net/problem/11578
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] score = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int bit = Integer.parseInt(st.nextToken()) - 1;
                int mask = 1 << bit;
                score[i] |= mask;
            }
        }
        int loopMax = (int) Math.pow(2, M);
        int filterMax = (int) Math.pow(2, N) - 1;
        int minCount = Integer.MAX_VALUE;
        int mask;
        for (int i = 0; i < loopMax; i++) {
            int sum = 0;
            int count = 0;
            for (int bit = M; bit >= 0; bit--) {
                mask = 1 << bit;
                if ((i & mask) > 0) {
                    sum |= score[bit];
                    count++;
                }
            }
            if (sum == filterMax) {
                minCount = Math.min(minCount, count);
            }
//            System.out.println(Integer.toBinaryString(i) + " " + Integer.toBinaryString(sum) + " " + count);
        }
        if(minCount == Integer.MAX_VALUE) {
            minCount = -1;
        }
        System.out.println(minCount);
    }
}