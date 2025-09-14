package acmicpc1052;

import java.io.*;
import java.util.*;

/* 물병
 * https://www.acmicpc.net/problem/1052
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (Integer.bitCount(N) > K) {
            // System.out.println(N + " : " + Integer.toBinaryString(N));
            int lowBit = N & -N;
            answer += lowBit;
            N += lowBit;
        }
        System.out.println(answer);
    }
}
